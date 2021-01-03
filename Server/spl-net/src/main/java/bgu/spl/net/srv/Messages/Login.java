package bgu.spl.net.srv.Messages;

import bgu.spl.net.srv.User;

public class Login extends Message {

    private String username;
    private String password;

    public Login() {
        super((short) 3);
    }

    @Override
    public void init(String str) {
        String[] args = str.split("\0");
        username = args[0];
        password = args[1];

    }

    @Override
    public User process(User usr) {
        if (usr != null)
        {
            return null;
        }
        return db.login(username, password);
    }
}
