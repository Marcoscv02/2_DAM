### **1. ¿Qué es un paradigma de programación?**

- Un enfoque o filosofía para diseñar soluciones en programación.
- **Tipos principales:**
    - **Imperativa:** Describe cómo resolver un problema paso a paso.
        - Subparadigmas:
            - **Estructurada:** Uso de estructuras de control (secuencial, condicional, repetitiva). Ejemplo: C, BASIC, Pascal.
            - **Orientada a Objetos (POO):** Uso de objetos y métodos. Ejemplo: Java, C++.
    - **Declarativa:** Define qué se desea lograr, no cómo hacerlo.
        - Subparadigmas:
            - **Funcional:** Basado en predicados y matemáticas. Ejemplo: Haskell.
            - **Lógica:** Relaciona elementos lógicamente. Ejemplo: Prolog.
            - Ejemplos declarativos generales: SQL, expresiones regulares.

### **2. Diferencia entre programación imperativa y declarativa**

- **Imperativa:** Explica "cómo" hacer algo (e.g., pseudocódigo con pasos detallados).
- **Declarativa:** Indica "qué" se desea sin detallar el procedimiento (e.g., consultas SQL).

### **3. Programación funcional: Conceptos clave**

- Se basa en funciones matemáticas y **es declarativa**.
- Ejemplos de lenguajes funcionales puros: Haskell.

### **4. Principios de la programación funcional**

1. **Uso de funciones:** Dividir problemas en subproblemas usando funciones.
2. **Funciones de primera clase y orden superior:** Las funciones pueden ser tratadas como datos.
3. **Funciones puras:** Salidas predecibles para las mismas entradas (sin efectos colaterales).
4. **Recursividad:** Las funciones pueden llamarse a sí mismas.
5. **Inmutabilidad:** No hay variables modificables, sólo constantes.
6. **Evaluación perezosa:** Las operaciones no se evalúan hasta que son necesarias.

### **5. Ejemplo comparativo: Java**

- **Imperativo:**
    
    - Uso de bucles y condiciones (`for`, `if`) para aplicar un descuento.
    
    ```java
     class DescuentoLista {
     public static void main(String[] args) {
     // creamos una lista de números decimales
     ArrayList<Double> lista = new ArrayList<Double>();
     lista.add(10.5);
     lista.add(30.0);
     lista.add(15.25);
     lista.add(40.75);
     // inicializamos la variable para almacenar la suma
     double suma = 0.0;
     2
    // iteramos sobre la lista
     for (Double num : lista) {
     // verificamos si el número es mayor a 25
     if (num > 25) {
     // si el número es mayor a 25, aplicamos un 20% de descuento
     double descuento = num * 0.2;
     double nuevo_valor = num- descuento;
     suma += nuevo_valor;
     }
     }
     // imprimimos la suma de los valores descontados
     System.out.println("La suma de los valores descontados es: " + suma);
     }
     }
    ```
    
- **Funcional:**
    
    - Uso de métodos funcionales (`filter`, `map`, `sum`) sobre flujos de datos (`stream`).
    
    ```java
     class DescuentoLista {
     public static void main(String[] args) {
     // creamos una lista de números decimales
     ArrayList<Double> lista = new ArrayList<Double>();
     lista.add(10.5);
     lista.add(30.0);
     lista.add(15.25);
     lista.add(40.75);
     // aplicamos el descuento y sumamos los valores descontados con programación funcional
     double suma = lista.stream()
     .filter(num-> num > 25) // filtramos los números mayores a 25
     .map(num-> num * 0.8) // aplicamos el descuento del 20%
     .mapToDouble(Double::doubleValue) // convertimos los Double a double primitivos
     .sum(); // sumamos los valores descontados
     // imprimimos la suma de los valores descontados
     System.out.println("La suma de los valores descontados es: " + suma);
     }
     }
    ```
    

### **6. Programación multiparadigma**

- Combina varios paradigmas en un lenguaje. Ejemplo:
    - **Python, Java:** Incluyen POO, programación funcional y orientada a eventos.