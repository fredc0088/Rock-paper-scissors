# Rock-paper-scissors
Simulate a simple Rock-paper-scissors game between client/server
Project for tma BBK College, UoL

This TCP, so connection-oriented, program aims to allow two different users on the same machine
playing a Rock-Scissor-Paper game using a local server. The server creates a new socket (SOCKET),
thus keep listening for a connection as the loop should not have any stop.  
In order to save resources, I set a time limit for the primitive function LISTEN so the socket does not
work endlessly.  
