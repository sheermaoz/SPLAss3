package bgu.spl.net.srv;

public class User {
    private String name;
    private Type type;
    private String password;

    public User(String _name, Type _type, String _pass)
    {
        name = _name;
        type = _type;
        password = _pass;
    }

    public String getName()
    {
        return name;
    }

    public Type getType()
    {
        return type;
    }

    public String getPassword()
    {
        return password;
    }
    
}
