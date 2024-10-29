## Ejercicio 1: Serialización y deserialización básica Serializar y deserializar una clase sencilla con atributos básicos.

Crea una clase `Persona` con atributos `nombre` y `edad`. Implementa un `JsonSerializer` y un `JsonDeserializer` para esta clase, personalizando los nombres de los atributos en el JSON resultante, de modo que aparezcan como `name` y `age` en formato JSON.

## Ejercicio 2: Serialización y deserialización de objetos anidados Manejar una clase que contiene otro objeto como atributo.

Crea una clase `Direccion` con atributos `calle` y `ciudad`. Añade un atributo de tipo `Direccion`. Implementa los serializadores y deserializadores necesarios para manejar esta estructura de modo que la dirección tenga el nombre `address` y aparezca como una cadena de texto con el formato `calle`, `ciudad`.

## Ejercicio 3: Serialización y deserialización de listas Manejar una clase que contiene una lista de objetos.

Añade a la clase `Persona` una lista de objetos `Persona` llamados `amigos`. Implementa los serializadores y deserializadores para manejar la lista de amigos en el JSON. Haz que la lista de amigos la represente como un array de objetos JSON.

## Ejercicio 4: Serialización y deserialización de números personalizados Personalizar la serialización y deserialización de números.(ex6)

Crea una clase `Producto` con atributos `nombre` y `precio`. Implementa un `JsonSerializer` y un `JsonDeserializer` que formateen el precio como una cadena con dos decimales en el JSON.

## Ejercicio 5: Serialización y deserialización de arrays Manejar una clase que contiene un array de objetos.

Añade a la clase persona un atributo `hobbies`. Implementa los serializadores y deserializadores para manejar el array de hobbies en el JSON para que aparezca como una lista de cadenas de texto separadas por guion.