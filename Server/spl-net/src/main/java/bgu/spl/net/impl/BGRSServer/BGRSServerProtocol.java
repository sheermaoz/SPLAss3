package bgu.spl.net.impl.BGRSServer;

import bgu.spl.net.api.MessagingProtocol;
import bgu.spl.net.srv.Messages.*;
import bgu.spl.net.srv.User;

public class BGRSServerProtocol implements MessagingProtocol<Message> {

    private User user;
    private boolean terminate;

    public BGRSServerProtocol()
    {
        user = null;
        terminate = false;
    }

    public Message process(Message msg)
    {
        short opcode = msg.getOpcode();
        Ack answer = new Ack(opcode);
        Object response = msg.process(user);
        
        if (opcode == 4)
        {
            terminate = (Boolean)response;
            if (!terminate)
            {
               response = null;
            }
        }

        if (response == null)
        {
            return new Err(opcode);
        }
        

        else if (opcode == 3)
        {
            user = (User)response;
        }

        else if (opcode == 9)
        {
            if ((Boolean)response == false)
            {
                answer.addArg("\nNOT REGISTERED");
            }
            else
            {
                answer.addArg("\nREGISTERED");
            }
        }

        else if (opcode == 6 | opcode == 7 | opcode == 8 | opcode == 11)
        {
            answer.addArg("\n"+(String)response);
        }

        return answer;
    }

    public boolean shouldTerminate()
    {
        return terminate;
    }
    
}
