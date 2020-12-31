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


    public abstract void init(String str);
    

    public String getInit()
    {
        return args;
    }

    public abstract Object process();
}
