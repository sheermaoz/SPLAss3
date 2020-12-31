package bgu.spl.net.impl.BGRSServer;

import bgu.spl.net.Database;
import bgu.spl.net.api.MessagingProtocol;
import bgu.spl.net.srv.Messages.*;
import bgu.spl.net.srv.Type;
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
        if (user == null)
        {
            if (msg.getOpcode() == 3)
            {
                if (user == null)
                {
                    success = false;
                }
            }
            else if (msg.getOpcode() == 1)
            {
                success = true;
            }
            else if (msg.getOpcode() == 2)
            {
                success = true;
            }
        }

        if (!success)
        {
            return new Err(msg.getOpcode());
        }
        return null;
    }

    public boolean shouldTerminate()
    {
        return false;
    }
    
}
