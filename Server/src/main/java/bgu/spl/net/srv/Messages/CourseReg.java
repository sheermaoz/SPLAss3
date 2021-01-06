package bgu.spl.net.srv.Messages;

import bgu.spl.net.srv.Type;
import bgu.spl.net.srv.User;

public class CourseReg extends Message {

    private Short courseNum;

    public CourseReg(String _num)
    {
        super((short)5);
        courseNum = Short.valueOf(_num);
    }

    @Override
    public Boolean process(User user) {
        if (user == null || user.getType() == Type.Admin)
        {
            return null;
        }
        return db.courseRegister(user.getName(), courseNum);
    }

    
    
}
