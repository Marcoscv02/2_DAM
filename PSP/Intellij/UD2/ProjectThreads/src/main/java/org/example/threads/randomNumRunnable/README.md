# DU2 - Exercise 1 - Java Threads - Runnable

Create a Java class that implements the Runnable interface.

The run() method of the class must do the following:

- Display a welcome message with the name of the current thread.
- Repeat five times:
  - Get a random number between 10 and 500 (use java.util.Random).
  - Pause the execution of the current thread for the number of miliseconds equal to the random number obtained above.
- Display a goodbye message with the name of the current thread.

Create a Java executable class to launch two threads created using the previous class. The main thread waits for the other two threads to finish and then displays a message indicating that it has finished.

---

Crea una clase Java que implemente la interfaz Runnable.

El método run() de la clase debe hacer lo siguiente:

- Muestra un mensaje de bienvenida con el nombre del hilo actual.
- Repite esto cinco veces:
  - Obtiene un número aleatorio entre 10 y 500 (usa java.util.Random).
  - Pausa la ejecución del hilo actual por la cantidad de milisegundos igual al número aleatorio obtenido anteriormente.
- Muestra un mensaje de despedida con el nombre del hilo actual.

Crea una clase ejecutable Java para lanzar dos hilos creados con la clase anterior. El hilo principal espera a que los otros dos hilos terminen y luego muestra un mensaje indicando que ha terminado.