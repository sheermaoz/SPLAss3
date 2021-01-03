#ifndef ECHOCLIENT_CPP_MESSAGEENCODERDECODER_H
#define ECHOCLIENT_CPP_MESSAGEENCODERDECODER_H

#include <string>
#include <Message.h>
using namespace std;

class MessageEncoderDecoder {
public:
     string decodeNextByte();
     Message encode(string arg);
     short bytesToShort(char* bytesArr);
     void shortToBytes(short num, char* bytesArr);
     string getUsernamePassword(int start, string command);
};


#endif //ECHOCLIENT_CPP_MESSAGEENCODERDECODER_H
