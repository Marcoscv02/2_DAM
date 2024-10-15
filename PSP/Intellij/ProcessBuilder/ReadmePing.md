# DU1 - Exercise 4 - Java ProcessBuilder - Ping

## Enunciado

Prueba la clase en el archivo `LaunchProcess.java` en Windows en las siguientes situaciones:

1. **Ejecutar un proceso sin errores.**
    - **Ejemplo:** `ping www.iessanclemente.net`

2. **Ejecutar un proceso no existente.**
    - **Ejemplo:** `pin`

3. **Ejecutar un proceso que finaliza con un código de error.**
    - **Ejemplo:** `ping -n`



**Comando de ejemplo:**
```bash
ping www.iessanclemente.net
```
**Comando para iniciar programa:**
```bash
java -cp target/classes/ org.example.LaunchProcessPing
```