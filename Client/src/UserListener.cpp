#include "UserListener.h"

UserListener::UserListener(mutex &_mutex, ConnectionHandler &handler): _mutex(_mutex), _handler(handler) {

}

void UserListener::run() {
    while (!shouldTerminate) {
        const short bufsize = 1024;
        char buf[bufsize];
        std::cin.getline(buf, bufsize);
        std::string line(buf);
        int len = line.length();
        bool flag = false;

        if(line == "LOGOUT")
            flag = true;

        //encoding
        Message toSend = _handler.EncDec.encode(line);

        //sending
        if(toSend.op_code == 1 | toSend.op_code == 2 | toSend.op_code == 3) {
            if(!sendOp(toSend))
                break;
            if (!_handler.sendLine(toSend.username)) {     //sending to the socket
                std::cout << "Disconnected. Exiting...\n" << std::endl;
                break;
            }
            if (!_handler.sendLine(toSend.password)) {     //sending to the socket
                std::cout << "Disconnected. Exiting...\n" << std::endl;
                break;
            }
            continue;
        }

        if(toSend.op_code == 4 | toSend.op_code == 11){
            if(!sendOp(toSend))
                break;
        }
        if(flag == true)
            if(_handler.logoutAnswer())
                shouldTerminate = true;

        if(toSend.op_code >= 5 && toSend.op_code <=10 && toSend.op_code!=8){
            if(!sendOp(toSend))
                break;
            if(!sendShortAns(toSend))
                break;
        }

        if(toSend.op_code == 8){
            if(!sendOp(toSend))
                break;
            if (!_handler.sendLine(toSend.arg)) {     //sending to the socket
                std::cout << "Disconnected. Exiting...\n" << std::endl;
                break;
            }
        }

    }
}



bool UserListener::sendOp(Message toSend){
    if(!_handler.sendBytes(toSend.opByte, 2)){
        std::cout << "Disconnected. Exiting...\n" << std::endl;
        return false;
    }
    return true;
}

bool UserListener::sendShortAns(Message toSend){
    if(!_handler.sendBytes(toSend.shortAns, 2)){
        std::cout << "Disconnected. Exiting...\n" << std::endl;
        return false;
    }
    return true;
}

