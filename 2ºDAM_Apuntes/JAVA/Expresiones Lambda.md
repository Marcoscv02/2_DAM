## **1. Introducción a la Programación Funcional en Java**

Desde Java 8, es posible programar siguiendo principios funcionales. Los conceptos clave son:

- **Expresiones Lambda**: Funciones anónimas que permiten escribir funciones de forma concisa.
- **Interfaces Funcionales**: Interfaces con un único método abstracto, esenciales para implementar lambdas.

---

## **2. Expresiones Lambda**

Una expresión lambda es una función anónima que consta de:

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/ba6a0d99-1b06-4ee5-a85f-bd5736034358/d3bd153a-ef09-4858-95ea-4457f0b0d2c6/image.png)

### **1. Argumentos**:

- Sin parámetros: `() -> acción`
- Con un parámetro: `p -> acción`
- Con varios parámetros: `(p1, p2) -> acción`

### **2. Cuerpo**:

- Una línea: `() -> "resultado"`
- Varias líneas: `() -> { acción1; acción2; return resultado; }`

### **3. Retorno**: Se infiere automáticamente del cuerpo, salvo que sea explícito con `return`.

**Ejemplo Básico**:

```java
MiComparador mc = (a, b) -> a < b;
System.out.println(mc.esMenor(5, 2));
```

### **Uso Común**:

- Asignación a variables.
- Parámetros en métodos.
- Retornos de funciones.

---

## **3. Interfaces Funcionales**

Son interfaces con un solo método abstracto, que pueden ser anotadas con `@FunctionalInterface`. Ejemplo:

```java
@FunctionalInterface
interface MiComparador {
    boolean esMenor(int a1, int a2);
}
```

Al usar una lambda, internamente:

1. Se crea una clase que implementa la interfaz.
2. Se sobreescribe su único método.
3. Se instancia esa clase.

---

## **4. Relación Lambda-Objeto**

En Java, las lambdas generan objetos que representan funciones. Por ejemplo:

```java
MiComparador mc = (a1, a2) -> a1 < a2;
```

Esto equivale a crear una clase anónima que implementa `MiComparador`.

---

## **5. Inferencia de Tipos**

Java infiere los tipos de los parámetros de lambdas basándose en el contexto, como en el ejemplo anterior donde `a1` y `a2` se deducen como `int`.

---

## **6. Uso de Lambdas en el Paquete `java.util.function`**

El paquete contiene interfaces funcionales predefinidas:

- **IntPredicate**: Evalúa un entero (`boolean test(int)`).
- **IntConsumer**: Consume un entero (`void accept(int)`).
- **IntSupplier**: Proporciona un entero (`int getAsInt()`).
- **Predicate\<T>**: Evaluación genérica.
- **Function<T, R>**: Transforma un objeto de tipo `T` a tipo `R`.

### **Ejemplo: IntPredicate**

```java
IntPredicate esPar = n -> n % 2 == 0;
System.out.println(esPar.test(4)); // true
```

---

## **7. Métodos Default en Interfaces**

Desde Java 8, los interfaces pueden tener métodos con implementación, como `default` y `static`. Ejemplo:

```java
IntPredicate menorQueCero = x -> x < 0;
System.out.println(menorQueCero.negate().test(123)); // false
```

## **8. Comparación con Clases Anónimas**

Las lambdas son más concisas y permiten usar técnicas funcionales, en contraste con las clases anónimas, que requieren más código.

---

## **9. Ejercicios Propuestos**

- Implementar interfaces funcionales como `IntPredicate` y `IntSupplier`.
- Usar lambdas con estructuras genéricas como `Predicate<T>` y `Function<T, R>`.
- Escribir ejemplos con clases anónimas para entender la equivalencia con lambdas.