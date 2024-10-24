## 1. **`JsonSerializer<T>`**

Esta interfaz se utiliza para convertir un objeto Java a su representación en formato JSON. Implementa el método:

```java
JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context);
```

### Parámetros del método `serialize`:

- **`T src`**:

  Este es el objeto que estamos serializando (en tu caso, un objeto `LocalDateTime`). `src` es el valor que será convertido a JSON.

- **`Type typeOfSrc`**:

  Representa el tipo genérico del objeto que se está serializando. En la mayoría de los casos, será la clase del objeto (`LocalDateTime.class`), pero este parámetro es útil cuando se trabaja con tipos genéricos como listas, mapas o clases parametrizadas.

- **`JsonSerializationContext context`**:

  Este contexto te permite delegar la serialización de campos o subcampos a la instancia de Gson. Si tienes objetos dentro del objeto que estás serializando, puedes usar este contexto para serializar esos subobjetos sin tener que implementarlo manualmente. Es decir, si quieres que otros campos del objeto se serialicen automáticamente, puedes llamar a `context.serialize(subcampo)`.


### Retorno:

- **`JsonElement`**:Este es el resultado de la serialización: una representación en formato JSON del objeto que puede ser una instancia de `JsonPrimitive` (para valores simples como strings o números), `JsonObject` (para objetos), o `JsonArray` (para colecciones).

---

### 

## 2. **`JsonDeserializer<T>`**

Esta interfaz permite convertir una representación en formato JSON de un objeto de vuelta a una instancia de un objeto Java. Implementa el método:

```java
T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException;
```

### Parámetros del método `deserialize`:

- **`JsonElement json`**:

  Este es el elemento JSON que queremos deserializar. Puede ser una instancia de `JsonPrimitive` (para valores simples), `JsonObject` (para objetos), o `JsonArray` (para colecciones).

- **`Type typeOfT`**:

  Es el tipo de destino que queremos obtener. Al igual que en el caso del serializador, generalmente será la clase del tipo de objeto que estamos deserializando (`LocalDateTime.class`), pero también puede ser útil cuando se trabaja con tipos genéricos.

- **`JsonDeserializationContext context`**:

  Al igual que el `JsonSerializationContext`, este contexto te permite delegar la deserialización de campos o subcampos a Gson. Si el objeto JSON tiene campos que deben ser convertidos a otras clases, puedes usar `context.deserialize(jsonSubcampo, tipo)` para delegar la tarea de convertir ese subcampo a su correspondiente objeto Java.


### Retorno:

- **`T`**:El método devuelve el objeto Java deserializado a partir del elemento JSON.