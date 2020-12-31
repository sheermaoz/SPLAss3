package bgu.spl.net.srv.Messages;


public abstract class Message {

    short opcode;
    String args;

    public Message(short _opcode)
    {
        opcode = _opcode;
    }

    public short getOpcode()
    {
        return opcode;
    }


    public void init(String str)
    {
        args = str;
    }

    public String getInit()
    {
        return args;
    }
}
