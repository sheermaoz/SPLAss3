#include "MessageEncoderDecoder.h"
#include <string>
#include <iostream>
#include <boost/algorithm/string.hpp>
#include <vector>
#include <boost/lexical_cast.hpp>

using namespace std;

Message MessageEncoderDecoder::encode(string arg) {
    vector<string> splittedArg;
    boost::split(splittedArg, arg, boost::is_any_of(" "));
    if (splittedArg[0] == "ADMINREG") {
        return type1(1, splittedArg);
    }
    if (splittedArg[0] == "STUDENTREG"){
        return type1(2, splittedArg);
    }
    if (splittedArg[0] == "LOGIN"){
        return type1(3, splittedArg);
    }

    if(splittedArg[0] == "LOGOUT") {
        return type3(4);
    }

    if(splittedArg[0] == "COURSEREG"){
        return type2(5, splittedArg);
    }

    if(splittedArg[0] == "KDAMCHECK"){
        return type2(6, splittedArg);;
    }

    if(splittedArg[0] == "COURSESTAT"){
        return type2(7, splittedArg);
    }

    if(splittedArg[0] == "ISREGISTERED"){
        return type2(9, splittedArg);
    }

    if(splittedArg[0] == "UNREGISTER"){
        return type2(10, splittedArg);
    }

    if(splittedArg[0] == "STUDENTSTAT"){
        return type4(8, splittedArg);
    }

    if(splittedArg[0] == "MYCOURSES"){
        return type3(11);
    }

    return Message();
}

Message MessageEncoderDecoder::type1(short op, vector<string> splittedArg){
    char *opByte = new char[2];

    shortToBytes(op, opByte);
    Message retMsg = Message(splittedArg[1], splittedArg[2], *opByte, op);
    return retMsg;
}

Message MessageEncoderDecoder::type2(short op, vector<string> splittedArg){
    char *opByte = new char[2];
    char *shortAns = new char[2];
    short myShort = 0;

    shortToBytes(op, opByte);
    try{
        myShort = boost::lexical_cast<short>(splittedArg[1]);
    }
    catch(boost::bad_lexical_cast &) {}

    shortToBytes(myShort, shortAns);

    Message retMsg = Message(*opByte, op, *shortAns);
    return retMsg;
}

Message MessageEncoderDecoder::type3(short op){
    char *opByte = new char[2];

    shortToBytes(op, opByte);
    Message retMsg = Message(*opByte, op);
    return retMsg;
}

Message MessageEncoderDecoder::type4(short op, vector<string> splittedArg){
    char *opByte = new char[2];
        shortToBytes(8, opByte);
        Message retMsg = Message(*opByte, 8, splittedArg[1]);
        return retMsg;
    
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


