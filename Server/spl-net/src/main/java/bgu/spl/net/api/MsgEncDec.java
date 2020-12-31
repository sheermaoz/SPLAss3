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
        short op_code=4;


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
