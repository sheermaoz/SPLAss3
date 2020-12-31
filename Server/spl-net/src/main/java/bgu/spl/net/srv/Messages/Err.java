package bgu.spl.net.srv.Messages;

public class Err extends Message {

    private short replyCode;

    public Err(){ super((short)13); }
    
    public Err(short _opcode)
    {
        super((short)13);
        replyCode = _opcode;
    }
    
}
