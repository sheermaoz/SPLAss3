package bgu.spl.net.srv.Messages;

public class Ack extends Response{
    
    private String args;
    
    public Ack(short resp)
    {
        super((short)12, resp);
    }

    public void addArg(String arg)
    {
        args = args + arg;
    }

    public String toString()
    {
        return  "" + opCode + resp + args + "\0";
    }

}
