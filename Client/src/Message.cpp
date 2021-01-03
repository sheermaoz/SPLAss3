#include "Message.h"

Message::Message(string username, string password, char& opByte, short op_code):
                                                                    username(username), password(password),
                                                                    opByte(&opByte), op_code(op_code) {}

Message::Message(char& opByte, short op_code): opByte(&opByte), op_code(op_code){}

Message::Message(char& opByte, short op_code, char& shortAns):opByte(&opByte), op_code(op_code), shortAns(&shortAns) {}

Message::Message(char& opByte, short op_code, string arg): opByte(&opByte), op_code(op_code), arg(arg) {}
