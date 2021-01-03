package bgu.spl.net.srv.Messages;

import bgu.spl.net.srv.Type;
import bgu.spl.net.srv.User;

public class CourseStat extends Message {

    private Short courseNum;

    public CourseStat(String _num) {
        super((short) 7);
        courseNum = Short.valueOf(_num);
    }

    @Override
    public String process(User usr) {
        if (usr == null || usr.getType() == Type.User)
        {
            return null;
        }
        return db.courseStatus(courseNum);
    }
    
}
