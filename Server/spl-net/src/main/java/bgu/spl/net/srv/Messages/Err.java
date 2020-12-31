package bgu.spl.net.srv.Messages;


public class Err extends Message<Short> {
    
    public Err(short _opcode)
    {
        super((short)13);
        args = new Short[1];
    }
    
}
