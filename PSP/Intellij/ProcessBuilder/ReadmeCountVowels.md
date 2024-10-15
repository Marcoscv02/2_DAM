# DU1 - Exercise 10 - Java ProcessBuilder - count vowels

Create a program that is able to count how many vowels are in a file. The parent program must launch five child processes, each of which will count a particular vowel (which can be either lower or upper case). Each vowel-counting process must leave the result in a file. The parent program will then retrieve the results from the files, add up all the subtotals and display the final result on the screen.

Crea un programa que sea capaz de contar cuántas vocales hay en un archivo. El programa principal debe iniciar cinco procesos secundarios, cada uno de los cuales contará una vocal particular (que puede ser minúscula o mayúscula). Cada proceso de conteo de vocales debe dejar el resultado en un archivo. Luego, el programa principal recuperará los resultados de los archivos, sumará todos los subtotales y mostrará el resultado final en la pantalla.

### For the file given as example fileData.txt the results would be:

Number of A: 23

Number of E: 45

Number of I: 16

Number of O: 18

Number of U: 7

Total number: of vowels: 109

**Comando para iniciar programa:**
```bash
java -cp target/classes/ org.example.CountVoWels
```