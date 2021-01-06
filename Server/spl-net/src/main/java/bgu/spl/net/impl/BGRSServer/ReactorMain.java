package bgu.spl.net.impl.BGRSServer;

import bgu.spl.net.srv.Server;

public class ReactorMain {
    public static void main(String[] args) {
        if (args.length != 2)
        {
            System.out.println("USAGE: ReactorMain <numOfThreads> <port>");
            return;
        }
        Server.reactor(
            Integer.valueOf(args[1]), 
            Integer.valueOf(args[0]), 
            ()->{return new BGRSServerProtocol();}, 
            ()->{return new MsgEncDec();}
            ).serve();
    
    }
    
}
