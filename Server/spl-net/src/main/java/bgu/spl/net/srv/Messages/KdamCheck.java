package bgu.spl.net.srv.Messages;

public class KdamCheck extends Message<Short> {

    public KdamCheck()
    {
        super((short)6);
        args = new Short[1];
    }
    
}
