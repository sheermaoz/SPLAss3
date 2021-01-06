package bgu.spl.net.srv;

import java.util.LinkedList;
import java.util.List;

public class User {
    private String name;
    private Type type;
    private String password;
    private List<Short> courses;
    private boolean loggedIn;

    public User(String _name, Type _type, String _pass)
    {
        name = _name;
        type = _type;
        password = _pass;
        courses = new LinkedList<>();
        loggedIn = false;
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

    public void register(short num)
    {
        courses.add(num);
    }

    public boolean contains(short num)
    {
        return courses.contains(num);
    }

    public void unregister(short num)
    {
        int ind = courses.indexOf(num);
        courses.remove(ind);
    }

    public List<Short> getCourses()
    {
        return courses;
    }

    public void login()
    {
        loggedIn = true;
    }

    public void logout()
    {
        loggedIn = false;
    }

    public boolean isLoggedIn()
    {
        return loggedIn;
    }
    
}
