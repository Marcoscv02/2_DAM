# INTRODUCCIÓN

Las aplicaciones Java pueden guardar datos de forma persistente utilizando archivos o sistemas más avanzados como bases de datos. El API **[java.io](http://java.io)** permite interactuar con archivos y flujos para leer y escribir datos, garantizando que la información se preserve entre ejecuciones del programa.

# LA CLASE FILE

La clase [**`File`**](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/File.html) es una de las más utilizadas (antigua) del paquete **`Java.io`** se utiliza para **leer información** sobre **archivos** y **directorios** existentes, listar el contenido de un directorio o crear/eliminar archivos y directorios.

Una **instancia de una clase `File`** representa la **ruta a un archivo o directorio específico en el sistema de archivos**, pero **no contiene los datos del archivo o directorio** (el archivo podría no existir).

## 1. Creación de un Objeto de tipo File

```java

File javaFile = new File("/home/otto/apuntes/javaio.txt");
```

**Constructores de la clase `File`**

```java
public File(String pathname) //Crea archivo a través de una ruta
public File(File parent, String child) //Crea archivo a través de unaruta principal y una secundaria
public File(String parent, String child)//Crea un archivo a través de una ruta y un archivo o subdirectorio dentro del directorio padre
public File(URI uri) //Crea un archivo a tavés de una URI
```

## 2. El Objeto File

La clase `File` en Java representa una **ruta** a un archivo, pero no está conectada a un archivo real a menos que se realicen operaciones sobre él. Permite comprobar si un archivo existe, leer propiedades del archivo, modificar su nombre o ubicación, y eliminarlo. Al operar con archivos, la JVM y el sistema operativo el sistema de archivos realizan las acciones basadas en los métodos de la clase `File`. Si intentas operar en un archivo que no existe o no tienes acceso, algunos métodos lanzarán excepciones, mientras que otros devolverán `false` si la operación no puede realizarse.

## 3. Métodos Clase File

| `boolean delete()` | Borra el archivo o directorio y devuelve `true` sólo si la operación se completó con éxito. Si esta instancia es un directorio, **el directorio debe estar vacío para poder eliminarse**. | | --- | --- | | `boolean exists()` | Devuelve `true` si un el archivo sobre el que se aplica el método existe | | `String getAbsolutePath()` | Obtiene el nombre absoluto del archivo o directorio en el sistema de archivos | | `String getName()` | Obtiene el nombre del archivo o directorio | | `String getParent()` | Obtiene el directorio principal en el que se encuentra la ruta (null si no hai ninguno) | | `boolean isDirectory()` | Comprueba si el archivo en el que se aplica el método es un directorio | | `boolean isFile()` | Comprueba si el archivo en el que se aplica el método es un archivo | | `long lastModified()` | devuelve el tiempo trascurrido (milisegundos) desde 1/1/1970 hasta la fecha de ultima modificación | | `long length()` | Obtiene el número de bytes del archivo | | `File[] listFiles()` | Devuelve una lista de los archivos contenidos dentro de un directorio | | `boolean mkdir()` | Crea un directorio en la ruta especificada | | `boolean mkdirs()` | Crea un directorio en la ruta especificada, incluyendo cualquier directorio anterior inexistente | | `boolean renameTo(File dest)` | Cambia el nombre del archivo o directorio especificado (devuelve true si se ha completado con éxito) |

# LA CLASE RANDOMACCESSFILE

<aside> 💡

La clase `RandomAccessFile` en Java permite el **acceso no secuencial (aleatorio)** a archivos, lo que facilita la lectura y escritura en cualquier parte del archivo.

</aside>

## 1. Características principales:

- **Modos de apertura**:
    - `"r"`: Solo **lectura**.
    - `"rw"`: **Lectura** y **escritura**.
    - `"rwd"`: **Lectura** y **escritura**, **sincronizado**.
- **Puntero de archivo**: Esta clase emplea la notación de **puntero a archivo para especificar la posición actual en el archivo**.
    - Inicialmente apunta al principio del archivo (posición 0).
    - La posición se modifica con cada operación de lectura o escritura.

## 2. Métodos para gestionar la posición del puntero:

- `int skipBytes(int n)`: Mueve el puntero hacia adelante “n**”** bytes.
- `void seek(long pos)`: Sitúa el puntero en la posición especificada.
- `long getFilePointer()`: Devuelve la posición actual del puntero.

### Excepciones:

- Lanza `EOFException` si se alcanza el final del archivo antes de leer el número deseado de bytes.
- Lanza `IOException` si hay un error diferente, como un flujo cerrado.

## 3. Lectura con RandomAccessFile

<aside> 📌

_El método `read()` de la clase `RandomAccessFile` posee dos constructores, uno para leer byte a byte y otro para leer un array de bytes_

</aside>

- **Lectura de un byte desde `read()`**
    
    La **lectura** un byte desde un `RandomAccessFile` **se realiza usando su método `read()`**:
    

```java
RandomAccessFile file = new RandomAccessFile("c:\\\\programas\\\\holamundo.kt", "rw");
int miByte = file.read();
```

- **Lectura de un array de bytes: `read(byte[])`**
    
    También es posible leer un array de bytes con un `RandomAccessFile`:
    
    ```java
    RandomAccessFile randomAccessFile = new RandomAccessFile("programas/datos.txt", "r");
    
    byte[] dest      = new byte[1024]; // Array de bytes donde se almacenarán los datos leídos, llamado buffer.
    int    offset    = 0;
    int    length    = 1024;
    int    bytesLeidos = randomAccessFile.read(dest, offset, length);
    ```
    

## 4. Escritura con RandomAccessFile

<aside> 📌

_El método `write()` de la clase `RandomAccessFile` posee dos constructores, uno para leer byte a byte y otro para leer un array de bytes_

</aside>

- **Escritura de un byte con `write`**
    
    **El método `write()` de `RandomAccessFile`** toma un entero como parámetro. El byte se escribirá en la posición actual del puntero del archivo en el `RandomAccessFile`:(Si hubiese algún byte anteriormente en esa posición, será sobrescrito)
    
    ```java
    RandomAccessFile file = new RandomAccessFile("c:\\\\programas\\\\holamundo.kt", "rw");
    file.write(67); // Código ASCII para 'C'
    ```
    
- **Escritura de un array de bytes con `write`**
    
    ```java
    RandomAccessFile file = new RandomAccessFile("c:\\\\programas\\\\holamundo.kt", "rw");
    
    byte[] bytes = "Hello World".getBytes("UTF-8");
    file.write(bytes); //Escribe todos los bytes
    file.write(bytes, 2, 5); //escribe los bytes de las posiciones determinadas
    ```
    
    Al igual que en el método `read()` , en el método `write` el puntero avanza automáticamente una posición despues de ser llamado.
    

## 5. Cierre

Después de usar la clase **`RandomAccessFile`** se debe utilizar el método `close()` para cerrar la instancia

```java
RandomAccessFile file = new RandomAccessFile("c:\\\\programas\\\\holamundo.kt", "rw");
file.close();
```

U**tilizar un bloque `finally`  garantiza que ambos flujos se cierren incluso si se produce un error**

En el caso de haber utilizado la sentencia [`*try-with-resources`](https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html)* no será necesario aplicar este método

## Ejemplo de uso RandomAccessFile

```java
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RegistroEstudiantes {

    public static void main(String[] args) throws IOException { // En realidad es mala opción lanzar la excepción, pero es para simplificar el ejemplo

        try (RandomAccessFile file = new RandomAccessFile("E:\\\\programas\\\\estudiantes.txt", "rw")) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Introduce el número de estudiantes: ");
            int numEstudiantes = scanner.nextInt();
            file.writeInt(numEstudiantes);

            for (int i = 0; i < numEstudiantes; i++) {
                System.out.println("Introduce el nombre del estudiante " + (i + 1) + ": ");
                String nombre = scanner.next();
                file.writeUTF(nombre);
            }

            System.out.println("Introduce el número del estudiante a leer: ");
            int numEstudiante = scanner.nextInt();

            file.seek(0);
            int numEstudiantesGuardados = file.readInt();

            if (numEstudiante > numEstudiantesGuardados) {
                System.out.println("No hay tantos estudiantes guardados.");
            } else {
                file.seek(4); // Saltamos el número de estudiantes
                for (int i = 0; i < numEstudiante - 1; i++) {
                    file.readUTF();
                }
                System.out.println("El estudiante " + numEstudiante + " es: " + file.readUTF());
            }
        }
    }
}
```

# FLUJOS DE ENTRADA/SALIDA

<aside> 💡 Los flujos de E/S en Java permiten la entrada y salida de datos entre un programa y diversas fuentes o destinos, como archivos, dispositivos y otros programas.

</aside>

Las clases que nos permiten **crear**, **acceder** y **manipular** flujos pertenecen a la API `Java.IO` . Los flujos son una **secuencia de datos que son leídos por el programa en bloques**, dependiendo del método con el que estemos leyendo el flujo, estos bloques se dividirán de una manera u otra en forma de bytes, objetos, caracteres…

## 1. Tipos de Flujos según Entrada y Salida

- **Flujos de entrada**

Representan una **fuente de entrada** de datos al programa y pueden provenir de diversas fuentes y en distintos tipos de datos

![ioins.gif](https://prod-files-secure.s3.us-west-2.amazonaws.com/ba6a0d99-1b06-4ee5-a85f-bd5736034358/ecd1e495-3d38-4a61-b277-7535e9ebacef/ioins.gif)

- Tipos de datos:
    - Flujos de Bytes: `InputStream`
    - Flujos de Caracteres: `Reader`
    - Flujos de objetos:`ObjectOutputStream`
    - Flujos de Arrays: [`ByteArrayIntputStream`](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/io/ByteArrayOutputStream.html)
    - Flujos de datos primitivos: `DataInputStream`
    - Dispositivos: `System.in`
- **Flujos de salida**

Representan una fuente de los datos del programa a algún destino interno o externo del ordenador

![ioouts.gif](https://prod-files-secure.s3.us-west-2.amazonaws.com/ba6a0d99-1b06-4ee5-a85f-bd5736034358/59c6e3d7-7fc8-4c45-8d8d-3efe9efc6fcd/ioouts.gif)

- Tipos de datos
    - Flujos de Bytes: `OutputStream`
    - Flujos de Caracteres: `Writer`
    - Flujos de objetos:`ObjectInputStream`
    - Flujos de Arrays: [`ByteArrayOutputStream`](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/io/ByteArrayOutputStream.html)
    - Flujos de datos primitivos: `DataOutputStream`
    - Dispositivos: `System.out`

## 2. Flujos de Bytes vs Flujos de Caracteres

<aside> ⚠️

La mayoría de las clases de **flujos de entrada tienen una clase de flujo de salida correspondiente, y viceversa.**

</aside>

En la API de [`java.IO`](http://java.IO) se definen dos tipos de flujos para la lectura y escritura de flujos

### **Flujos de bytes:**

- **Los flujos de bytes leen/escriben datos binarios (0 y 1)** y tienen nombres de clase que **terminan**
- Leen en **bloques de bytes y no pueden manejar caracteres Unicode**.**en `InputStream` o `OutputStream`**.
- **Todas** las clases **descienden (heredan) de [`InputStream`](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/io/InputStream.html) y [`OutputStream`](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/io/OutputStream.html)**.
- Hay muchas clases de flujos de bytes, como: [**`FileInputStream`](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/io/FileInputStream.html) y [`FileOutputStream`](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/io/FileOutputStream.html)**. Todos los restantes flujos funcionan del mismo modo sólo difieren en la forma de construirlos.

### **Flujos de caracteres:**

- Los flujos de caracteres **leen/escriben datos de texto** y tienen nombres de clase que **terminan en `Reader` o `Writer`**.
- Automáticamente, **transforma caracteres Unicode (formato de Java) al conjunto de caracteres local**.
- Todas las clases **descienden de `Reader` y `Writer`**.
- Hay muchas clases de flujos de carácter, como :[`FileReader` (usa internamente `FileInputStream`)](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/io/FileReader.html), [`FileWriter` (usa internamente **`FileOutpuStream`**)](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/io/FileWriter.html). Todos los restantes flujos funcionan de igual modo, sólo difieren en la forma de construirlos.

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiaArchivos {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("otto.txt");
            out = new FileOutputStream("nohaycole.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally { // Hay que cerrar el flujo en cualquier condición.
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
```

# FLUJOS DE BYTE

<aside> 💡

**Los flujos de bytes leen/escriben datos binarios (0 y 1)** y tienen nombres de clase que terminan en `InputStream` o `OutputStream` (**Clases que heredan** o de las que descienden todas sus variables que veremos a continuación).

</aside>

Los Flujos de bytes **leen la información en bloques de 8 bits** (1 byte) y **no pueden manejar caracteres Unicode**

## 1. IntputStream

- *** [`ByteArrayInputStream`](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/ByteArrayInputStream.html)**: Contiene un búfer interno que permite leer los bytes directamente desde la memoria.
- ***[`ObjectInputStream`](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/ObjectInputStream.html)**: Lee **objetos Java serializado**s desde un **flujo de entrada.**
- ***[`FileInputStream`](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/FileInputStream.html)**: Crea un flujo de entrada sobre un **archivo** en el sistema de archivos.
- [**`AudioInputStream`**](https://docs.oracle.com/en/java/javase/22/docs/api/java.desktop/javax/sound/sampled/AudioInputStream.html): Permite la lectura de **datos de audio** desde un archivo o cualquier otro recurso que contenga sonido.
- [**`FilterInputStream`**](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/FilterInputStream.html): Proporciona clases decoradoras que modifican la funcionalidad básica de un flujo de entrada.
    - ***[`BufferedInputStream`](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/BufferedInputStream.html)**: Almacena los **bytes** leídos en un búfer interno para mejorar la eficiencia.
    - ***[`DataInputStream`](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/DataInputStream.html)**: Permite leer **datos primitivos** de Java desde un flujo de entrada.
    - [**`PushbackInputStream`**](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/PushbackInputStream.html): _Permite "devolver" bytes al flujo de entrada_, para que puedan ser leídos de nuevo.
- [**`PipedInputStream`**](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/PipedInputStream.html): Implementa un flujo de entrada que puede conectarse a un `PipedOutputStream`, permitiendo la comunicación entre hilos.
- [**`SequenceInputStream`**](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/SequenceInputStream.html): **Concatena múltiples flujos de entrada** para que puedan ser leídos secuencialmente como si fueran un solo flujo.

## 2.OutputStream

- ***[`ByteArrayOutputStream`](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/ByteArrayOutputStream.html)**:  Implementa un flujo de salida que escribe datos en un array de bytes, expandiéndose automáticamente. Los datos pueden recuperarse con `toByteArray()` y `toString()`.
- *[`FileOutputStream`](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/FileOutputStream.html): Crea un **flujo de salida sobre un archivo**
- ***[`ObjectOutputStream`](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/ObjectOutputStream.html): escribe objetos Java serializados en un flujo de salida.**
- [`PipedOutputStream`](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/PipedOutputStream.html) : Implementa un **flujo de salida conectado a un `PipedInputStream`,** permitiendo la comunicación entre diferentes hilos de ejecución.
- [`FilterOutputStream`](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/FilterOutputStream.html):
    - *[`BufferedOutputStream`](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/BufferedOutputStream.html) : Mejora la eficiencia al **almacenar temporalmente los datos en un búfer** antes de escribirlos en el flujo de salida subyacente.
    - *[`PrintStream`](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/PrintStream.html): proporciona métodos para **imprimir representaciones de datos primitivos y objetos** en un flujo de salida. un ejemplo de uso es `System.out`.
    - [`DataOutputStream`](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/DataOutputStream.html) : Escribe **datos primitivos** de Java en un flujo de salida.
    - [`ZipOutputStream`](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/zip/ZipOutputStream.html): Facilita la escritura de datos en **formato comprimido en archivos ZIP.**

## 3. **ObjectInputStream y ObjectOutputStream**

<aside> 💡

[**`ObjectInputStream`**](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/io/ObjectInputStream.html): lee objetos Java serializados del flujo de entrada y los deserializa. [**`ObjectOutputStream`**](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/io/ObjectOutputStream.html): escribe objetos Java serializados en un flujo de salida.

</aside>

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/ba6a0d99-1b06-4ee5-a85f-bd5736034358/f5facb2a-4f7a-4451-9cdf-d90521b9cbc0/image.png)

Para emplear las clases `ObjectInputStream`, `ObjectOutStream` los objetos a leer (escribir **deben implantar la interface: Serializable** (dicha interface no tiene métodos para implantar)

```java
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class SerializacionEjemplo {
    public static void main(String[] args) {
        // Archivo en el que se guardará el objeto serializado
        String nombreArchivo = "persona.ser";

        // Crear un objeto Persona
        Persona persona1 = new Persona("Juan", 25);

        // Serialización: escribir el objeto en un archivo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
	         // Escribiendo el objeto en el archivo
            oos.writeObject(persona1);
            System.out.println("Objeto serializado: " + persona1);
	      } catch (IOException e) {
            System.err.println("Error durante la serialización: " + e.getMessage());
        }

        // Deserialización: leer el objeto desde el archivo
        try (FileInputStream fis = new FileInputStream(nombreArchivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Leyendo el objeto desde el archivo
            Persona personaRecuperada = (Persona) ois.readObject();
            System.out.println("Objeto deserializado: " + personaRecuperada);

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error durante la deserialización: " + e.getMessage());
	      }
    }
}
```

## 4. **Lectura desde URL**

<aside> 📖

Para leer desde una URL, se puede emplear la clase `URL` y `openStream()`:

</aside>

```java
import java.io.*;

public class LeerURL {
    public static void main(String[] args) throws Exception {
        URI uri = new URI("<https://manuais.pages.iessanclemente.net/plantillas/dam/ad/>");
        URL url = uri.toURL();

        try (InputStream is = url.openStream();
             InputStreamReader isr = new InputStreamReader(is); // es un puente de bytes a caracteres.
             int c;
             while ((c = isr.read()) != -1) {
                 System.out.print((char) c);
             }
        }
    }
}
```

### URLConnection

El método `openConnection()` de `URL` devuelve un objeto de tipo `URLConnection`:

```java
    URI uri = new URI("<https://manuais.pages.iessanclemente.net/plantillas/dam/ad/>");
    URL url = uri.toURL();
    URLConnection urlConnection = url.openConnection();
    urlConnection.getInputStream();
```

### HttpURLConnection

Permite añadir elementos específicos de HTTP, como el tamaño del contenido, o el tipo de archivo:

```java
  URL url = new URI("<https://manuais.pages.iessanclemente.net/plantillas/dam/ad/>").toURL();
  HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();  // Hereda de URLConnection
  httpConnection.getInputStream();
  httpConnection.setRequestMethod("HEAD");
  long tamanho = httpConnection.getContentLengthLong();
```

# FLUJOS DE CARACTERES

<aside> 📖

Los flujos de caracteres **leen y escriben datos de texto** **transformando automáticamente caracteres Unicode (formato de java) al conjunto de caracteres local**. Todas las variables de estos flujos heredan de las clases abstractas **`Reader`** y **`Writer`**

</aside>

La principal característica que define a este tipo de flujos es que el programador se puede desentender de la traducción entre los tipos de caracteres que manejen las dos partes del programa

```java
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopiarCaracteres {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("otto.txt");
            outputStream = new FileWriter("nohaycole.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
```

Las clases `Filereader` y `FileWriter` acceden a la información en bloques de 16 bits (caracter)a diferencia de `FileInputStream` y `FileOutputStream` que lo hacen en bloques de 8 bits (entero)

<aside> ❗

Los **flujos de caracteres** suelen “envolver” a los **flujos de bytes** para manejar la lectura y escritura de texto. Los flujos de caracteres (como `FileReader` y `FileWriter`) usan flujos de bytes (`FileInputStream` y `FileOutputStream`) para la E/S física, traduciendo entre bytes y caracteres automáticamente.

</aside>

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class CopiarCaracteresConFlujosBytes {
public static void main(String[] args) {
try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("archivoOrigen.txt"));
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("archivoDestino.txt"))) {
        int c;
        // Leer carácter por carácter usando InputStreamReader y escribirlo usando OutputStreamWriter
        while ((c = inputStreamReader.read()) != -1) {
            outputStreamWriter.write(c);
        }

        System.out.println("Copia completada con éxito.");
    } catch (IOException e) {
        e.printStackTrace();
    }
	}
}
```

# FLIJOS DE ENTRADA/SALIDA CON BUFFER

Los flujos de la API `Java.IO`se pueden dividir en dos grupos. de bajo nivel(sin buffer), que son con los que hemos trabajado hasta ahora. estos se conectan directamente con la fuente de datos y procesa sus datos o recursos en bruto, es decir, sin filtrar. Esto hace que la actividad pueda ser ineficiente

## 1. Flujos de alto nivel

```java
try (var br = new BufferedReader(new FileReader("noHayCole.txt"))) {
    System.out.println(br.readLine());
}
```

En este ejemplo, **`FileReader`** actúa como el flujo de bajo nivel para la lectura, mientras que **`BufferedReader`** es el flujo de alto nivel que utiliza un **`FileReader`** como entrada. Muchas operaciones del flujo de alto nivel, como `read()` o `close()`, se delegan al flujo de bajo nivel subyacente. Sin embargo, otras operaciones modifican o **añaden nueva funcionalidad** a los métodos del flujo de bajo nivel.

<aside> 💡

En este caso el uso de Bufferes agrega funcionalidades come el método `.readLine()`, asi como mejoras en el rendimiento de acceso a datos

</aside>

- **Clases de Flujos incompatibles entre si:**
    
    ```java
    new BufferedInputStream(new FileReader("z.txt")); // NO COMPILA por mezclar clases de Reader con clases de InputStream
    
    new BufferedWriter(new FileOutputStream("z.txt")); // NO COMPILA por mezclar clases de Writer con clases de OutputStream
    
    new ObjectInputStream(new FileOutputStream("z.txt")); // NO COMPILA por mezclar clases de InputStream con clases de OutputStream
    
    new BufferedInputStream(new InputStream()); // NO COMPILA porque InputStream es una clase abstracta
    ```
    

# FLUJOS RESUMEN GENERAL

<aside> 💡

Estas tablas son de suma importancia ya que encapsulan los diferentes tipos de Flujos tanto de entrada como salida que existen en java

</aside>

|Clase|Contenido|Descripción|
|---|---|---|
|**InputStream**|byte|Clase abstracta para todas los flujos de entrada de bytes|
|**OutputStream**|byte|Clase abstracta para todas los flujos de salida de bytes|
|**Reader**|caracter|Clase abstracta para todas los flujos de entrada de caracteres|
|**Writer**|caracter|Clase abstracta para todas los flujos de salida de caracteres|

Tabla clases abstractas de flujos

|**Clase**|**Bajo/Alto Nivel**|**Descripción**|
|---|---|---|
|FileInputStream|Bajo|Lee datos de archivos como bytes|
|FileOutputStream|Bajo|Escribe datos de archivos como bytes|
|FileReader|Bajo|Lee datos de archivos como caracteres|
|FileWriter|Bajo|Escribe datos de archivos como caracteres|
|BufferedInputStream|Alto|Lee datos de bytes de un flujo de entrada existente de manera bufferizada, lo que mejora la eficiencia y el rendimiento|
|BufferedOutputStream|Alto|Escribe datos de bytes en un flujo de salida existente de manera bufferizada, lo que mejora la eficiencia y el rendimiento|
|BufferedReader|Alto|Lee datos de caracteres de un objeto Reader existente de manera bufferizada, lo que mejora la eficiencia y el rendimiento|
|BufferedWriter|Alto|Escribe datos de caracteres en un objeto Writer existente de manera bufferizada, lo que mejora la eficiencia y elrendimiento|
|ObjectInputStream|Alto|Deserializa tipos de datos primitivos de Java y gráficos de objetos de Java a partir de un flujo de entrada existente|
|ObjectOutputStream|Alto|Serializa tipos de datos primitivos de Java y gráficos de objetos de Java en un flujo de salida existente|
|**PrintStream**|Alto|**Escribe** **representaciones formateadas de objetos Java en un flujo binario**|
|**PrintWriter**|Alto|**Escribe** representaciones **formateadas de objetos Java en un flujo de caracteres**|

Tabla clases de flujos