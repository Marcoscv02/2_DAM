## 📝 **Formatos de Cadena**

Los formatos de cadena son herramientas que permiten crear cadenas de texto dinámicas, insertando valores de variables en posiciones específicas. Son útiles para dar formato a salidas de texto, como números, fechas, tablas, etc.

---

### 📌 **Sintaxis Básica**

En la mayoría de los lenguajes, los formatos de cadena siguen una estructura similar:

- **`%`**: Inicia el especificador de formato.
    
- **`indicadores`**: Modificadores opcionales (por ejemplo, relleno con ceros).
    
- **`ancho`**: Número mínimo de caracteres que ocupará el valor.
    
- **`.precisión`**: Número de decimales (para números flotantes) o longitud máxima (para cadenas).
    
- **`tipo`**: Tipo de dato a formatear (por ejemplo, `d` para enteros, `f` para flotantes).
    

---

### 🎨 **Tipos Comunes de Formato**

|Tipo|Descripción|Ejemplo|Resultado|
|---|---|---|---|
|`%d`|Entero decimal|`"%d" % 42`|`"42"`|
|`%f`|Número flotante|`"%.2f" % 3.14159`|`"3.14"`|
|`%s`|Cadena de texto|`"%s" % "Hola"`|`"Hola"`|
|`%x`|Entero hexadecimal|`"%x" % 255`|`"ff"`|
|`%o`|Entero octal|`"%o" % 64`|`"100"`|
|`%c`|Carácter|`"%c" % 65`|`"A"`|

---

### 🔧 **Indicadores Comunes**

|Indicador|Descripción|Ejemplo|Resultado|
|---|---|---|---|
|`0`|Rellena con ceros a la izquierda|`"%05d" % 42`|`"00042"`|
|`-`|Alinea a la izquierda|`"%-10s" % "Hola"`|`"Hola "`|
|`+`|Muestra el signo (+ o -)|`"%+d" % 42`|`"+42"`|
|(espacio)|Añade un espacio antes de números positivos|`"% d" % 42`|`" 42"`|

---

### 📐 **Ancho y Precisión**

- **Ancho**: Número mínimo de caracteres que ocupará el valor.
    
    - Ejemplo: `"%10s" % "Hola"` → `" Hola"`.
        
- **Precisión**: Número de decimales (para flotantes) o longitud máxima (para cadenas).
    
    - Ejemplo: `"%.2f" % 3.14159` → `"3.14"`.
        

---

### 🖥️ **Ejemplos en Diferentes Lenguajes**

#### **Java**

java

Copy

String nombre = "Juan";
int edad = 30;
double altura = 1.75;

// Formato con String.format
String mensaje = String.format("Nombre: %s, Edad: %02d, Altura: %.2f", nombre, edad, altura);
System.out.println(mensaje); // Nombre: Juan, Edad: 30, Altura: 1.75

#### **Python**

python

Copy

nombre = "Juan"
edad = 30
altura = 1.75

# Formato con f-strings (Python 3.6+)
mensaje = f"Nombre: {nombre}, Edad: {edad:02d}, Altura: {altura:.2f}"
print(mensaje)  # Nombre: Juan, Edad: 30, Altura: 1.75

# Formato con .format()
mensaje = "Nombre: {}, Edad: {:02d}, Altura: {:.2f}".format(nombre, edad, altura)
print(mensaje)  # Nombre: Juan, Edad: 30, Altura: 1.75

#### **C**

c

Copy

#include <stdio.h>

int main() {
    char nombre[] = "Juan";
    int edad = 30;
    double altura = 1.75;

    // Formato con printf
    printf("Nombre: %s, Edad: %02d, Altura: %.2f\n", nombre, edad, altura);
    // Nombre: Juan, Edad: 30, Altura: 1.75
    return 0;
}

---

### 🧩 **Casos de Uso Comunes**

1. **Formatear números**:
    
    - Asegurar un número fijo de dígitos: `"%03d" % 5` → `"005"`.
        
    - Limitar decimales: `"%.2f" % 3.14159` → `"3.14"`.
        
2. **Alinear texto**:
    
    - Alinear a la izquierda: `"%-10s" % "Hola"` → `"Hola "`.
        
    - Alinear a la derecha: `"%10s" % "Hola"` → `" Hola"`.
        
3. **Generar identificadores**:
    
    - Crear IDs con ceros a la izquierda: `"ID-%04d" % 42` → `"ID-0042"`.
        
4. **Formatear fechas y horas**:
    
    - Mostrar horas y minutos con dos dígitos: `"%02d:%02d" % (9, 5)` → `"09:05"`.
        

---

### 🌟 **Consejos Prácticos**

- Usa **f-strings** en Python (son más legibles y eficientes).
    
- En Java, prefiere **`String.format`** para formatear cadenas.
    
- En C, **`printf`** es la función estándar para formatear salidas.