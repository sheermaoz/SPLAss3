#include "BGRSclient.h"

#include <stdlib.h>
#include <connectionHandler.h>
#include <iostream>
#include <mutex>
#include <thread>
#include <ServerCom.h>
#include <UserListener.h>
#include <boost/lexical_cast.hpp>
#include <boost/algorithm/string.hpp>
#include <vector>
#include <Message.h>

using namespace std;
/**
* This code assumes that the server replies the exact text the client sent it (as opposed to the practical session example)
*/

int main (int argc, char *argv[]) {
    if (argc < 3) {
        std::cerr << "Usage: " << argv[0] << " host port" << std::endl << std::endl;
        return -1;
    }
    std::string host = argv[1];
    short port = atoi(argv[2]);

    ConnectionHandler connectionHandler(host, port);
    /*if (!connectionHandler.connect()) {
        std::cerr << "Cannot connect to " << host << ":" << port << std::endl;
        return 1;
    }*/

    mutex mutex;
    ServerCom serverCom(mutex, connectionHandler);
    UserListener userListener(mutex, connectionHandler);

    thread th1(&ServerCom::run, &serverCom);
    thread th2(&UserListener::run, &userListener);

    th1.join();
    th2.join();


}
