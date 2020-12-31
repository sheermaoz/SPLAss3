package bgu.spl.net.srv.Messages;

import bgu.spl.net.srv.User;

public abstract class Message {

    short opcode;
    String strCommand = null;

    public Message(short _opcode)
    {
        opcode = _opcode;
    }

    public short getOpcode()
    {
        return opcode;
    }


    public abstract void init(String input);


    public String getInit()
    {
        return strCommand;
    }

    public abstract Object process(User usr);
}
