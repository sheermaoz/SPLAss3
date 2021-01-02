#ifndef ECHOCLIENT_CPP_MESSAGEENCODERDECODER_H
#define ECHOCLIENT_CPP_MESSAGEENCODERDECODER_H

#include <string>

using namespace std;

class MessageEncoderDecoder {
public:
     string decodeNextByte();
     char encode(string arg);
     short bytesToShort(char* bytesArr);
     void shortToBytes(short num, char* bytesArr);
};


#endif //ECHOCLIENT_CPP_MESSAGEENCODERDECODER_H
