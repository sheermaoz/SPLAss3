package bgu.spl.net.srv.Messages;

public class Ack extends Message<String>{
    public Ack()
    {
        super((short)12);
        args = new String[2];
    }

}
