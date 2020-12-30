package bgu.spl.net.srv.Messages;

public class Error extends Message<Short> {
    
    public Error(short _opcode)
    {
        super((short)13);
        args = new Short[1];
    }
    
}
