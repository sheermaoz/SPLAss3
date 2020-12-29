package bgu.spl.net.srv.Messages;

public class Login extends Message {

    private String name;
    private String password;

    public Login(String _name, String _password)
    {
        super((short)3);
        name = _name;
        password = _password;
    }

    public String getName()
    {
        return name;
    }

    public String getPassword()
    {
        return password;
    }
    
}
