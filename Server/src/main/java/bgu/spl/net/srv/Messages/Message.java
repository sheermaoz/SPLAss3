package bgu.spl.net.srv.Messages;


import bgu.spl.net.Database;
import bgu.spl.net.srv.User;

public abstract class Message {

    short opcode;
    String strCommand = null;
    Database db;

    public Message(short _opcode)
    {
        opcode = _opcode;
        db = Database.getInstance();
    }

    public short getOpcode()
    {
        return opcode;
    }

    public abstract Object process(User usr);
}
