## DU3 - Exercise 9 - Multi threaded client-server app - UDP - TCP - Number facts

We want to create a `client-server` application to obtain **facts** about DU3 - Exercise 9 - Multi threaded client-server app - UDP - TCP - Number facts

We want to create a client-server application to obtain facts about numbers.

The client must send to the server a command entered by the user. The only correct commands are:

- **NUMBER** <number_letters> <TYPE> <number_type>
    - number_letters can be a number or the word `random`.
    - number-type can be one of three values: trivia, math or year
- **END**
    - This command informs the server that the client is not going to make any more requests.

(If the user does not specify the number, or if the user does not use correctly the command, the server sends an Invalid request message to the client.)

--- 

The client must use the **END command** after several requests to close the communication with the server.

The server must query a [NUMBERS API](http://numbersapi.com/#42) web service to **obtain a fact about the specified number**.

The server must **display information** about all requests it receives and the URL that it uses.

The server must also **display information about all information it sends to clients**, including the client's port.

---

### UDP:

Create a `NumberClientUDP` class to launch the Client.

Create a `NumberServerUDP` class to launch the Server.

Create a `NumberServerUDPWorker` class for each thread on the Server.

### TCP:

Create a `NumberClientTCP` class to launch the Client.

Create a `NumberServerTCP` class to launch the Server.

Create a `NumberServerTCPWorker` class for each thread on the Server.

The client must send to the server a command entered by the user. The only correct commands are:

