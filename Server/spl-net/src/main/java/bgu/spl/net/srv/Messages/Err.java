package bgu.spl.net.srv.Messages;


public class Err extends Response {
    
    public Err(short resp)
    {
        super((short)13, resp);
    }

    @Override
    public String toString() {
        return "" + opCode + resp;
    }
    
}
