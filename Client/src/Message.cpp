#include "Message.h"
using namespace std;

Message::Message(string username, string password, char &opByte, short op_code) :
        username(username), password(password), arg(),
        opByte(&opByte), shortAns(), op_code(op_code) {}

Message::Message(char &opByte, short op_code)
        : username(), password(), arg(), opByte(&opByte), shortAns(), op_code(op_code) {}

Message::Message(char &opByte, short op_code, char &shortAns)
        : username(), password(), arg(), opByte(&opByte), shortAns(&shortAns), op_code(op_code) {}

Message::Message(char &opByte, short op_code, string arg) : username(),
                                                            password(), arg(arg), opByte(&opByte),
                                                            shortAns(), op_code(op_code) {}
Message::Message():username(), password(), arg(), opByte(), shortAns(), op_code(){}

Message::~Message() {
    if (opByte != nullptr)
        delete opByte;
    if (shortAns !=nullptr){
        delete[] shortAns;
    }
}

Message::Message(const Message &aMsg) : username(aMsg.username), password(aMsg.password), arg(aMsg.arg),
                                        opByte(aMsg.opByte), shortAns(aMsg.shortAns), op_code(aMsg.op_code) {}


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