#include "Task.h"
#include <iostream>
#include <mutex>
#include <thread>
using namespace std;
Task::Task(int id, mutex &mutex): _id(id),_mutex(mutex) {}

void Task::run() {
    lock_guard<mutex> lock(_mutex);
    for(int i=0;i<1500;i++){
        cout<<i<<": My id is: "<<_id<<endl;
    }
}
