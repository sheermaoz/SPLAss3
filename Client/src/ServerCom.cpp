#include "ServerCom.h"

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
        len=answer.length();
            /*answer.resize(len-1);  not sure why needed, check when sending to the server*/
        std::cout << "Reply: " << answer << " " << len << " bytes " << std::endl << std::endl;
        if (answer == "terminate") {
            Terminate();
            std::cout << "Exiting...\n" << std::endl;
            break;
        }
    }
}

void ServerCom::Terminate() { shouldTerminate = true; }