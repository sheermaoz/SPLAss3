package bgu.spl.net.srv.Messages;

public class Login extends Message<String> {

    public Login()  { super((short)3); }

    public Login(String _name, String _password)
    {
        super((short)3);
        args = new String[2];
    }
}
