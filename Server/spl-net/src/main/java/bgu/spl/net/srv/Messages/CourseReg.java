package bgu.spl.net.srv.Messages;

import bgu.spl.net.Database;
import bgu.spl.net.srv.Type;
import bgu.spl.net.srv.User;

public class CourseReg extends Message {

    private Short courseNum;

    public CourseReg()
    {
        super((short)5);
    }

    @Override
    public void init(String str) {
        courseNum = Short.valueOf(str);

    }

    @Override
    public Boolean process(User user) {
        if (user == null || user.getType() == Type.Admin)
        {
            return false;
        }
        Database db = Database.getInstance();
        return db.courseRegister(user.getName(), courseNum);
    }

    
    
}
