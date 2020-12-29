package bgu.spl.net.srv.Messages;


public abstract class Message {
    short opcode;
    public Message(short _opcode)
    {
        opcode = _opcode;
    }

    public short getOpcode()
    {
        return opcode;
    }
}
