#ifndef ECHOCLIENT_CPP_TASK_H
#define ECHOCLIENT_CPP_TASK_H
using namespace std;
#include <iostream>
#include <mutex>
#include <thread>


class Task {
private:
    int _id;
    mutex &_mutex;
public:
    Task(int _id, mutex &_mutex);
    void run();

};


#endif //ECHOCLIENT_CPP_TASK_H
