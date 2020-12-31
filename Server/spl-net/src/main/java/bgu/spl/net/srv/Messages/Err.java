package bgu.spl.net.srv.Messages,*;


public class Err extends Response {
    
    public Err(short _opcode)
    {
        super((short)13);
    }
    
}
