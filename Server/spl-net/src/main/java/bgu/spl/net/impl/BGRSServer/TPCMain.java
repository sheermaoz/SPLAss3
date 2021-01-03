package bgu.spl.net.impl.BGRSServer;

import bgu.spl.net.srv.Server;

public class TPCMain {
    public static void main(String[] args) {
        if (args.length != 1)
        {
            System.out.println("USAGE: TPCMain <port>");
            return;
        }
        Server.threadPerClient(
            Integer.valueOf(args[0]),  
            ()->{return new BGRSServerProtocol();}, 
            ()->{return new MsgEncDec();}
            ).serve();
    
    }

    
}
