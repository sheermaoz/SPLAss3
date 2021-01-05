#ifndef BGRSCLIENT_CPP_MESSAGE_H
#define BGRSCLIENT_CPP_MESSAGE_H

#include <string>
#include <vector>

using namespace std;

class Message {
public:


    string username;
    string password;
    string arg;
    char *opByte;
    char *shortAns;
    short op_code;

    Message();

    Message(string username, string password, char &opByte, short op_code);

    Message(char &opByte, short op_code);

    Message(char &opByte, short op_code, char &shortAns);

    Message(char &opByte, short op_code, string arg);

    virtual ~Message();

    Message(const Message &aMsg);

    Message &operator=(const Message &M);
};


#endif //BGRSCLIENT_CPP_MESSAGE_H
