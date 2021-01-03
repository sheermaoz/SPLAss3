package bgu.spl.net.srv.Messages;

import java.util.Arrays;

import bgu.spl.net.srv.Type;
import bgu.spl.net.srv.User;

public class StudentStat extends Message {

    private String name;

    public StudentStat(String _name) {
        super((short) 8);
        name = _name;
    }


    @Override
    public Object process(User usr) {
        if (usr == null || usr.getType() == Type.User)
        {
            return null;
        }
        String reply = Arrays.toString(db.myCourses(name));
        reply = "Student: " + usr.getName() + "\nCourses: " + reply;
        return reply;
    }
    
}
