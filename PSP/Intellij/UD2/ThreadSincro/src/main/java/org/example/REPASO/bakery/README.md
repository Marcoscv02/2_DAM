## DU2 - Ejercicio 14 - Tickets de panadería - wait() y notify()

Un empleado de una panadería atiende a los clientes en el orden en que han cogido sus tickets. Los clientes toman los tickets en un orden aleatorio.

El programa debe simular que 100 clientes quieren ser atendidos por el empleado. Cuando el empleado termina de atender a los clientes, la simulación debe terminar.

El empleado tarda un tiempo aleatorio de no más de 1000 ms en atender a un cliente.

Cada cliente espera un tiempo aleatorio entre 20000 y 40000 milisegundos para tomar un número después de entrar en la panadería.

En este proyecto, debe utilizar cuatro clases: **Bakery** (principal), **TakeANumber** (recurso compartido), **Clerk** y **Customer**.

### Los mensajes que se mostrarán durante la ejecución son:

- Iniciando hilos de empleado y cliente (se inicia la simulación)
- Empleado en espera (no hay clientes a los que atender)
- Cliente #numClient toma el ticket #numTicket
- Empleado atendiendo el ticket #numTicket