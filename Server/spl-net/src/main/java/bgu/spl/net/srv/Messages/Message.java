package bgu.spl.net.srv.Messages;


public abstract class Message<T> {
    short opcode;
    T [] args;
    public Message(short _opcode)
    {
        opcode = _opcode;
    }

    public short getOpcode()
    {
        return opcode;
    }

    public T [] getArgs()
    {
        return args;
    }
}
