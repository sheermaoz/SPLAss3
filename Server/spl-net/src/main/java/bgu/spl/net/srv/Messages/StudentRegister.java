package bgu.spl.net.srv.Messages;

import bgu.spl.net.srv.User;
import bgu.spl.net.srv.Type;

public class StudentRegister extends Message {

    private String username;
    private String password;
    
    public StudentRegister(String str)
    {
        super((short)2);
        String[] args = str.split("\0");
        username = args[0];
        password = args[1];
    }

    @Override
    public Boolean process(User user){
        if (user != null)
        {
            return null;
        }
        return db.register(username, Type.User, password);
    }
    
}
