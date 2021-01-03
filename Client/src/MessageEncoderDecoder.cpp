#include "MessageEncoderDecoder.h"
#include <string>
#include <iostream>
#include <boost/algorithm/string.hpp>
#include <vector>
using namespace std;

Message MessageEncoderDecoder::encode(string arg) {

    vector<string> splittedArg;
    boost::split(splittedArg, arg, boost::is_any_of(" "));

    if(splittedArg[0] == "ADMINREG" | splittedArg[0] == "STUDENTREG" | splittedArg[0] == "LOGIN") {
        char *opByte = new char[2];

        if (splittedArg[0] == "ADMINREG") {
            shortToBytes(1, opByte);
            Message retMsg = Message(splittedArg[1], splittedArg[2], *opByte, 1);
            return retMsg;
            // make string char array: char const *usernameAndPass = arg.c_str();
        }
        if (splittedArg[0] == "STUDENTREG"){
            shortToBytes(2, opByte);
            Message retMsg = Message(splittedArg[1], splittedArg[2], *opByte, 1);
            return retMsg;
        }
        if (splittedArg[0] == "LOGIN"){
            shortToBytes(3, opByte);
            Message retMsg = Message(splittedArg[1], splittedArg[2], *opByte, 1);
            return retMsg;
        }


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

string MessageEncoderDecoder::getUsernamePassword(int ind, string command) {
    bool name = false;
    int start = ind;
    string username;
    string password;
    int countDigit = 0;
    while(ind < command.length()){
        if(!name && command[ind] != ' '){
            username = command.substr(start, countDigit);
            start = start+countDigit+1;
        }
        countDigit++;
        ind++;
    }
    password = command.substr(start, countDigit-start);


    return std::__cxx11::string();
}
