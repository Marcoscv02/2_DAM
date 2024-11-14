# DU2 - Exercise 7 - Java Threads - Atomic variables - Super even numbers


A super even number is a whole number in which every digit is even. This means that each digit in the number must be one of the even digits: 0, 2, 4, 6, or 8.

Given a set of numbers, we try to determine whether or not they are super even or not by creating a multithreading application.

The main thread must generate two random numbers (use java.util.Random) between 1 and 10000 to determine the numbers we want to check. That main thread must create a pool of four threads.

The main thread must check the numbers between the smallest and the largest of the randomly generated numbers.

For each number it will display a single line showing whether the number is a super even.

Each of the threads created by the main thread must create a thread pool of two threads to check each of the digits of the number. These threads must share an object named Number where the number is stored and a boolean that informs whether or not the number is super even.

Review the following information if you need to wait for threads to finish:

https://ducmanhphan.github.io/2020-03-20-Waiting-threads-to-finish-completely-in-Java/

Follow the given specifications to create the application.

--- 

Un **número superpar** es un número entero en el que cada dígito es par. Esto significa que cada dígito del número debe ser uno de los dígitos pares: 0, 2, 4, 6 u 8. Dado un conjunto de números, intentamos determinar si **son superpares o no** mediante la **creación de una aplicación multiproceso**.

El hilo principal debe generar dos números aleatorios (use java.util.Random) entre 1 y 10000 para determinar los números que queremos comprobar. Ese hilo principal debe crear un grupo de cuatro hilos.

El hilo principal debe comprobar los números entre el más pequeño y el más grande de los números generados aleatoriamente.

Para cada número, mostrará una sola línea que muestra si el número es superpar.

Cada uno de los hilos creados por el hilo principal debe crear un grupo de hilos de dos hilos para comprobar cada uno de los dígitos del número. Estos hilos deben compartir un objeto llamado Number donde se almacena el número y un booleano que informa si el número es superpar o no.

Revise la siguiente información si necesita esperar a que finalicen los subprocesos:

https://ducmanhphan.github.io/2020-03-20-Waiting-threads-to-finish-completely-in-Java/

Siga las especificaciones proporcionadas para crear la aplicación.