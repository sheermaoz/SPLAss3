package bgu.spl.net.srv.Messages;

import bgu.spl.net.Database;
import bgu.spl.net.srv.Course;
import bgu.spl.net.srv.Type;
import bgu.spl.net.srv.User;

public class CourseStat extends Message {

    private Short courseNum;

    public CourseStat() {
        super((short) 7);
    }

    @Override
    public void init(String str) {
        courseNum = Short.valueOf(str);

    }

    @Override
    public String process(User usr) {
        if (usr.getType() == Type.User)
        {
            return null;
        }
        Database db = Database.getInstance();
        Course course = db.getCourse(courseNum);
        if (course == null)
        {
            return null;
        }
        return null;
    }
    
}
