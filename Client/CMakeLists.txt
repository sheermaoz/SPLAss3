cmake_minimum_required(VERSION 3.17)
project(Client)

set(CMAKE_CXX_STANDARD 14)

include_directories(include)

add_executable(Client
        include/connectionHandler.h
        src/connectionHandler.cpp
        src/echoClient.cpp)
