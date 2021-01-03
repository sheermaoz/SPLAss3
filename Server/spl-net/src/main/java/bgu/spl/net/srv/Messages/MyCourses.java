package bgu.spl.net.srv.Messages;

import java.util.Arrays;
import bgu.spl.net.srv.Type;
import bgu.spl.net.srv.User;

public class MyCourses extends Message {

    public MyCourses() {
        super((short) 11);
    }


    @Override
    public String process(User usr) {
        if (usr == null || usr.getType() == Type.Admin)
        {
            return null;
        }
        return Arrays.toString(db.myCourses(usr.getName()));
    }
    
}
