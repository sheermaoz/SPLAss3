#include <connectionHandler.h>
#include <thread>
#include <array>
#include <iostream>
#include <algorithm>
#include <string>

using boost::asio::ip::tcp;

using std::cin;
using std::cout;
using std::cerr;
using std::endl;
using std::string;
using namespace std;

ConnectionHandler::ConnectionHandler(string host, short port) : host_(host), port_(port), io_service_(),
                                                                socket_(io_service_), EncDec(), logoutAns() {}

ConnectionHandler::~ConnectionHandler() {
    close();
}

bool ConnectionHandler::connect() {
    std::cout << "Starting connect to "
              << host_ << ":" << port_ << std::endl;
    try {
        tcp::endpoint endpoint(boost::asio::ip::address::from_string(host_), port_); // the server endpoint
        boost::system::error_code error;
        socket_.connect(endpoint, error);
        if (error)
            throw boost::system::system_error(error);
        cout << "CONNECTED" << endl;
    }
    catch (std::exception &e) {
        std::cerr << "Connection failed (Error: " << e.what() << ')' << std::endl;
        return false;
    }
    return true;
}

bool ConnectionHandler::getBytes(char bytes[], unsigned int bytesToRead) {
    size_t tmp = 0;
    boost::system::error_code error;
    try {
        while (!error && bytesToRead > tmp) {
            tmp += socket_.read_some(boost::asio::buffer(bytes + tmp, bytesToRead - tmp), error);
        }
        if (error)
            throw boost::system::system_error(error);
    } catch (std::exception &e) {
        std::cerr << "recv failed (Error: " << e.what() << ')' << std::endl;
        return false;
    }

    return true;
}

bool ConnectionHandler::getLine(string& ackAns, vector<char>& byteArr) {
    return getMsgArr(ackAns, byteArr);
}

bool ConnectionHandler::sendBytes(const char bytes[], int bytesToWrite) {
    int tmp = 0;
    boost::system::error_code error;
    try {
        while (!error && bytesToWrite > tmp) {
            tmp += socket_.write_some(boost::asio::buffer(bytes + tmp, bytesToWrite - tmp), error);
        }
        if (error)
            throw boost::system::system_error(error);
    } catch (std::exception &e) {
        std::cerr << "recv failed (Error: " << e.what() << ')' << std::endl;
        return false;
    }
    return true;
}

bool ConnectionHandler::sendLine(std::string &line) {
    return sendFrameAscii(line, '\0');
}

bool ConnectionHandler::getMsgArr(string &frame, vector<char> &byteArr) {

    char ch;
    int i = 0;

    try {
        do {
            if (!getBytes(&ch, 1)) {
                return false;
            }
            byteArr.push_back(ch);
            i = i + 1;
        } while (i < 4);
    } catch (std::exception &e) {
        std::cerr << "recv failed2 (Error: " << e.what() << ')' << std::endl;
        return false;
    }

    char byteArrCopy[] = {byteArr[0], byteArr[1]};
    if (EncDec.bytesToShort(byteArrCopy) == 12) {
        return getMsgArrAck(frame);
    }
    return true;

}

bool ConnectionHandler::getMsgArrAck(string &frame) {
    char ch;

    try {
        do {
            if (!getBytes(&ch, 1)) {
                return false;
            }
            if (ch != '\0') {
                frame.append(1, ch);
            }

        } while (ch != '\0');
    } catch (std::exception &e) {
        std::cerr << "recv failed2 (Error: " << e.what() << ')' << std::endl;
        return false;
    }
    return true;
}

bool ConnectionHandler::sendFrameAscii(const std::string &frame, char delimiter) {
    bool result = sendBytes(frame.c_str(), frame.length());
    if (!result) return false;
    return sendBytes(&delimiter, 1);
}

// Close down the connection properly.
void ConnectionHandler::close() {
    try {
        socket_.close();
    } catch (...) {
        std::cout << "closing failed: connection already closed" << std::endl;
    }
}

bool ConnectionHandler::logoutAnswer() {
    while (!flag) {}
    if (logoutAns == "ACK 4")
        return true;
    else
        return false;
}

