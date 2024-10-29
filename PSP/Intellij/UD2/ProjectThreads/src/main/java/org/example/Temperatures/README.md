# DU2 - Exercise 2 - Java Threads - Collaboration

This activity aims to enter the world of **multi-threaded programming** by creating different **threads** to **cooperate** with each other.

We have a list of all the maximum temperatures that have occurred every day in **Compostela** in the last **10 years**. We have them stored in an **array** of **integers**.

We want to calculate the **average temperature** of the last **10 years**.

To do this first we will simulate **temperatures** by filling an array of **3650** positions randomly

with **integer numbers**, taking values between **-30** and **50**.

To find the average temperature, we will **divide** the **array** into **10 parts**.

Each thread will have to search within the assigned array chunk for the average temperature.

Finally, once the **average** of each **subset** of the **array** is found, the program will tell us which is the average of the averages returned by each thread.

--- 

Esta actividad pretende adentrarnos en el mundo de la programación multihilo creando diferentes hilos que cooperen entre sí.

Tenemos una lista de todas las temperaturas máximas que se han producido cada día en Compostela en los últimos 10 años. Las tenemos almacenadas en un array de números enteros.

Queremos calcular la temperatura media de los últimos 10 años.
Para ello primero simularemos temperaturas rellenando un array de 3650 posiciones de forma aleatoria
con números enteros, tomando valores entre -30 y 50.

Para encontrar la temperatura media, dividiremos el array en 10 partes.
Cada hilo tendrá que buscar dentro del trozo de array asignado la temperatura media.

Por último, una vez encontrada la media de cada subconjunto del array, el programa nos dirá cuál es la media de las medias devueltas por cada hilo.
