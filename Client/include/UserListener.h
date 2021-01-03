#ifndef ECHOCLIENT_CPP_USERLISTENER_H
#define ECHOCLIENT_CPP_USERLISTENER_H

#include <connectionHandler.h>
using namespace std;
#include <iostream>
#include <mutex>
#include <thread>
#include <Message.h>

class UserListener {
private:
    ConnectionHandler &_handler;
    mutex &_mutex;
    bool shouldTerminate = false;

public:
    UserListener(mutex &_mutex, ConnectionHandler &handler);
    void run();

    bool sendOp(Message toSend);

    bool sendShortAns(Message toSend);
};



#endif //ECHOCLIENT_CPP_USERLISTENER_H
