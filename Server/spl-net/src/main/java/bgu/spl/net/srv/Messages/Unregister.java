package bgu.spl.net.srv.Messages;

import bgu.spl.net.srv.Type;
import bgu.spl.net.srv.User;

public class Unregister extends Message {

    private short courseNum;

    public Unregister(String _num) {
        super((short) 10);
        courseNum = Short.valueOf(_num);
    }

    @Override
    public Boolean process(User usr) {
        if (usr == null || usr.getType() == Type.Admin)
        {
            return null;
        }
        return db.unregister(usr.getName(), courseNum);
    }
    
}
