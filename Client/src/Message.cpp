#include "Message.h"

Message::Message(string username, string password, char &opByte, short op_code) :
        username(username), password(password),
        opByte(&opByte), op_code(op_code) {}

Message::Message(char &opByte, short op_code) : opByte(&opByte), op_code(op_code) {}

Message::Message(char &opByte, short op_code, char &shortAns) : opByte(&opByte), op_code(op_code),
                                                                shortAns(&shortAns) {}

Message::Message(char &opByte, short op_code, string arg) : opByte(&opByte), op_code(op_code), arg(arg) {}

Message::~Message() {
    if (opByte)
        delete[] opByte;
    if (shortAns)
        delete[] shortAns;
}

Message::Message(const Message &aMsg) {
    opByte = aMsg.opByte;
    shortAns = aMsg.shortAns;
    op_code = op_code;
    if (!aMsg.username.empty()) {
        username = aMsg.username;
    }
    if (!aMsg.password.empty()) {
        password = aMsg.password;
    }
    if (!aMsg.arg.empty()) {
        arg = arg;
    }
}


Message &Message::operator=(const Message &M) {
    if (this == &M)
        return *this;
    delete[] this->shortAns;
    delete[] this->opByte;
    this->opByte = M.opByte;
    this->op_code = M.op_code;
    this->shortAns = M.shortAns;
    this->username = M.username;
    this->password = M.password;
    this->arg = M.arg;
    
    return *this;
}