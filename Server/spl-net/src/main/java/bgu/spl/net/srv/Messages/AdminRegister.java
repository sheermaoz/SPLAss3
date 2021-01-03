package bgu.spl.net.srv.Messages;

import bgu.spl.net.srv.Type;
import bgu.spl.net.srv.User;

public class AdminRegister extends Message {
    
    private String username;
    private String password;

    public AdminRegister(String str)
    {
        super((short)1);
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
        return db.register(username, Type.Admin, password);
    }
    
}
