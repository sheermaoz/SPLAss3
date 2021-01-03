#include "Message.h"

Message::Message(string username, string password, char& opByte, int op_code):
                                                                    username(username), password(password),
                                                                    opByte(&opByte), op_code(op_code) {}
