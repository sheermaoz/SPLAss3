package bgu.spl.net.srv.Messages;

import java.util.Arrays;

import bgu.spl.net.srv.Type;
import bgu.spl.net.srv.User;

public class KdamCheck extends Message {

    private short courseNum;
    
    public KdamCheck() {
        super((short) 6);
    }

    @Override
    public void init(String str) {
       courseNum = Short.valueOf(str);

    }

    @Override
    public String process(User usr) {
        if (usr == null || usr.getType() == Type.Admin)
        {
            return null;
        }
        return Arrays.toString(db.checkKdam(courseNum));
    }
    
}
