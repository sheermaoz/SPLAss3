#include "ServerCom.h"


using namespace std;

ServerCom::ServerCom(mutex &_mutex, ConnectionHandler& handler): _mutex(_mutex), _handler(handler) {

}

void ServerCom::run() {
    while(!shouldTerminate){
        cout<<"starting1"<<endl;
        std::string answer;
        if (!_handler.getLine(answer)) {
            std::cout << "Disconnected. Exiting...\n" << std::endl;
            break;
        }
        cout << answer << endl;

        _handler.flag = false;
        if (answer == "ACK 4") {     //checking the case of termination
            _handler.logoutAns = "ERR 4";
            _handler.flag = true;
            Terminate();
        }
        if (answer == "ERR 4"){
            _handler.logoutAns = "ERR 4";
            _handler.flag = true;
        }

    }
}

void ServerCom::Terminate() { shouldTerminate = true; }

