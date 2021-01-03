package bgu.spl.net.srv.Messages;

import bgu.spl.net.srv.User;

public class Logout extends Message {

    public Logout() {
        super((short) 4);
    }

    @Override
    public void init(String str) {

    }

    @Override
    public Boolean process(User usr) {
        if (usr == null)
        {
            return null;
        }
        return true;
    }
    
}
