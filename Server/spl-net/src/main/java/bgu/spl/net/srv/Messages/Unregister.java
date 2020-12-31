package bgu.spl.net.srv.Messages;

import bgu.spl.net.Database;
import bgu.spl.net.srv.Type;
import bgu.spl.net.srv.User;

public class Unregister extends Message {

    private short courseNum;

    public Unregister() {
        super((short) 10);
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
        Database db = Database.getInstance();
        return db.unregister(usr.getName(), courseNum);
    }
    
}
