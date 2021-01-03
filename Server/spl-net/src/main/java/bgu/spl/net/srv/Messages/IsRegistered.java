package bgu.spl.net.srv.Messages;


import bgu.spl.net.srv.Type;
import bgu.spl.net.srv.User;

public class IsRegistered extends Message {

    private short courseNum;
    
    public IsRegistered() {
        super((short) 9);
    }

    @Override
    public void init(String str) {
        courseNum = Short.valueOf(str);

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
