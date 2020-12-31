package bgu.spl.net.srv.Messages;

import java.util.Arrays;

import bgu.spl.net.Database;
import bgu.spl.net.srv.Type;
import bgu.spl.net.srv.User;

public class StudentStat extends Message {

    private String name;

    public StudentStat() {
        super((short) 8);
    }

    @Override
    public void init(String str) {
       name = str;

    }

    @Override
    public Object process(User usr) {
        if (usr == null || usr.getType() == Type.User)
        {
            return null;
        }
        Database db = Database.getInstance();
        String reply = Arrays.toString(db.myCourses(name));
        reply = "Student: " + usr.getName() + "\nCourses: " + reply;
        return reply;
    }
    
}
