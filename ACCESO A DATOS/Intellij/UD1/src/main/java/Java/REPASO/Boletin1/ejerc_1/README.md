# EJERCICIO 1. COPIA DE ARCHIVOS CON BUFFER

Se realice un programa para copiar archivos. El programa debe recoger el
nombre del archivo origen y destino. Se existe debe solicitar confirmación sobrescribir.
Úsese I/O con buffer y métodos estáticos (tenga en cuenta que los archivos pueden ser
binarios).

a) Para la lectura desde teclado puede emplearse la clase Scanner.

b) Realiza el mismo ejercicio, pero empleando entradas desde ventana con
_JFileChooser_ y mensajes de error en _JOptionPane_, si los hay.

c) Realiza un programa que lea con un JOptionPane pida una URL y para
posteriormente abrir un JFileChooser para guardarlo en el disco local.
Ayuda: para abrir un flujo de entrada a una URL puede hacerse con el
método openStream() de URL. Ten en cuenta que puede lanzar excepciones.
`InputStream in = new URL(FILE_URL).openStream();`

d) Mejora el aparado a) para que la lectura de los datos lo haga en bloques
(buffer) y no byte a byte.