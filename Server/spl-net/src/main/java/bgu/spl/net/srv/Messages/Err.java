package bgu.spl.net.srv.Messages;

import bgu.spl.net.srv.User;

public class Err extends Message {

    private short resp;

    public Err(short _resp) {
        super((short) 13);
        resp = _resp;
    }

    @Override
    public String toString() {
        return "ERROR "  + resp;
    }

    @Override
    public Object process(User usr) {
        return null;
    }
    
}
