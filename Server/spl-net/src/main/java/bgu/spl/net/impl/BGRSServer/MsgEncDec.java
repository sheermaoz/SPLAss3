package bgu.spl.net.impl.BGRSServer;


import bgu.spl.net.api.MessageEncoderDecoder;
import bgu.spl.net.srv.Messages.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class MsgEncDec implements MessageEncoderDecoder<Message> {

    Message retMsg;
    private byte[] bytes = new byte[1 << 10]; //start with 1k
    private int len = 0;
    short op_code = 0;
    int zeroCount = 0;
    int bytesAfterCode = 0;

    @Override
    public Message decodeNextByte(byte nextByte) {
        if(len == 0) {    //defining the op_code
            pushByte(nextByte);
            return null;
        }
        if(len == 1){
            pushByte(nextByte);
            op_code = bytesToShort(bytes);
            if(op_code == 4 | op_code == 11){  //no string commands
                return popMsg();
            }
            return null;
        }

        if(op_code == 1 | op_code == 2 | op_code == 3) {   //commands includes 2 zeros
            pushByte(nextByte);  //including the '0' in the string
            if (nextByte == '\0' && zeroCount == 1)
                return popMsg();
            if (nextByte == '\0'){
                zeroCount++;
                return null;
            }

            return null;
        }

        

        if(op_code == 5 | op_code == 6 | op_code == 7 | op_code == 9 | op_code == 10){  //2 bytes commands
            pushByte(nextByte);
            bytesAfterCode++;
            if(bytesAfterCode == 2)
                return popMsg();
            return null;
        }

        return null;
    }

    private void pushByte(byte nextByte) {
        if (len >= bytes.length) {
            bytes = Arrays.copyOf(bytes, len * 2);
        }

        bytes[len++] = nextByte;
    }

    private Message popMsg() {
        String result;
        if(op_code == 5 | op_code == 6 | op_code == 7 | op_code == 9 | op_code == 10){  //2 bytes commands
            result = Short.toString(bytesToShort(Arrays.copyOfRange(bytes, 2, 5)));
        }
        else
        {
            result = new String(bytes, 2, len, StandardCharsets.UTF_8);
        }
        retMsg = defineMessage(op_code, result );
        len = 0;
        zeroCount = 0;
        bytesAfterCode = 0;
        return retMsg;
    }


    private Message defineMessage(short op_code, String result) {
        switch(op_code) {
            case 1:
                return new AdminRegister(result);
            case 2:
                return new StudentRegister(result);
            case 3:
                return new Login(result);
            case 4:
                return new Logout();
            case 5:
                return new CourseReg(result);
            case 6:
                return new KdamCheck(result);
            case 7:
                return new CourseStat(result);
            case 8:{
                System.out.println("MAKING STUDENSTAT");
                return new StudentStat(result);}
            case 9:
                return new IsRegistered(result);
            case 10:
                return new Unregister(result);
            case 11:
                return new MyCourses();
        }

        return null;
    }

    @Override
    public byte[] encode(Message message) {
        short opCode = message.getOpcode();
        byte [] opByte = shortToBytes(opCode);
        byte [] result = new byte[0];
        short respCode;

        if (opCode == 12)
        {
            respCode = ((Ack)message).getResp();
            result = ((Ack)message).toString().getBytes();
        }
        else
        {
            respCode = ((Err)message).getResp();
        }
        
        byte[]  codeByte = shortToBytes(respCode);
        byte [] answer = new byte[result.length + 4];
        answer[0] = opByte[0];
        answer[1] = opByte[1];
        answer[2] = codeByte[0];
        answer[3] = codeByte[1];
        System.arraycopy(result, 0,answer, 4, result.length);
        return answer;

    }

    private short bytesToShort(byte[] byteArr)
    {
        short result = (short)((byteArr[0] & 0xff) << 8);
        result += (short)(byteArr[1] & 0xff);
        return result;
    }

    public byte[] shortToBytes(short num)
    {
        byte[] bytesArr = new byte[2];
        bytesArr[0] = (byte)((num >> 8) & 0xFF);
        bytesArr[1] = (byte)(num & 0xFF);
        return bytesArr;
    }
}
