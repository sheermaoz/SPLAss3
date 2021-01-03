package bgu.spl.net.srv.Messages;


import bgu.spl.net.srv.Type;
import bgu.spl.net.srv.User;

public class IsRegistered extends Message {

    private short courseNum;
    
    public IsRegistered(String _num) {
        super((short) 9);
        courseNum = Short.valueOf(_num);
    }

    @Override
    public Boolean process(User usr) {
        if (usr == null || usr.getType() == Type.Admin)
        {
            return null;
        }
        return db.isRegistered(usr.getName(), courseNum);
    }
    
}
