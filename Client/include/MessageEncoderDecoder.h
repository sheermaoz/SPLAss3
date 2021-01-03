#ifndef ECHOCLIENT_CPP_MESSAGEENCODERDECODER_H
#define ECHOCLIENT_CPP_MESSAGEENCODERDECODER_H

#include <string>
#include <Message.h>
using namespace std;

class MessageEncoderDecoder {
public:
    string decodeNextByte(char nextByte);
    Message encode(string arg);
    short bytesToShort(char* bytesArr);
    void shortToBytes(short num, char* bytesArr);

    Message type1(short op, vector<string> splittedArg);

    Message type2(short op, vector<string> splittedArg);

    Message type3(short op);


};


#endif //ECHOCLIENT_CPP_MESSAGEENCODERDECODER_H
