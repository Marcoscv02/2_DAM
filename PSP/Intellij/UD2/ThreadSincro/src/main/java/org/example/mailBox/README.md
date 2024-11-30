### DU2- Ejercicio 10 - MailBox - wait() y notify()

Supongamos que queremos implementar una aplicación sincronizada con una clase Mailbox que permite que un hilo deposite un mensaje y otro hilo lo recoja. Pero, solo puede haber un mensaje en el buzón a la vez. Si un hilo intenta depositar un mensaje cuando ya hay uno, debe esperar hasta que se recoja. Y si un hilo intenta recoger un mensaje cuando no hay ninguno, debe esperar hasta que se deposite uno.

Después de depositar o recoger un mensaje, cada hilo duerme durante un tiempo aleatorio entre 0 y 1 segundo para repetir el ciclo nuevamente.

Primero, la aplicación debe funcionar con un hilo depositando mensajes y un hilo recogiendo mensajes.

Finalmente, la aplicación debe ejecutarse con cinco hilos de cada tipo.