### DU2 - Ejercicio 12 - Pizzería - wait() y notify()

Queremos simular una pizzería de reparto a domicilio, donde tenemos dos tipos de procesos: cocineros y repartidores.

Cada cocinero prepara las pizzas a medida que llegan los pedidos. Una vez que una pizza está lista, el cocinero la coloca en una bandeja para su entrega cuando sea posible.

Cada repartidor espera a que haya una pizza en la bandeja, la retira y se la lleva al cliente correspondiente. El repartidor vuelve entonces a la pizzería y espera a que haya una nueva pizza en la bandeja.

Además, cada bandeja tiene una capacidad limitada, no se pueden almacenar más de 5 pizzas en la bandeja.

Cada pizza debe tener un identificador diferente (empezando por 1) y un precio entre 10 y 50€.

Utilice una **linked List** para modelar la bandeja. Cada pizza debe entregarse en el orden en el que se ha cocinado.

Detenga la simulación cuando se hayan cocinado y entregado 100 pizzas.

Supongamos que el cocinero tarda entre 500 y 1000 ms en cocinar la pizza.

Supongamos que el repartidor tarda entre 1000 y 2000 ms en entregar la pizza.

Mostrar un mensaje cuando el cocinero haya colocado una pizza en la bandeja.

Mostrar un mensaje cuando el repartidor haya retirado una pizza de la bandeja.

La solución debe evitar bloqueos entre los diferentes subprocesos.