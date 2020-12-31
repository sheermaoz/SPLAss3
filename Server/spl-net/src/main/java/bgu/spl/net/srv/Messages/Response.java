package bgu.spl.net.srv.Messages;

public abstract class Response {

    protected short opCode;
    protected short resp;


    public Response(short _opcode, short _resp)
    {
        opCode = _opcode;
        resp = _resp;
    }

    public abstract String toString();
    
}
