## DU1 - Exercise 16 - Java ProcessBuilder

You have been asked to build a simple encryption program that reads one line of the standard input. This program should be able to create a coded message that no one can read. The process is simple. It is divided into two parts.

First, each uppercase or lowercase letter must be shifted three positions to the right, according to the ASCII table: letter 'a' should become letter 'd', letter 'y' must become the character '|' and so on. Second, the line must be reversed. After being reversed, all characters from the half on (truncated) must be moved one position to the left in ASCII. In this case, 'b' becomes 'a' and 'a' becomes '`'.

For example, if the resulting word of the first part is "tesla", the letters "sla" should be moved one position to the left. However, if the resulting word of the first part is "t#$A", the letters "$A" are to be displaced.

The coded message should be displayed to the standard output.

Create a new program to launch the previous program several times. This program has to read the messages to cypher from a file (the name of the file should be an argument) and launch the previous program for each message in a line.

--- 

Se le ha pedido que construya un programa de cifrado simple que lea una línea de la entrada estándar. Este programa debería ser capaz de crear un mensaje codificado que nadie pueda leer. El proceso es simple. Se divide en dos partes.

Primero, cada letra mayúscula o minúscula debe desplazarse tres posiciones hacia la derecha, según la tabla ASCII: la letra 'a' debe convertirse en la letra 'd', la letra 'y' debe convertirse en el carácter '|' y así sucesivamente. En segundo lugar, la línea debe invertirse. Después de invertirse, todos los caracteres a partir de la mitad (truncados) deben moverse una posición hacia la izquierda en ASCII. En este caso, 'b' se convierte en 'a' y 'a' se convierte en '`'.

Por ejemplo, si la palabra resultante de la primera parte es "tesla", las letras "sla" deben desplazarse una posición hacia la izquierda. Sin embargo, si la palabra resultante de la primera parte es "t#$A", las letras "$A" deben desplazarse.

El mensaje codificado debe mostrarse en la salida estándar.

Crea un nuevo programa para ejecutar el programa anterior varias veces. Este programa debe leer los mensajes que se van a cifrar desde un archivo (el nombre del archivo debe ser un argumento) y ejecutar el programa anterior para cada mensaje en una línea.

---

- Example of messages to cypher:
    - Texto #3
    - abcABC1
    - vxpdylY .ph
    - vv.xwfxo.fd

- Example of cyphered messages:
  - 3# rvzgV
  - 1FECedc
  - ks. \n{frzx
  - gi.r{hyz-xx