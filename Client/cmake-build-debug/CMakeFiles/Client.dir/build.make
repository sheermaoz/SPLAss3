# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.17

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /home/spl211/Downloads/clion-2020.2.4/bin/cmake/linux/bin/cmake

# The command to remove a file.
RM = /home/spl211/Downloads/clion-2020.2.4/bin/cmake/linux/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/spl211/SPLAss3/SPLAss3/Client

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/spl211/SPLAss3/SPLAss3/Client/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/Client.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Client.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Client.dir/flags.make

CMakeFiles/Client.dir/src/connectionHandler.cpp.o: CMakeFiles/Client.dir/flags.make
CMakeFiles/Client.dir/src/connectionHandler.cpp.o: ../src/connectionHandler.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/spl211/SPLAss3/SPLAss3/Client/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/Client.dir/src/connectionHandler.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/Client.dir/src/connectionHandler.cpp.o -c /home/spl211/SPLAss3/SPLAss3/Client/src/connectionHandler.cpp

CMakeFiles/Client.dir/src/connectionHandler.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Client.dir/src/connectionHandler.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/spl211/SPLAss3/SPLAss3/Client/src/connectionHandler.cpp > CMakeFiles/Client.dir/src/connectionHandler.cpp.i

CMakeFiles/Client.dir/src/connectionHandler.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Client.dir/src/connectionHandler.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/spl211/SPLAss3/SPLAss3/Client/src/connectionHandler.cpp -o CMakeFiles/Client.dir/src/connectionHandler.cpp.s

CMakeFiles/Client.dir/src/BGRSclient.cpp.o: CMakeFiles/Client.dir/flags.make
CMakeFiles/Client.dir/src/BGRSclient.cpp.o: ../src/BGRSclient.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/spl211/SPLAss3/SPLAss3/Client/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/Client.dir/src/BGRSclient.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/Client.dir/src/BGRSclient.cpp.o -c /home/spl211/SPLAss3/SPLAss3/Client/src/BGRSclient.cpp

CMakeFiles/Client.dir/src/BGRSclient.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Client.dir/src/BGRSclient.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/spl211/SPLAss3/SPLAss3/Client/src/BGRSclient.cpp > CMakeFiles/Client.dir/src/BGRSclient.cpp.i

CMakeFiles/Client.dir/src/BGRSclient.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Client.dir/src/BGRSclient.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/spl211/SPLAss3/SPLAss3/Client/src/BGRSclient.cpp -o CMakeFiles/Client.dir/src/BGRSclient.cpp.s

CMakeFiles/Client.dir/src/MessageEncoderDecoder.cpp.o: CMakeFiles/Client.dir/flags.make
CMakeFiles/Client.dir/src/MessageEncoderDecoder.cpp.o: ../src/MessageEncoderDecoder.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/spl211/SPLAss3/SPLAss3/Client/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building CXX object CMakeFiles/Client.dir/src/MessageEncoderDecoder.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/Client.dir/src/MessageEncoderDecoder.cpp.o -c /home/spl211/SPLAss3/SPLAss3/Client/src/MessageEncoderDecoder.cpp

CMakeFiles/Client.dir/src/MessageEncoderDecoder.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Client.dir/src/MessageEncoderDecoder.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/spl211/SPLAss3/SPLAss3/Client/src/MessageEncoderDecoder.cpp > CMakeFiles/Client.dir/src/MessageEncoderDecoder.cpp.i

CMakeFiles/Client.dir/src/MessageEncoderDecoder.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Client.dir/src/MessageEncoderDecoder.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/spl211/SPLAss3/SPLAss3/Client/src/MessageEncoderDecoder.cpp -o CMakeFiles/Client.dir/src/MessageEncoderDecoder.cpp.s

CMakeFiles/Client.dir/src/UserListener.cpp.o: CMakeFiles/Client.dir/flags.make
CMakeFiles/Client.dir/src/UserListener.cpp.o: ../src/UserListener.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/spl211/SPLAss3/SPLAss3/Client/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Building CXX object CMakeFiles/Client.dir/src/UserListener.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/Client.dir/src/UserListener.cpp.o -c /home/spl211/SPLAss3/SPLAss3/Client/src/UserListener.cpp

CMakeFiles/Client.dir/src/UserListener.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Client.dir/src/UserListener.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/spl211/SPLAss3/SPLAss3/Client/src/UserListener.cpp > CMakeFiles/Client.dir/src/UserListener.cpp.i

CMakeFiles/Client.dir/src/UserListener.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Client.dir/src/UserListener.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/spl211/SPLAss3/SPLAss3/Client/src/UserListener.cpp -o CMakeFiles/Client.dir/src/UserListener.cpp.s

CMakeFiles/Client.dir/src/ServerCom.cpp.o: CMakeFiles/Client.dir/flags.make
CMakeFiles/Client.dir/src/ServerCom.cpp.o: ../src/ServerCom.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/spl211/SPLAss3/SPLAss3/Client/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_5) "Building CXX object CMakeFiles/Client.dir/src/ServerCom.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/Client.dir/src/ServerCom.cpp.o -c /home/spl211/SPLAss3/SPLAss3/Client/src/ServerCom.cpp

CMakeFiles/Client.dir/src/ServerCom.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Client.dir/src/ServerCom.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/spl211/SPLAss3/SPLAss3/Client/src/ServerCom.cpp > CMakeFiles/Client.dir/src/ServerCom.cpp.i

CMakeFiles/Client.dir/src/ServerCom.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Client.dir/src/ServerCom.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/spl211/SPLAss3/SPLAss3/Client/src/ServerCom.cpp -o CMakeFiles/Client.dir/src/ServerCom.cpp.s

CMakeFiles/Client.dir/src/Message.cpp.o: CMakeFiles/Client.dir/flags.make
CMakeFiles/Client.dir/src/Message.cpp.o: ../src/Message.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/spl211/SPLAss3/SPLAss3/Client/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_6) "Building CXX object CMakeFiles/Client.dir/src/Message.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/Client.dir/src/Message.cpp.o -c /home/spl211/SPLAss3/SPLAss3/Client/src/Message.cpp

CMakeFiles/Client.dir/src/Message.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Client.dir/src/Message.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/spl211/SPLAss3/SPLAss3/Client/src/Message.cpp > CMakeFiles/Client.dir/src/Message.cpp.i

CMakeFiles/Client.dir/src/Message.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Client.dir/src/Message.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/spl211/SPLAss3/SPLAss3/Client/src/Message.cpp -o CMakeFiles/Client.dir/src/Message.cpp.s

# Object files for target Client
Client_OBJECTS = \
"CMakeFiles/Client.dir/src/connectionHandler.cpp.o" \
"CMakeFiles/Client.dir/src/BGRSclient.cpp.o" \
"CMakeFiles/Client.dir/src/MessageEncoderDecoder.cpp.o" \
"CMakeFiles/Client.dir/src/UserListener.cpp.o" \
"CMakeFiles/Client.dir/src/ServerCom.cpp.o" \
"CMakeFiles/Client.dir/src/Message.cpp.o"

# External object files for target Client
Client_EXTERNAL_OBJECTS =

Client: CMakeFiles/Client.dir/src/connectionHandler.cpp.o
Client: CMakeFiles/Client.dir/src/BGRSclient.cpp.o
Client: CMakeFiles/Client.dir/src/MessageEncoderDecoder.cpp.o
Client: CMakeFiles/Client.dir/src/UserListener.cpp.o
Client: CMakeFiles/Client.dir/src/ServerCom.cpp.o
Client: CMakeFiles/Client.dir/src/Message.cpp.o
Client: CMakeFiles/Client.dir/build.make
Client: CMakeFiles/Client.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/spl211/SPLAss3/SPLAss3/Client/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_7) "Linking CXX executable Client"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/Client.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Client.dir/build: Client

.PHONY : CMakeFiles/Client.dir/build

CMakeFiles/Client.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/Client.dir/cmake_clean.cmake
.PHONY : CMakeFiles/Client.dir/clean

CMakeFiles/Client.dir/depend:
	cd /home/spl211/SPLAss3/SPLAss3/Client/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/spl211/SPLAss3/SPLAss3/Client /home/spl211/SPLAss3/SPLAss3/Client /home/spl211/SPLAss3/SPLAss3/Client/cmake-build-debug /home/spl211/SPLAss3/SPLAss3/Client/cmake-build-debug /home/spl211/SPLAss3/SPLAss3/Client/cmake-build-debug/CMakeFiles/Client.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/Client.dir/depend

