#ifndef BGRSCLIENT_CPP_MESSAGE_H
#define BGRSCLIENT_CPP_MESSAGE_H

#include <string>
#include <vector>
using namespace std;

class Message {
public:
    string username;
    string password;
    char* opByte;
    int op_code;
    Message(string username,string password, char& opByte, int op_code);
};


#endif //BGRSCLIENT_CPP_MESSAGE_H
