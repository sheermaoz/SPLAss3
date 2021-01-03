#include "BGRSclient.h"

#include <stdlib.h>
#include <connectionHandler.h>
#include <iostream>
#include <mutex>
#include <thread>
#include <ServerCom.h>
#include <UserListener.h>
#include <boost/lexical_cast.hpp>
#include <boost/algorithm/string.hpp>
#include <vector>
#include <Message.h>

using namespace std;
/**
* This code assumes that the server replies the exact text the client sent it (as opposed to the practical session example)
*/


static void shortToBytes(short num, char* bytesArr)
{
    bytesArr[0] = ((num >> 8) & 0xFF);
    bytesArr[1] = (num & 0xFF);
}

short bytesToShort(char* bytesArr)
{
    short result = (short)((bytesArr[0] & 0xff) << 8);
    result += (short)(bytesArr[1] & 0xff);
    return result;
}



int main (int argc, char *argv[]) {
    if (argc < 3) {
        std::cerr << "Usage: " << argv[0] << " host port" << std::endl << std::endl;
        return -1;
    }
    std::string host = argv[1];
    short port = atoi(argv[2]);

    ConnectionHandler connectionHandler(host, port);
    /*if (!connectionHandler.connect()) {
        std::cerr << "Cannot connect to " << host << ":" << port << std::endl;
        return 1;
    }*/

    mutex mutex;
    ServerCom serverCom(mutex, connectionHandler);
    UserListener userListener(mutex, connectionHandler);

    thread th1(&ServerCom::run, &serverCom);
    thread th2(&UserListener::run, &userListener);

    th1.join();
    th2.join();



    /*string a("ADMINREG omer shaya");
    cout<<"in string: "+a<<endl;

    vector<string> result;
    boost::split(result, a, boost::is_any_of(" "));
    cout<<result[1]+" "+result[2]<<endl;

    char* opByte = new char[2];
    short b = 5;
    shortToBytes(b, opByte);
    string nameAndPw = result[1]+" "+result[2];
    Message retMsg = Message(nameAndPw, *opByte);
    cout<< retMsg.arg <<" charByte: "<< bytesToShort(retMsg.opByte)<<endl;*/




}
