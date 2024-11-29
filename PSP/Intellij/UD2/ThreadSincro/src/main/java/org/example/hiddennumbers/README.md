# DU2 - Ejercicio 9 - Hilos Java - Sincronización - Número oculto

Queremos crear una **aplicación multihilo**.

El hilo principal debe **generar un número aleatorio** (use java.util.Random) entre 0 y 100. Ese hilo principal debe crear diez hilos cuyo trabajo es **adivinar el número generado por el hilo principal**.

Para realizar sus tareas, todos los hilos deben **compartir un objeto de la clase HiddenNumber**. La clase HiddenNumber debe tener un **método int numberGuess(int num)** que debe devolver los siguientes valores:

--- 


-1 si el juego ha terminado porque un hilo ha adivinado el número

1 si el número propuesto (num) es el número oculto

0 en caso contrario

- Siga las especificaciones dadas para crear la aplicación.