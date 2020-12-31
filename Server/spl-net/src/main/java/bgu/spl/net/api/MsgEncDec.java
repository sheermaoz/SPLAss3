package bgu.spl.net.api;


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
            len++;
            pushByte(nextByte);
            return null;
        }
        if(len == 1){
            pushByte(nextByte);
            op_code = bytesToShort(bytes);
            return null;
        }

        if(op_code == 1 | op_code == 2 | op_code == 3) {   //commands includes 2 zeros
            pushByte(nextByte);  //including the '0' in the string
            if (nextByte == '0' && zeroCount == 1)
                return popMsg();
            if (nextByte == '0'){
                zeroCount++;
                return null;
            }

            return null;
        }

        if(op_code == 4 | op_code == 11){  //no string commands
            return popMsg();
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
        retMsg = defineMessage(op_code);
        String result = new String(bytes, 2, len, StandardCharsets.UTF_8);
        retMsg.init(result);


        len = 0;
        return retMsg;
    }


    private Message defineMessage(short op_code) {
        switch(op_code) {
            case 1:
                return new AdminRegister();
            case 2:
                return new StudentRegister();
            case 3:
                return new Login();
            case 4:
                return new Logout();
            case 5:
                return new CourseReg();
            case 6:
                return new KdamCheck();
            case 7:
                return new CourseStat();
            case 8:
                return new StudentStat();
            case 9:
                return new IsRegistered();
            case 10:
                return new Unregister();
            case 11:
                return new MyCourses();
        }

        return null;
    }

    @Override
    public byte[] encode(Message message) {
        return new byte[0];
    }

    private short bytesToShort(byte[] byteArr)
    {
        short result = (short)((byteArr[0] & 0xff) << 8);
        result += (short)(byteArr[1] & 0xff);
        return result;
    }
}
