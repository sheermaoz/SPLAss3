CC:=g++
CFLAGS:=-c -Wall -Weffc++ -g -std=c++11 -Iinclude
LDFLAGS:=-lboost_system -pthread

all: BGRSclient

#add more dependencies files of the main (practicly every thing else)

BGRSclient: bin/connectionHandler.o bin/BGRSClient.o bin/Message.o  bin/MessageEncoderDecoder.o bin/ServerCom.o bin/UserListener.o

	@echo 'Building target: BGRSclient'
	@echo 'Invoking: C++ Linker'
#Building and linking (add all object (.o) files)    
	$(CC) -o bin/BGRSclient  bin/connectionHandler.o bin/BGRSClient.o bin/Message.o  bin/MessageEncoderDecoder.o bin/ServerCom.o bin/UserListener.o $(LDFLAGS) #add dependencies .o files for linking !Before $(LDFLAGS)
	@echo 'Finishing building target: BGRSclient'
	@echo ' '

bin/connectionHandler.o: src/connectionHandler.cpp
	$(CC) $(CFLAGS) -o bin/connectionHandler.o src/connectionHandler.cpp
	@echo 'Building .o from connectionHandler'

bin/BGRSClient.o: src/BGRSClient.cpp
	$(CC) $(CFLAGS) -o bin/BGRSClient.o src/BGRSClient.cpp
	@echo 'Building .o from BGRSClient'

bin/Message.o: src/Message.cpp
	$(CC) $(CFLAGS) -o bin/Message.o src/Message.cpp
	@echo 'Building .o from Message'

bin/UserListener.o: src/UserListener.cpp
	$(CC) $(CFLAGS) -o bin/UserListener.o src/UserListener.cpp
	@echo 'Building .o from UserListener'
	
bin/ServerCom.o: src/ServerCom.cpp
	$(CC) $(CFLAGS) -o bin/ServerCom.o src/ServerCom.cpp
	@echo 'Building .o from ServerCom'

bin/MessageEncoderDecoder.o: src/MessageEncoderDecoder.cpp
	$(CC) $(CFLAGS) -o bin/MessageEncoderDecoder.o src/MessageEncoderDecoder.cpp
	@echo 'Building .o from MessageEncoderDecoder'

#make dependencies as well like above

#Clean the build directory
clean:
	rm -f bin/*
