package bgu.spl.net.srv.Messages;

public class IsRegistered extends Message<Short> {

    public IsRegistered()
    {
        super((short)9);
        args = new Short[1];
    }
    
}
