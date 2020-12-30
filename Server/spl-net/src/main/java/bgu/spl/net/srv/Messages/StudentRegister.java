package bgu.spl.net.srv.Messages;

public class StudentRegister extends Message<String> {

    public StudentRegister(String _name, String _pwd)
    {
        super((short)2);
        args = new String[2];
        args[0] = _name;
        args[1] = _pwd;
    }
    
}
