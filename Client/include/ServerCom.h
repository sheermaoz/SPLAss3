#ifndef ECHOCLIENT_CPP_SERVERCOM_H
#define ECHOCLIENT_CPP_SERVERCOM_H

#include <connectionHandler.h>
using namespace std;
#include <iostream>
#include <mutex>
#include <thread>

class ServerCom {
private:
    ConnectionHandler &_handler;
    mutex &_mutex;
    bool shouldTerminate = false;
public:
    ServerCom(mutex &_mutex, ConnectionHandler &handler);
    void run();
    void Terminate();
};


#endif //ECHOCLIENT_CPP_SERVERCOM_H
