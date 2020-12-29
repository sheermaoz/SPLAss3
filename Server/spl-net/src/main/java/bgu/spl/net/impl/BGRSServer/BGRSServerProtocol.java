package bgu.spl.net.impl.BGRSServer;

import bgu.spl.net.Database;
import bgu.spl.net.api.MessagingProtocol;
import bgu.spl.net.srv.Messages.*;
import bgu.spl.net.srv.Messages.Error;
import bgu.spl.net.srv.User;

public class BGRSServerProtocol implements MessagingProtocol<Message> {

    private User user;
    private Database database;

    public BGRSServerProtocol()
    {
        database = Database.getInstance();
    }

    public Message process(Message msg)
    {
        boolean success = true;
        if (msg.getClass().equals(Login.class))
        {
            user = database.login(((Login)msg).getName(), ((Login)msg).getPassword());
            if (user == null)
            {
                success = false;
            }
        }

        if (!success)
        {
            return new Error(msg.getOpcode());
        }
        return null;
    }

    public boolean shouldTerminate()
    {
        return false;
    }
    
}
