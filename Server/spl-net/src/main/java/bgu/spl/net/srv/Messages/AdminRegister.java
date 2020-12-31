package bgu.spl.net.srv.Messages;

public class AdminRegister extends Message {
    
    private String username;
    private String password;

    public AdminRegister()
    {
        super((short)1);
        
    }

    public void init(String str)
    {
        String[] args = str.split("\0");
        username = args[0];
        password = args[1];
    }

    public <T> T process(T args) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
