package bgu.spl.net.srv.Messages;

public class Error extends Message {

    private short replyCode;
    
    public Error(short _opcode)
    {
        super((short)13);
        replyCode = _opcode;
    }
    
}
