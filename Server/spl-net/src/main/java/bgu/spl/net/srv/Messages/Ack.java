package bgu.spl.net.srv.Messages;

import bgu.spl.net.srv.User;

public class Ack extends Message {

    private String args;
    private short resp;

    public Ack(short _resp) {
        super((short) 12);
        resp = _resp;
    }

    public void addArg(String arg) {
        args = args + arg;
    }

    public String toString() {
        return ""  + resp + args + "\0";
    }

    @Override
    public void init(String str) {
       resp = Short.valueOf(str);

    }

    @Override
    public Object process(User usr) {
        return null;
    }

}
