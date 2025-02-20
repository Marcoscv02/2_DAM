## DU2 - Exercise 6 - Java Threads - Thread pool - Multiples

We want to create a multithreaded application.

The main thread must create a thread pool to create using a single thread 50 numbers whose size must be between 20 and 50 digits. Numbers starting with 0 are not allowed.

Once all numbers have been generated, we want to verify if each of the numbers is a multiple of 3, 5 or 11.

Use another thread pool of size 12 to perform the calculation.

Use the following information to check if the numbers are multiples of 3, 5 or 11:

If the sum of digits in a number is a multiple of 3 then the number is a multiple of 3, e.g., for 612, the sum of digits is 9 so it’s a multiple of 3.

If the last character is ’5′ or ’0′ then the number is a multiple of 5, otherwise not.

A number is a multiple of 11 if the difference between the sum of its digits in odd positions and the sum of its digits in even positions is a multiple of 11 (including 0).

Display the information about each number and multiple on a separate line.

Once all numbers have been verified, the program must terminate.