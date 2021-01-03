#include "ServerCom.h"
using namespace std;

ServerCom::ServerCom(mutex &_mutex, ConnectionHandler& handler): _mutex(_mutex), _handler(handler) {

}

void ServerCom::run() {
    int len=0;


    while(!shouldTerminate){
        std::string answer;
        if (!_handler.getLine(answer)) {
            std::cout << "Disconnected. Exiting...\n" << std::endl;
            break;
        }
        cout << answer << endl;

        _handler.flag = false;
        if (answer == "ACK 4") {
            _handler.flag = true;
            _handler.logoutAns = "ERR 4";
            Terminate();
            std::cout << "Exiting...\n" << std::endl;
            break;
        }
        if (answer == "ERR 4"){
            _handler.flag = true;
            _handler.logoutAns = "ERR 4";
        }


    }
}

void ServerCom::Terminate() { shouldTerminate = true; }

