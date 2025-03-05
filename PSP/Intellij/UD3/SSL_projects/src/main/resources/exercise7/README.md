# DU3 - Exercise 7 - Multi threaded client-server app UDP - Random word

We want to create a **client-server application** to obtain random words.

The client must send to the server a command entered by the user. The only correct command is:

`WORD <number_letters>`

If the user does not specify the number of letters (letter_numbers), the **default value must be 5**.

The server must query a [Random Word API](https://random-word-api.herokuapp.com/word?length=7) web service to obtain a word with the length specified by the user and must send the word to the client.

If the user enters a command that does not exist, the server sends a greeting to the client.

Create a `RandomWordClient` class to launch the Client.

Create a `RandomWordServer` class to launch the Server.

Create a `RandomWordServerWorker` class for each thread on the Server.