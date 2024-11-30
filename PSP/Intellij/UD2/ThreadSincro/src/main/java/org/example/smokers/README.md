### DU2 - Ejercicio 11 - Fumadores de cigarrillos - wait() y notify()

Consideremos una tabaquería con tres fumadores y un tabaquero.

Cada fumador fuma en un bucle infinito.

Cada fumador debe esperar a que se den ciertas condiciones (tener suministros para fumar) antes de fumar.

El tabaquero suministra productos para que los fumadores fumen eternamente.

Para asegurar una verdadera concurrencia, es importante tener en cuenta que la solución debe permitir que varios fumadores fumen simultáneamente.

Los requisitos para fumadores y tabaqueros son los siguientes:

Antes de fumar es necesario liar un cigarrillo, para ello el fumador necesita tres ingredientes:
tabaco, papel y cerillas.
Cada fumador sólo tiene tabaco, papel o cerillas.
El tabaquero coloca al azar dos ingredientes diferentes de los tres necesarios para fabricar un cigarrillo. El fumador que tiene el tercer ingrediente debe retirar los dos elementos de la mesa, utilizándolos (junto con su propio suministro) para fabricar un cigarrillo, que fuma durante un rato.
Una vez que el fumador ha fabricado su cigarrillo, el tabaquero coloca dos nuevos elementos aleatorios.
La solución debe evitar bloqueos entre los diferentes hilos. También debe producir mensajes en la salida estándar para realizar un seguimiento de la actividad de los hilos:

El tabaquero debe indicar cuándo produce los ingredientes y qué suministros produce.
Cada fumador debe indicar cuándo espera, qué producto(s) espera y cuándo comienza y deja de fumar.