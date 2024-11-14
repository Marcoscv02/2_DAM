

# DU2 - Exercise 6 - Java Threads - Thread pool - Multiples

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

---
Queremos crear una aplicación multiproceso.

El hilo principal debe crear un grupo de hilos para crear usando un solo hilo 50 números cuyo tamaño debe estar entre 20 y 50 dígitos. No se permiten números que comiencen con 0.

Una vez generados todos los números, queremos verificar si cada uno de los números es múltiplo de 3, 5 u 11.

Utilice otro grupo de subprocesos de tamaño 12 para realizar el cálculo.

Utilice la siguiente información para comprobar si los números son múltiplos de 3, 5 u 11:

Si la suma de los dígitos de un número es múltiplo de 3, entonces el número es múltiplo de 3, por ejemplo, para 612, la suma de los dígitos es 9, por lo que es múltiplo de 3.

Si el último carácter es '5' o '0', entonces el número es múltiplo de 5; en caso contrario, no.

Un número es múltiplo de 11 si la diferencia entre la suma de sus dígitos en posiciones impares y la suma de sus dígitos en posiciones pares es múltiplo de 11 (incluido el 0).

Muestra la información sobre cada número y múltiplo en una línea separada.

Una vez que se hayan verificado todos los números, el programa debe finalizar.