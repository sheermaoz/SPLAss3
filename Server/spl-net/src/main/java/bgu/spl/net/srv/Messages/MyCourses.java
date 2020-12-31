package bgu.spl.net.srv.Messages;

import java.util.Arrays;

import bgu.spl.net.Database;
import bgu.spl.net.srv.Type;
import bgu.spl.net.srv.User;

public class MyCourses extends Message {

    public MyCourses() {
        super((short) 11);
    }

    @Override
    public void init(String str) {

    }

    @Override
    public String process(User usr) {
        if (usr == null || usr.getType() == Type.Admin)
        {
            return null;
        }
        Database db = Database.getInstance();
        return Arrays.toString(db.myCourses(usr.getName()));
    }
    
}
