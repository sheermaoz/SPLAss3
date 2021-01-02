#include "MessageEncoderDecoder.h"
#include <string>
#include <iostream>
using namespace std;

char MessageEncoderDecoder::encode(string arg) {
    if(arg.length()>=8 && arg.substr(0,8) == "ADMINREG" ){
        char* opByte;
        shortToBytes(1, opByte);
        int i=9;
        string username;
        string password;
        int countDigit=0;
        while(arg[i] != ' ' ) {
            countDigit++;
            i++;
        }
        username = arg.substr(9, countDigit);
        i=i+1;
        countDigit=0;
        int from = i;
        while(i < arg.length()){
            countDigit++;
            i++;
        }
        password = arg.substr(from, countDigit);
        char const *name = username.c_str();
        char const *pass = password.c_str();

    }
}

string MessageEncoderDecoder::decodeNextByte() {
    return std::__cxx11::string();
}

short MessageEncoderDecoder::bytesToShort(char *bytesArr) {
    short result = (short)((bytesArr[0] & 0xff) << 8);
    result += (short)(bytesArr[1] & 0xff);
    return result;
}

void MessageEncoderDecoder::shortToBytes(short num, char *bytesArr) {
    bytesArr[0] = ((num >> 8) & 0xFF);
    bytesArr[1] = (num & 0xFF);
}
