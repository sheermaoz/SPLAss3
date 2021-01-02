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

        //todo: encode line

        if (!_handler.sendLine(line)) {     //sending to the socket
            std::cout << "Disconnected. Exiting...\n" << std::endl;
            break;
        }
        std::cout << "Sent " << len+1 << " bytes to server" << std::endl;  //for debugging
    }
}

void UserListener::Terminate() { shouldTerminate = true; }


