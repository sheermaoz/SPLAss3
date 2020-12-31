package bgu.spl.net.api;

import bgu.spl.net.srv.Messages.*;
import jdk.vm.ci.code.Register;

import java.util.Arrays;

public class MsgEncDec<Message> implements MessageEncoderDecoder<Message> {

    Message retMsg;
    private byte[] bytes = new byte[1 << 10]; //start with 1k
    private int len = 0;

    @Override
    public Message decodeNextByte(byte nextByte) {
        if (nextByte == '\0') {
            return popMsg();
        }
        retMsg=defineMessage(op_code);


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
        short op_code = bytesToShort(bytes);
        retMsg = defineMessage(op_code);
        return null;
    }

    private Message defineMessage(short op_code) {
        switch(op_code) {
            case 1:
                return (Message)new AdminRegister();
            case 2:
                return (Message)new StudentRegister();
            case 3:
                return (Message)new Login();
            case 4:
                return (Message)new Logout();
            case 5:
                return (Message)new CourseReg();
            case 6:
                return (Message)new KdamCheck();
            case 7:
                return (Message)new CourseStat();
            case 8:
                return (Message)new StudentStat();
            case 9:
                return (Message)new IsRegistered();
            case 10:
                return (Message)new Unregister();
            case 11:
                return (Message)new MyCourses();
            case 12:
                return (Message)new Ack();
            case 13:
                return (Message)new Err();


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
