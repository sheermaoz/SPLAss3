package bgu.spl.net.impl.BGRSServer;

import bgu.spl.net.Database;
import bgu.spl.net.api.MessagingProtocol;
import bgu.spl.net.srv.Messages.*;
import bgu.spl.net.srv.Messages.Error;
import bgu.spl.net.srv.Type;
import bgu.spl.net.srv.User;

public class BGRSServerProtocol implements MessagingProtocol<Message<?>> {

    private User user;
    private Database database;

    public BGRSServerProtocol()
    {
        database = Database.getInstance();
    }

    public Message<Short> process(Message<?> msg)
    {
        boolean success = true;
        if (user == null)
        {
            if (msg.getOpcode() == 3)
            {
                user = database.login((String)msg.getArgs()[0], (String)msg.getArgs()[1]);
                if (user == null)
                {
                    success = false;
                }
            }
            else if (msg.getOpcode() == 1)
            {
                success = database.register((String)msg.getArgs()[0], Type.Admin, (String)msg.getArgs()[1]);
            }
            else if (msg.getOpcode() == 2)
            {
                success = database.register((String)msg.getArgs()[0], Type.User, (String)msg.getArgs()[1]);
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
