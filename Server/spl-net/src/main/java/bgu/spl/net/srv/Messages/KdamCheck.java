package bgu.spl.net.srv.Messages;

import java.util.Arrays;

import bgu.spl.net.srv.Type;
import bgu.spl.net.srv.User;

public class KdamCheck extends Message {

    private short courseNum;
    
    public KdamCheck(String _num) {
        super((short) 6);
        courseNum = Short.valueOf(_num);
    }


    @Override
    public String process(User usr) {
        if (usr == null || usr.getType() == Type.Admin)
        {
            return null;
        }
        return Arrays.toString(db.checkKdam(courseNum)).replace(" ", "");
    }
    
}
