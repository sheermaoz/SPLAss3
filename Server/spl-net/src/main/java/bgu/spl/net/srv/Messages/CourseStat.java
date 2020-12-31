package bgu.spl.net.srv.Messages;

public class CourseStat extends Message<Short> {

    public CourseStat()
    {
        super((short)7);
        args = new Short[0];
    }
    
}
