cmake_minimum_required(VERSION 3.17)
project(Client)

link_libraries("-lboost_system")
link_libraries(-pthread)

set(CMAKE_CXX_STANDARD 14)

include_directories(include)

add_executable(Client
        include/connectionHandler.h
        src/connectionHandler.cpp
        src/echoClient.cpp src/BGRSclient.cpp include/BGRSclient.h src/MessageEncoderDecoder.cpp include/MessageEncoderDecoder.h src/MessageProtocol.cpp include/MessageProtocol.h src/Task.cpp include/Task.h src/UserListener.cpp include/UserListener.h src/ServerCom.cpp include/ServerCom.h)
