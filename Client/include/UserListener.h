#ifndef ECHOCLIENT_CPP_USERLISTENER_H
#define ECHOCLIENT_CPP_USERLISTENER_H

#include <connectionHandler.h>
using namespace std;
#include <iostream>
#include <mutex>
#include <thread>

class UserListener {
private:
    ConnectionHandler &_handler;
    mutex &_mutex;
    bool shouldTerminate = true;

public:
    UserListener(mutex &_mutex, ConnectionHandler &handler);
    void run();
    void Terminate();
};
};


#endif //ECHOCLIENT_CPP_USERLISTENER_H
