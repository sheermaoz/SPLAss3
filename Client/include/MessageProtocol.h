#ifndef ECHOCLIENT_CPP_MESSAGEPROTOCOL_H
#define ECHOCLIENT_CPP_MESSAGEPROTOCOL_H

#include <string>;

using namespace std;

class MessageProtocol {
public:
    string process();
    bool shouldTerminate();
};


#endif //ECHOCLIENT_CPP_MESSAGEPROTOCOL_H
