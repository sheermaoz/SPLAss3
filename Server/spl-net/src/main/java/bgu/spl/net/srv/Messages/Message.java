package bgu.spl.net.srv.Messages;


public abstract class Message {

    short opcode;
    String MsgBody;

    public Message(short _opcode)
    {
        opcode = _opcode;
    }

    public short getOpcode()
    {
        return opcode;
    }

    public void initBody(byte[] bytes){

    }
}
