#include "ServerCom.h"


using namespace std;

ServerCom::ServerCom(mutex &_mutex, ConnectionHandler& handler): _mutex(_mutex), _handler(handler) {

}

void ServerCom::run() {
    while(!shouldTerminate){
        /*string answer;
        if (!_handler.getLine(answer)) {
            std::cout << "Disconnected. Exiting...\n" << std::endl;
            break;
        }
        cout << answer << endl;*/

        char* byteArr;
        string ackAns;
        if (!_handler.getLine2(ackAns, byteArr)) {
            std::cout << "Disconnected. Exiting...\n" << std::endl;
            break;
        }

        _handler.flag = false;
        char* msgCode;
        msgCode[0] = byteArr[2];
        msgCode[1] = byteArr[3];
        short code = _handler.EncDec.bytesToShort(msgCode);

        if (_handler.EncDec.bytesToShort(byteArr) == 12) {
            cout << "ACK " << code << " " + ackAns << endl;
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

