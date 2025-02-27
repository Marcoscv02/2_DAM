# 📚 Expresiones Regulares en Java

## 1. **Introducción**

- **¿Qué son?**  
    Secuencias de caracteres que definen un patrón de búsqueda, usado para validar, buscar o manipular texto.
    
- **Usos comunes**:  
    Validación de emails, números telefónicos, extracción de datos, reemplazo de texto, etc.
    

---

## 2. **Clases Principales en Java**

Java utiliza dos clases del paquete `java.util.regex`:

1. **`Pattern`**:  
    Compila una expresión regular en un objeto.
    
	```java
	Pattern pattern = Pattern.compile("regex");
	```
    
2. **`Matcher`**:  
    Realiza operaciones de búsqueda en un texto usando el `Pattern`.
    
	```java
	Matcher matcher = pattern.matcher("texto");
	```
    

---

## 3. **Sintaxis Básica de Regex**

### 🔍 Metacaracteres

|Carácter|Descripción|Ejemplo|
|---|---|---|
|`.`|Cualquier carácter (excepto `\n`)|`a.c` → "abc"|
|`^`|Inicio de línea|`^Java`|
|`$`|Fin de línea|`end$`|
|`\d`|Dígito (0-9)|`\d{3}`|
|`\D`|No dígito|`\D+`|
|`\s`|Espacio en blanco|`\s+`|
|`\S`|No espacio en blanco|`\S`|
|`\w`|Carácter alfanumérico (a-z, A-Z, 0-9, _)|`\w{4}`|
|`\W`|No alfanumérico|`\W`|

### 🔢 Cuantificadores

|Cuantificador|Descripción|Ejemplo|
|---|---|---|
|`*`|0 o más veces|`a*`|
|`+`|1 o más veces|`\d+`|
|`?`|0 o 1 vez|`colou?r`|
|`{n}`|Exactamente `n` veces|`\w{3}`|
|`{n,}`|Al menos `n` veces|`a{2,}`|
|`{n,m}`|Entre `n` y `m` veces|`\d{2,4}`|

### 🧩 Grupos y Rangos

| Expresión  | Descripción                        | Ejemplo            |
| ---------- | ---------------------------------- | ------------------ |
| `[abc]`    | Cualquiera de los caracteres       | `[aeiou]`          |
| `[a-z]`    | Rango de caracteres                | `[A-Za-z]`         |
| `[^abc]`   | Negación (no `a`, `b`, ni `c`)     | `[^0-9]`           |
| `(a    b)` | Grupo lógico (OR)                  | `(java    python)` |
| `\1`, `\2` | Backreferences (grupos capturados) | `(\\d)\\1`         |

---

## 4. **Métodos Clave del `Matcher`**

- **`matches()`**:  
    Verifica si **todo el texto** coincide con el patrón.
    
	```java
	 boolean coincide = matcher.matches();
	```
    
- **`find()`**:  
    Busca la siguiente coincidencia en el texto.
    ```java
    while (matcher.find()) {
	    System.out.println(matcher.group());
	}
	```
    
- **`group()`**:  
    Devuelve el texto coincidente.
    
- **`start()` / `end()`**:  
    Posiciones de inicio/fin de la coincidencia.
    

---

## 5. **Flags (Modificadores)**

Se usan al compilar el `Pattern` para modificar su comportamiento:

|Flag (Java)|Descripción|
|---|---|
|`Pattern.CASE_INSENSITIVE`|Ignora mayúsculas/minúsculas|
|`Pattern.MULTILINE`|`^` y `$` por línea|
|`Pattern.DOTALL`|`.` incluye `\n`|

Ejemplo:

```java
Pattern pattern = Pattern.compile("regex", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
```
---

## 6. **Ejemplos Prácticos**

### 📧 Validar Email

```java
String regex = "^[\\w.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher("user@example.com");
boolean valido = matcher.matches();
```
### 📞 Extraer Números de Teléfono

```java
String texto = "Tel: 123-456-7890, 555-1234";
Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
Matcher matcher = pattern.matcher(texto);
while (matcher.find()) {
    System.out.println("Número: " + matcher.group());
}
```

---

## 7. **Métodos de `String` que usan Regex**

- **`split(String regex)`**: Divide el string usando regex.
    
	```java
	String[] partes = "a,b,c".split(",");
	```
- **`replaceAll(String regex, String replacement)`**: Reemplaza coincidencias.
    
    ```java
    String nuevo = "123abc".replaceAll("\\d", "X"); // "XXXabc"
	```

---

## 8. **Errores Comunes y Buenas Prácticas**

- **Escapar caracteres**: En Java, usa `\\` para representar `\` en regex.
    
    ```java
    // Incorrecto: Pattern.compile("\d");
	// Correcto:   Pattern.compile("\\d");
	```
- **Precompilar patrones**: Usa `Pattern.compile()` una vez si lo reutilizas.
    
- **Evitar backtracking excesivo**: Usa cuantificadores posesivos (`*+`, `++`).
    

---

## 9. **Herramientas Útiles**

- [Regex101](https://regex101.com/): Probador de regex online.
    
- [RegexCheatSheet](https://cheatography.com/davechild/cheat-sheets/regular-expressions/): Chuleta de sintaxis.
    

---

## 10. **Ejercicio Avanzado: Validar Fechas (DD/MM/YYYY)**

```java
String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher("31/12/2023");
boolean fechaValida = matcher.matches();
```
---
## 11. **Sintaxis Avanzada de Regex**

### 11.1. **Clases de Caracteres Especiales**

|Expresión|Descripción|Ejemplo|
|---|---|---|
|`\b`|Límite de palabra (word boundary)|`\bJava\b`|
|`\B`|No límite de palabra|`\Bscript\B`|
|`\p{L}`|Cualquier letra (Unicode)|`\p{L}+`|
|`\p{Digit}`|Dígito (equivalente a `\d`)|`\p{Digit}{3}`|
|`\x{FFFF}`|Carácter Unicode por su código|`\x{1F600}` (😀)|

### 11.2. **Constructores Avanzados**

|Expresión|Descripción|Ejemplo|
|---|---|---|
|`(?i)`|**CASE_INSENSITIVE** en modo inline|`(?i)java`|
|`(?s)`|**DOTALL** (`.` incluye `\n`)|`(?s).+`|
|`(?m)`|**MULTILINE** (`^` y `$` por línea)|`(?m)^start`|
|`(?:...)`|Grupo **no capturador**|`(?:ab)+`|
|`(?=...)`|**Lookahead positivo**|`Java(?=8)`|
|`(?<=...)`|**Lookbehind positivo**|`(?<=@)\w+`|
|`(?<!...)`|**Lookbehind negativo**|`(?<!\d)\d{3}`|

---

## 12. **Uso de `Pattern` y `Matcher` (Detalle Profundo)**

### 12.1. **Compilación de Patrones con Flags**

```java
	Pattern pattern = Pattern.compile(
	    "^(?i)[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$", 
	    Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE
	);
```

### 12.2. **Métodos del `Matcher` (Avanzados)**

- **`replaceAll()` / `replaceFirst()`**:
    
	```java
	String texto = "a1b2c3";
	String sinDigitos = texto.replaceAll("\\d", ""); // "abc"
	```
    
- **`usePattern()`**: Cambiar el patrón en tiempo de ejecución.
    
- **`region()`**: Limitar la búsqueda a una subcadena.
    

---

## 13. **Casos de Uso Complejos**

### 13.1. **Validación de Contraseñas Seguras**

Requisitos: Mínimo 8 caracteres, al menos 1 mayúscula, 1 minúscula, 1 dígito, 1 carácter especial.

```java
String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
```

### 13.2. **Extracción de URLs de un Texto**

```java
String regex = "\\b(https?|ftp)://[^\\s/$.?#].[^\\s]*\\b";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(texto);
while (matcher.find()) {
    System.out.println("URL encontrada: " + matcher.group());
}
```
### 13.3. **Análisis de Logs con Grupos Nombrados**

```java
String regex = "(?<timestamp>\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}) (?<level>INFO|ERROR) (?<message>.+)";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(logLine);
if (matcher.matches()) {
    System.out.println("Nivel: " + matcher.group("level"));
}
```

---

##  14. **Optimización de Regex en Java**

### 14.1. **Precompilación de Patrones**

```java
public class RegexUtils {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
    public static boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
```
### 14.2. **Evitar Backtracking Catastrófico**

- **Problema**: Patrones como `(a+)+b` pueden causar lentitud extrema.
    
- **Solución**: Usar **cuantificadores posesivos** (`*+`, `++`, `?+`).
    
    ```java
    String regex = "(a++)+b"; // Más eficiente
	```
    
---

## 15. **Depuración de Expresiones Regulares**

### 15.1. **Herramientas Recomendadas**

- [RegexPlanet (Java)](https://www.regexplanet.com/advanced/java/index.html): Probador online con soporte para Java.
    
- **IDE Integrations**:
    
    - IntelliJ: Ctrl + Click en `Pattern.compile()` para ver el tester integrado.
        
    - Eclipse: Plugins como **QuickRex**.
        

### 15.2. **Logging de Coincidencias**

```java
Matcher matcher = pattern.matcher(texto);
while (matcher.find()) {
    System.out.printf("Coincidencia encontrada en [%d,%d): %s%n",
        matcher.start(),
        matcher.end(),
        matcher.group());
}
```

---

## 16. **Errores Comunes y Cómo Solucionarlos**

### 16.1. **Escapado Incorrecto**

- **Error**: `Pattern.compile("\d");` → **No compila**.
    
- **Solución**: Usar **doble barra** para escapar en Java:
    
  ```java
	Pattern.compile("\\d"); // Correcto
	```

### 16.2. **Greedy vs. Reluctant Quantifiers**

- **Greedy (por defecto)**: `.*` captura todo lo posible.
    
- **Reluctant**: `.*?` captura lo mínimo necesario.
    
    ```java
    String texto = "<div>Hola</div><div>Mundo</div>";
	Pattern greedy = Pattern.compile("<div>.*</div>"); // Captura todo el texto
	Pattern reluct = Pattern.compile("<div>.*?</div>"); // Captura "<div>Hola</div>"
	```

---

## 17. **Regex vs. Otras Técnicas**

### 17.1. **¿Cuándo NO usar Regex?**

- **Parsing de HTML/XML**: Usar librerías como Jsoup.
    
- **Expresiones matemáticas complejas**: Usar un parser recursivo.
    

### 17.2. **Alternativas en Java**

- **`StringUtils` de Apache Commons**: Métodos como `substringsBetween()`.
    
- **Streams con `splitAsStream()` (Java 8+)**:
    
    ```java
    Pattern.compile(",")
	  .splitAsStream("a,b,c")
	  .forEach(System.out::println);
	```
    

---

## 18. **Ejercicio Final: Validar Tarjetas de Crédito**

```java
String regex = "^(?:(4\\d{3})|(5[1-5]\\d{2})|(6\\d{3})|(3[47]\\d{2}))-?\\d{4}-?\\d{4}-?\\d{4}$";
// Valida Visa (4xxx), Mastercard (51xx-55xx), Amex (34xx, 37xx), Discover (6011)
```
---

# 🎯 **Consejos Finales**

- **Practica con plataformas**: [RegexOne](https://regexone.com/), [HackerRank](https://www.hackerrank.com/domains/regex).
    
- **Libro recomendado**: _"Mastering Regular Expressions"_ de Jeffrey Friedl.
    
- **Regla de oro**: Si tu regex se vuelve ilegible, ¡divídela en partes y comenta!