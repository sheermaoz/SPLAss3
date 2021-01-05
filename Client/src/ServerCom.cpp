#include "ServerCom.h"
#include <vector>

using namespace std;

ServerCom::ServerCom(mutex &_mutex, ConnectionHandler& handler): _handler(handler), _mutex(_mutex), shouldTerminate(false)  {}

void ServerCom::run() {
    while(!shouldTerminate){
        vector<char> byteArr;
        string ackAns;

        if (!_handler.getLine(ackAns, byteArr)) {
            std::cout << "Disconnected. Exiting...\n" << std::endl;
            break;
        }

        char byteArrCopy[] = {byteArr[0], byteArr[1]};   //copying the op code to a char array
        _handler.flag = false;
        char msgCode[2];                      //copying the number of the ack/error
        msgCode[0] = byteArr[2];
        msgCode[1] = byteArr[3];
        short code = _handler.EncDec.bytesToShort(msgCode);
        if (_handler.EncDec.bytesToShort(byteArrCopy) == 12) {
            cout << "ACK " << code << ackAns << endl;
            if(code == 4){  //checking the case of termination
                _handler.logoutAns = "ACK 4";
                _handler.flag = true;
                Terminate();
            }
        } else {
            cout << "ERROR " << code << endl;
            if(code == 4){  //checking the case of termination
                _handler.logoutAns = "ERR 4";
                _handler.flag = true;
            }
        }






    }
}

void ServerCom::Terminate() { shouldTerminate = true; }

