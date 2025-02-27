# 1. **Introducción a las Colecciones**

### ¿Qué es una colección?

Una **colección** es un grupo de objetos almacenados de manera conjunta. En el mundo del software, las colecciones son estructuras que permiten almacenar y manipular múltiples elementos relacionados (o no). En Java, aunque los arrays también son colecciones, no están incluidos en el **Framework Collections**.

- **Framework Collections de Java**: Es un conjunto de clases e interfaces que proporcionan una manera estándar de manipular grupos de objetos. Incluye diferentes tipos de colecciones como listas, conjuntos, mapas, colas, etc.

### Beneficios del uso de colecciones:

1. **Reducción del esfuerzo de programación**: Proporciona una serie de estructuras de datos y algoritmos predefinidos.
2. **Incremento de la calidad del software**: Los algoritmos han sido probados para ser eficientes.
3. **Interoperabilidad**: Muchas APIs de Java utilizan clases del framework Collections.
4. **Reusabilidad**: Promueve la reutilización del código y facilita su mantenimiento.
5. **Flexibilidad**: Las colecciones permiten realizar operaciones comunes como añadir, eliminar y buscar elementos de forma eficiente.

### Operaciones básicas de la interfaz `Collection`:

6. `int size()` – Devuelve el número de elementos.
7. `boolean isEmpty()` – Verifica si está vacía.
8. `boolean contains(Object element)` – Verifica si contiene un elemento.
9. `boolean add(E element)` – Añade un elemento.
10. `boolean remove(Object element)` – Elimina un elemento.
11. `Iterator<E> iterator()` – Crea un iterador.
12. `Object[] toArray()` – Convierte la colección a un array.
13. `boolean containsAll(Collection<?> c)` – Verifica si contiene todos los elementos de otra colección.
14. `boolean addAll(Collection<? extends E> c)` – Añade todos los elementos de otra colección.
15. `boolean removeAll(Collection<?> c)` – Elimina todos los elementos comunes con otra colección.
16. `boolean retainAll(Collection<?> c)` – Retiene solo los elementos comunes con otra colección.
17. `void clear()` – Vacía la colección.

---

# 2. **Clases y Métodos Genéricos**

### ¿Qué son los genéricos?

<aside> 💡

Los **genéricos** en Java permiten escribir código que pueda manejar objetos de cualquier tipo sin necesidad de conocer su tipo específico de antemano. Esto evita errores de tipo en tiempo de ejecución y reduce la necesidad de conversiones.

</aside>

### Ejemplo de método genérico:

- Versión sin genéricos:
    
    ```java
    public class Util {
        public static int compararTamano(Object[] a, Object[] b) {
            return a.length - b.length;
        }
    }
    ```
    
- Versión con genéricos:
    
    ```java
    public class Util {
        public static <T> int compararTamano(T[] a, T[] b) {
            return a.length - b.length;
        }
    }
    ```
    

### Ventajas de los genéricos:

- **Reutilización**: Permiten crear métodos y clases que funcionan con diferentes tipos de datos.
- **Seguridad en tiempo de compilación**: Evitan errores de conversión.
- **Legibilidad**: El código se vuelve más claro y menos propenso a errores.

---

# 3. **Conjuntos (Set)**

### Definición

<aside> 💡

Un **Set** es una colección que **no permite elementos duplicados**. Son similares a los conjuntos matemáticos, donde un elemento puede estar presente una sola vez.

</aside>

### Implementaciones comunes de Set:

18. **HashSet**:
    
    - Almacena los elementos en una tabla hash.
        
    - No garantiza el orden de los elementos.
        
    - Es muy eficiente en operaciones de búsqueda, inserción y eliminación.
        
        ```java
        HashSet<Integer> conjunto = new HashSet<>();
        conjunto.add(1);
        conjunto.add(2);
        conjunto.add(2);  // No se añade porque ya existe.
        ```
        
19. **LinkedHashSet**:
    

- Mantiene el orden de inserción de los elementos.
    
- Útil cuando es importante conservar el orden en que se añaden los elementos.
    
    ```java
    LinkedHashSet<String> conjuntoOrdenado = new LinkedHashSet<>();
    conjuntoOrdenado.add("Primero");
    conjuntoOrdenado.add("Segundo");
    conjuntoOrdenado.add("Primero");  // No se añade porque ya existe.
    ```
    

20. **TreeSet**:

- Almacena los elementos en un árbol rojo-negro, ordenándolos de manera natural o mediante un comparador.
    
- Los elementos se ordenan automáticamente.
    
    ```java
    TreeSet<Integer> conjuntoOrdenado = new TreeSet<>();
    conjuntoOrdenado.add(10);
    conjuntoOrdenado.add(5);
    conjuntoOrdenado.add(7);
    // Elementos se guardan ordenados: 5, 7, 10.
    ```
    

### Operaciones comunes en Set:

- **`add(E element)`**: Añade un elemento al conjunto.
- **`remove(Object o)`**: Elimina un elemento del conjunto.
- **`contains(Object o)`**: Verifica si el conjunto contiene un elemento.
- **`size()`**: Devuelve el número de elementos en el conjunto.

---

# 4. **Listas (List)**

[LA INTERFAZ QUEUE](https://www.notion.so/LA-INTERFAZ-QUEUE-14eba065244680058365f799b7415304?pvs=21)

### ¿Qué es una lista?

<aside> 💡

Una **lista** es una colección ordenada que **permite almacenar elementos duplicados**. Se diferencian de los conjuntos en que se puede acceder a los elementos a través de su posición (índice).

</aside>

### Tipos de listas en Java:

21. **ArrayList**:
    
    - Implementada sobre un array redimensionable.
        
    - Es eficiente para acceder a elementos por su índice.
        
    - La inserción y eliminación de elementos (excepto al final) puede ser costosa, ya que requiere mover los elementos.
        
        ```java
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        System.out.println(lista.get(0));  // "Elemento 1"
        ```
        
22. **LinkedList**:
    
    - Basada en una lista doblemente enlazada.
        
    - Las inserciones y eliminaciones son más rápidas que en un ArrayList.
        
    - Acceder a elementos por su posición es más lento, ya que debe recorrer los nodos de la lista.
        
        ```java
        LinkedList<Integer> listaEnlazada = new LinkedList<>();
        listaEnlazada.add(1);
        listaEnlazada.add(2);
        listaEnlazada.addFirst(0);  // Añade al inicio de la lista.
        ```
        
23. **Vector** (deprecado en su mayoría, pero aún utilizado en algunos contextos):
    
    - Similar a `ArrayList`, pero sincronizado para operaciones concurrentes.
        
    - Es más lento debido a la sincronización.
        
        ```java
        Vector<String> vector = new Vector<>();
        vector.add("Elemento 1");
        ```
        

### Operaciones comunes en List:

- **`add(E element)`**: Añade un elemento al final de la lista.
- **`get(int index)`**: Obtiene un elemento por su posición.
- **`remove(int index)`**: Elimina un elemento en la posición indicada.
- **`indexOf(Object o)`**: Devuelve la posición de un elemento (o -1 si no está en la lista).

### Ejemplo práctico:

```java
ArrayList<Integer> numeros = new ArrayList<>();
numeros.add(1);
numeros.add(2);
numeros.add(3);

// Sumar los números en la lista:
int suma = 0;
for (Integer num : numeros) {
    suma += num;
}
System.out.println("Suma: " + suma);  // Suma: 6
```

### Diferencias entre `ArrayList` y `LinkedList`:

- **ArrayList**:
    - Acceso rápido por índice.
    - Mejor para escenarios donde se leen elementos frecuentemente.
- **LinkedList**:
    - Mejor rendimiento en inserciones y eliminaciones frecuentes.
    - Adecuado para implementar pilas (stacks) o colas (queues) debido a las interfaces `Deque` y `Queue`.

### Pilas (Stacks) y Colas (Queues):

- **Pilas**: Último en entrar, primero en salir (LIFO).
    
    ```java
    LinkedList<String> pila = new LinkedList<>();
    pila.push("Primero");
    pila.push("Segundo");
    System.out.println(pila.pop());  // "Segundo"
    ```
    
- **Colas**: Primero en entrar, primero en salir (FIFO).
    
    ```java
    LinkedList<String> cola = new LinkedList<>();
    cola.offer("Primero");
    cola.offer("Segundo");
    System.out.println(cola.poll());  // "Primero"
    ```
    
    ---
    

# 5. **Mapas (Map)**

### ¿Qué es un mapa?

<aside> 💡

Un **mapa** almacena **pares clave-valor**, donde cada clave es única y está asociada a un valor. Los mapas son útiles cuando necesitas realizar búsquedas rápidas basadas en una clave.

</aside>

### Tipos de mapas en Java:

24. **HashMap**:
    
    - Almacena los pares clave-valor en una tabla hash.
    - No garantiza el orden de los elementos.
    - Muy eficiente para búsquedas.
    
    ```java
    HashMap<String, Integer> mapa = new HashMap<>();
    mapa.put("Clave1", 10);
    mapa.put("Clave2", 20);
    ```
    
25. **TreeMap**:
    

- Ordena las claves de manera natural o mediante un comparador.
- Es más lento que `HashMap`, pero útil cuando se necesita un orden específico.

```java
TreeMap<String, Integer> mapaOrdenado = new TreeMap<>();
mapaOrdenado.put("A", 1);
mapaOrdenado.put("B", 2);
```

26. **LinkedHashMap**:
    - Mantiene el orden de inserción de los elementos.
    - Es útil cuando se necesita tanto velocidad como mantener el orden.

### Operaciones en un mapa:

- **`put(K key, V value)`**: Inserta un par clave-valor.
- **`get(Object key)`**: Obtiene el valor asociado a una clave.
- **`containsKey(Object key)`**: Verifica si una clave existe en el mapa.
- **`remove(Object key)`**: Elimina un par clave-valor basado en la clave dada.
- **`containsKey(Object key)`**: Retorna `true` si la clave existe en el mapa, `false` en caso contrario.
- **`containsValue(Object value)`**: Retorna `true` si el mapa contiene el valor especificado.
- **`size()`**: Devuelve el número de pares clave-valor en el mapa.
- **`isEmpty()`**: Retorna `true` si el mapa está vacío.
- **`clear()`**: Elimina todos los pares clave-valor del mapa.

### Ejemplo práctico de `HashMap`:

```java
HashMap<String, Integer> inventario = new HashMap<>();
inventario.put("Manzanas", 10);
inventario.put("Naranjas", 15);
inventario.put("Peras", 7);

// Acceder a un valor
System.out.println("Cantidad de manzanas: " + inventario.get("Manzanas"));  // Cantidad de manzanas: 10

// Verificar si contiene una clave
if (inventario.containsKey("Naranjas")) {
    System.out.println("Tenemos naranjas en stock.");
}

// Eliminar un elemento
inventario.remove("Peras");

// Recorrer el mapa
for (String clave : inventario.keySet()) {
    System.out.println(clave + ": " + inventario.get(clave));
}
```

---

# 6. **Iteradores**

### ¿Qué es un iterador?

<aside> 💡

Un **iterador** es una herramienta que **permite recorrer los elementos de una colección de manera secuencial**. En lugar de acceder directamente a los elementos mediante un índice (como en una lista), se puede usar un iterador para avanzar por los elementos uno a uno.

</aside>

### Métodos comunes de los iteradores:

- **`hasNext()`**: Retorna `true` si hay más elementos en la colección.
- **`next()`**: Retorna el siguiente elemento en la colección.
- **`remove()`**: Elimina el último elemento retornado por el iterador.

### Ejemplo de uso de un iterador:

```java
ArrayList<String> lista = new ArrayList<>();
lista.add("Uno");
lista.add("Dos");
lista.add("Tres");

Iterator<String> it = lista.iterator();
while (it.hasNext()) {
    String elemento = it.next();
    System.out.println(elemento);
    
    if (elemento.equals("Dos")) {
        it.remove();  // Elimina "Dos" de la lista
    }
}
```

<aside> ❗

**Nota importante**: No se debe modificar una colección (por ejemplo, eliminando elementos) mientras se recorre con un bucle `for-each`. Esto puede causar errores. En su lugar, es recomendable usar un iterador, ya que este proporciona un método `remove()` seguro para estas operaciones.

</aside>

---

# 7. **Algoritmos en las Colecciones**

### Operaciones comunes en las clases `Collections` y `Arrays`:

Las clases **`java.util.Collections`** y **`java.util.Arrays`** ofrecen una serie de métodos estáticos que facilitan la manipulación de colecciones y arrays.

### Ordenar elementos:

- **`Collections.sort(List<T> list)`**: Ordena una lista en orden natural.
- **`Arrays.sort(T[] array)`**: Ordena un array.

```java
ArrayList<Integer> numeros = new ArrayList<>();
numeros.add(5);
numeros.add(2);
numeros.add(9);

Collections.sort(numeros);
System.out.println(numeros);  // Salida: [2, 5, 9]
```

### Desordenar (shuffle):

- **`Collections.shuffle(List<?> list)`**: Desordena aleatoriamente una lista.

```java
Collections.shuffle(numeros);
System.out.println(numeros);  // Salida aleatoria, por ejemplo: [5, 2, 9]
```

### Búsqueda binaria:

- **`Collections.binarySearch(List<? extends Comparable<? super T>> list, T key)`**: Busca de manera eficiente un elemento en una lista ordenada.

```java
Collections.sort(numeros);
int indice = Collections.binarySearch(numeros, 5);
System.out.println("Índice de 5: " + indice);  // Índice de 5: 1
```

### Rellenar una lista:

- **`Collections.fill(List<? super T> list, T obj)`**: Rellena toda la lista con el mismo valor.

```java
Collections.fill(numeros, 0);
System.out.println(numeros);  // Salida: [0, 0, 0]
```

### Convertir un array en lista:

- **`Arrays.asList(T... a)`**: Convierte un array en una lista.

```java
String[] array = {"A", "B", "C"};
List<String> lista = Arrays.asList(array);
```

---

# 8. **Conclusiones**

- El **Framework Collections de Java** es una de las herramientas más poderosas y versátiles para la manipulación de datos.
- Proporciona una serie de estructuras de datos como listas, conjuntos y mapas, así como algoritmos útiles para su gestión.
- Usar colecciones adecuadamente incrementa la eficiencia del software, reduce errores y facilita la escritura de código reutilizable.

### Imagen Representativa del Framework Collections en Java:

Con este esquema, se puede visualizar cómo están organizadas las interfaces y clases del framework Collections en Java. Las interfaces clave como `List`, `Set`, `Queue` y `Map` están implementadas por varias clases que ofrecen diferentes formas de almacenar y manejar datos.

---

## **Referencias**

- **Java Docs - Collections Framework**: [https://docs.oracle.com/javase/8/docs/technotes/guides/collections/index.html](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/index.html)
- **Oracle - Guía del Framework Collections**: [https://docs.oracle.com/javase/tutorial/collections/](https://docs.oracle.com/javase/tutorial/collections/)