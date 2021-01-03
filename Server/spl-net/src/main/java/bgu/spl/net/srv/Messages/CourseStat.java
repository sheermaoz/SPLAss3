package bgu.spl.net.srv.Messages;

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
        if (usr == null || usr.getType() == Type.User)
        {
            return null;
        }
        return db.courseStatus(courseNum);
    }
    
}
