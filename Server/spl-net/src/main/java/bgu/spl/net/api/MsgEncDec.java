package bgu.spl.net.api;


import bgu.spl.net.srv.Messages.*;

import java.util.Arrays;

public class MsgEncDec implements MessageEncoderDecoder<Message> {

    Message retMsg;
    private byte[] bytes = new byte[1 << 10]; //start with 1k
    private int len = 0;
    short op_code = 0;
    int zeroCount = 0;

    @Override
    public Message decodeNextByte(byte nextByte) {
        if(len == 0) {
            len++;
            return null;
        }
        if(len == 1){
            op_code = bytesToShort(bytes);
            return null;
        }
        if(op_code == 1 | op_code == 2 | op_code == 3) {
            if (nextByte == '0' && zeroCount == 1) {
                pushByte(nextByte);    //including the '0' in the string
                return popMsgTwoZeros();
            }
            if (nextByte == '0'){
                zeroCount++;
                pushByte(nextByte);    //including the '0' in the string
                return null;
            }
        }

        pushByte(nextByte);
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
        return null;
    }

    private Message popMsgTwoZeros() {
        retMsg = defineMessage(op_code);
        return null;
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
