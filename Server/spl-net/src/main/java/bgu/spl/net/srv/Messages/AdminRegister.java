package bgu.spl.net.srv.Messages;

public class AdminRegister extends Message<String> {
    
    public AdminRegister(String _name, String _pwd)
    {
        super((short)1);
        args = new String[2];
        args[0] = _name;
        args[1] = _pwd;
    }
    
}
