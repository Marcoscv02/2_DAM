 # 1. FTP 
## 1.1 INTRODUCTION

<aside style="border: 2px solid purple; padding: 10px; border-radius: 5px;"> 
<span style="color:rgb(146, 208, 80)">FTP (File Transfer Protocol)</span> es un protocolo de red estándar utilizado para <b>transferir archivos entre un ordenador cliente y un servidor</b> a través de una red, como el Internet. Opera bajo un modelo cliente-servidor, en el cual el cliente inicia la conexión para realizar la transferencia y gestión de archivos. Este protocolo es ampliamente utilizado por desarrolladores web, creadores de contenido y profesionales de TIC para actualizar sitios, transferir grandes volúmenes de datos y ejecutar diversas tareas de administración de archivos.
</aside>

FTP se fundamenta en el uso de dos canales diferenciados:

- <span style="color:rgb(255, 0, 0)"><b>Canal de Comandos:</b></span>
    
    - Se encarga de la <u>transmisión de comandos</u> (por ejemplo, USER, PASS) mediante el puerto 21 en el servidor.
    - Este canal permanece activo hasta que el cliente envía el comando QUIT o el servidor desconecta la sesión por inactividad.
- <span style="color:rgb(255, 0, 0)"><b>Canal de Datos:</b></span>
    
    - Se utiliza para la <u>transferencia de información</u>, como listados de directorios (LIST, STOR, RETR) y archivos en sí.
    - En el modo activo, este canal utiliza normalmente el puerto 20; en el modo pasivo, se asigna un puerto aleatorio.
    - A diferencia del canal de comandos, el canal de datos se cierra una vez finalizada la transferencia.

>Es importante destacar que **<u>FTP no cifra la información</u>**, lo que lo hace vulnerable a interceptaciones y ataques, y el mantenimiento de puertos abiertos puede representar riesgos de seguridad. A pesar de estas limitaciones, FTP ha sido esencial para el manejo y distribución de datos en Internet, permitiendo desde la transmisión de video hasta el uso de servicios en la nube.

---
## 1.2 TYPES OF FTP

Existen diversas formas de establecer conexiones FTP, diferenciadas principalmente por el nivel de seguridad y autenticación:

- <span style="color:rgb(255, 149, 122)"><b>FTP Anónimo:</b></span>
    
    - Se activa en sitios que ponen a disposición **archivos de acceso público**.
    - El usuario accede <u>sin necesidad de proporcionar un nombre de usuario y contraseña reales</u>; se utiliza el nombre <span style="color:rgb(233, 122, 255)">"anonymous"</span> y, por convención, se ingresa una dirección de correo electrónico como contraseña.
    - Las <u>acciones del usuario son limitadas</u>, permitiéndose, por ejemplo, copiar archivos pero restringiendo la navegación completa por los directorios.

- <span style="color:rgb(255, 149, 122)"><b>FTP con Contraseña:</b></span>
    
    - <u>Requiere la autenticación</u> mediante un nombre de usuario y una contraseña válidos.
    - Ofrece un <u>control más estricto sobre el acceso</u> y las acciones que puede realizar el usuario.
    
- <span style="color:rgb(255, 149, 122)"><b>FTP Secure (FTPS):</b></span>
    
    - También conocido como FTP Secure Sockets Layer (FTP SSL).
    - Incrementa la seguridad al establecer conexiones en las que se activa el **<u>cifrado mediante Transport Layer Security (TLS)</u>** desde el inicio de la conexión.
    
- <span style="color:rgb(255, 149, 122)"><b>FTP sobre SSL/TLS Explícito (FTPES):</b></span>
    
    - Este método comienza la conexión a través del puerto 21 y posteriormente la actualiza a una conexión cifrada utilizando SSL/TLS.
    - Permite **mantener el canal seguro sin necesidad de utilizar un puerto de datos específico** para el cifrado.
    
- <span style="color:rgb(255, 149, 122)"><b>Secure FTP (SFTP):</b></span>
    
    - A pesar de su nombre, <span style="color:rgb(233, 122, 255)">SFTP no forma parte del protocolo FTP</span>, sino que e<u>s una extensión del protocolo Secure Shell (SSH)</u>.
    - Opera generalmente sobre el puerto 22 y **proporciona un método seguro y cifrado para la transferencia de archivos**.
--- 
## 1.3 JAVA FTP

<aside style="border: 2px solid orange; padding: 10px; border-radius: 5px;"> 
Aunque <u>es posible utilizar la API de red de Java</u> (mediante el uso de las interfaces y clases disponibles en los paquetes java.net y javax.net) <u>para escribir código que se comunique con un servidor FTP</u>, ese enfoque no se recomienda porque <b>tendrá que dedicar mucho tiempo a comprender el protocolo FTP subyacente</b>, implementar los controladores de protocolo, realizar pruebas, corregir errores... y, finalmente, ¡reinventar la rueda! En cambio, es recomendable buscar y adquirir algunas bibliotecas ya preparadas, y eso definitivamente le ahorrará tiempo. La biblioteca<span style="color:rgb(233, 122, 255)"> Apache Commons Net </span>es una opción ideal para desarrollar aplicaciones basadas en FTP.
</aside>

### 1.3.1 Apache Commons Net

>La librería **Apache Commons Net** proporciona implementaciones en el lado cliente de múltiples protocolos de Internet, entre ellos el FTP/FTPS. Su objetivo es facilitar el acceso a la funcionalidad básica de dichos protocolos sin necesidad de construir desde cero el manejo de las complejidades inherentes a cada uno.

#### **Características principales:**

- **Acceso Fundamental:**  
    La librería expone métodos y clases que permiten realizar operaciones básicas, dejando al programador la posibilidad de construir implementaciones personalizadas según sus necesidades.
    
- **Protocolos Soportados:**  
    Además de FTP/FTPS, Apache Commons Net soporta otros protocolos como:
    
    - FTP over HTTP (experimental)
    - NNTP
    - SMTP(S)
    - POP3(S)
    - IMAP(S)
    - Telnet
    - TFTP
    - Finger
    - Whois
    - rexec/rcmd/rlogin
    - Time (rdate) y Daytime
    - Echo, Discard y NTP/SNTP
    
- **Dependencia en Maven:**  
    Para utilizar la librería en un proyecto Maven, se debe incluir la siguiente dependencia:
	```xml
	<!-- https://mvnrepository.com/artifact/commons-net/commons-net -->
	<dependency>
	  <groupId>commons-net</groupId>
	  <artifactId>commons-net</artifactId>
	  <version>3.11.1</version>
	</dependency>
	```
    
- **Uso Básico:**  
    La clase `FTPClient` es la interfaz principal para establecer conexiones con un servidor FTP. Con ella, se puede:
    
    - <span style="color:rgb(110, 201, 120)">Conectar</span> al servidor utilizando el método ` void connect(String server, int port)`.
	    >Donde servidor puede ser un nombre de host o una dirección IP, y el puerto es un número (el protocolo FTP utiliza el puerto número 21).
    - Realizar el proceso de <span style="color:rgb(110, 201, 120)">autenticación</span> mediante `boolean login(String username, String password)`.
		>Este método devolverá `true` si la autenticación se raliza con éxito
    - Verificar las respuestas del servidor a través de métodos como `getReplyCode()` y `getReplyStrings()`.
        ```java 
	    int replyCode = ftpClient.getReplyCode(); 
	    if (!FTPReply.isPositiveCompletion(replyCode)) { 
	    // The operation was not successful 
	    // for some reasons, the server refuses or 
	    // rejects requested operation 
	    return; 
	    }
		```

		```java
		private static void showServerReply(FTPClient ftpClient) { 
			String[] replies = ftpClient.getReplyStrings(); 
			if (replies != null && replies.length > 0) { 
				for (String aReply : replies) { 
					System.out.println("SERVER: " + aReply); 
				} 
			} 
		}
		```

#### Ejemplo completo de implementación en código

```java
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main {
	 private static void showServerReply(FTPClient ftpClient) {
		 String[] replies = ftpClient.getReplyStrings();
		 if (replies != null && replies.length > 0) {
			 for (String aReply : replies) {
				 System.out.println("SERVER: " + aReply);
			 }
		 }
	 }

	 public static void main(String[] args) throws IOException {
	 String server = "localhost";
	 int port = 21;
	 String user = "noemi";
	 String pass = "noemi";
	 FTPClient ftpClient = new FTPClient();

	 try {
		 ftpClient.connect(server, port);
		 showServerReply(ftpClient);
		 int replyCode = ftpClient.getReplyCode();
		 
		 if (!FTPReply.isPositiveCompletion(replyCode)) {
			 System.out.println("Operation failed. Server reply code: " + replyCode);
			 return;
		 }
		 
		 boolean success = ftpClient.login(user, pass);
		 showServerReply(ftpClient);
		 
		 if (!success) {
			 System.out.println("Could not login to the server");
			 return;
			 
		 } else {
			 System.out.println("LOGGED IN SERVER");
		 }
		 
	 } catch (IOException ex) {
		 System.out.println("Something wrong happened");
		 ex.printStackTrace();
	 }
	 ftpClient.logout();
	 ftpClient.disconnect();
	 }
}
```

---

### 1.3.2 Listing files and directories in an FTP server

Una vez establecida la conexión, es común requerir la visualización de los archivos y directorios disponibles en el servidor FTP. Para ello, `FTPClient` proporciona varios métodos:

- **Métodos que devuelven objetos `FTPFile`:**
    
    - `FTPFile[] listDirectories()`
    - `FTPFile[] listDirectories(String parent)`
    - `FTPFile[] listFiles()`
    - `FTPFile[] listFiles(String pathname)`
    
    Estos métodos retornan un arreglo de objetos `FTPFile`, los cuales permiten obtener información detallada de cada archivo o directorio mediante métodos como:
    
    - `getName()`: Nombre del archivo o directorio.
    - `getSize()`: Tamaño en bytes.
    - `isDirectory()`: Indica si es un directorio.
    - `isFile()`: Indica si es un archivo.
    - `getTimestamp()`: Fecha y hora de la última modificación.
- **Métodos que devuelven nombres (String):**
    
    - `String[] listNames()`
    - `String[] listNames(String pathname)`
    
    Estos métodos devuelven simplemente un arreglo de cadenas con los nombres de los archivos y directorios, sin información adicional.
    

**Ejemplo de código para listar archivos y directorios:**

```java
FTPFile[] files = ftpClient.listFiles(); 
// iterates over the files and prints details for each 
DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 

for (FTPFile file : files) { 
	String details = file.getName();
	 
	if (file.isDirectory()) { 
		details = "[" + details + "]"; 
	} 
	
	details += "\t\t" + file.getSize(); 
	details += "\t\t" + dateFormater.format(file.getTimestamp().getTime()); 
	System.out.println(details); }
```

> **Nota:**  
> Dependiendo de la necesidad, se pueden utilizar los métodos que retornan objetos `FTPFile` para obtener más detalles o los que retornan `String` si solo se requiere una lista simple.

---

### 1.3.3 Java FTP file download

La descarga de archivos mediante FTP se puede realizar de dos formas con la clase `FTPClient`:

1. **Uso del método `retrieveFile(String remote, OutputStream local)`:**
    
    - **Descripción:**  
        Este método descarga un archivo remoto especificado por la ruta `remote` y lo escribe directamente en el `OutputStream` proporcionado (por ejemplo, un `FileOutputStream` para escribir en disco).
    - **Ventajas:**  
        Es sencillo de implementar, ya que se encarga internamente de la transferencia sin necesidad de gestionar la lectura y escritura de bytes manualmente.
    - **Consideraciones:**  
        Es importante cerrar el `OutputStream` después de la descarga y verificar el valor de retorno para confirmar que la operación fue exitosa.
2. **Uso del método `retrieveFileStream(String remote)`:**
    
    - **Descripción:**  
        Este método retorna un `InputStream` desde el cual se pueden leer los datos del archivo remoto.
    - **Ventajas:**  
        Permite un control más fino del proceso de descarga, como medir el progreso o gestionar la transferencia en bloques.
    - **Consideraciones:**
        - Se debe leer el `InputStream` en un bucle y escribir los datos en un `OutputStream`.
        - Es obligatorio llamar a `completePendingCommand()` al finalizar la lectura para concluir la transacción.
        - Tanto el `InputStream` como el `OutputStream` deben cerrarse explícitamente.

**Pasos generales para la descarga de un archivo:**

- Conectar y autenticar en el servidor.
- Cambiar a modo pasivo local mediante `enterLocalPassiveMode()`, lo cual es útil para atravesar firewalls.
- Configurar el tipo de archivo a transferir (recomendable `FTP.BINARY_FILE_TYPE` para archivos binarios).
- Definir la ruta del archivo remoto.
- Crear un `OutputStream` para escribir el archivo en disco.
- Utilizar alguno de los métodos de descarga (`retrieveFile` o `retrieveFileStream`).
- Finalizar la transacción, cerrar streams y desconectar.

**Ejemplo de código utilizando ambos métodos:**

```java
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import java.io.*;
public class FtpFileDownload {

	 public static void main(String[] args) {
- 
		 String server = "192.168.56.1";
		 int port = 21;
		 String user = "xxxxx";
		 String pass = "xxxxx";
		 FTPClient ftpClient = new FTPClient();
1. 
		 try {
			 ftpClient.connect(server, port);
			 ftpClient.login(user, pass);
			 ftpClient.enterLocalPassiveMode();
			 ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			 
			 // APPROACH #1: using retrieveFile(String, OutputStream)
			 String remoteFile1 = "/user/image.jpg";
			 File downloadFile1 = new File("image.jpg");
			 
			 OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
			 boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
			 outputStream1.close();
			 
			 if (success) {
				 System.out.println("File #1 has been downloaded successfully.");
			 }
			 
			 // APPROACH #2: using InputStream retrieveFileStream(String)
			 String remoteFile2 = "/images.png";
			 File downloadFile2 = new File("images.png");
			 OutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream(downloadFile2));
			 InputStream inputStream = ftpClient.retrieveFileStream(remoteFile2);
			 byte[] bytesArray = new byte[4096];
			 int bytesRead = -1;
			 
			 while ((bytesRead = inputStream.read(bytesArray)) != -1) {
				 outputStream2.write(bytesArray, 0, bytesRead);
			 }
			 
			 success = ftpClient.completePendingCommand();
			 if (success) {
				 System.out.println("File #2 has been downloaded successfully.");
			 }
			 outputStream2.close();
			 inputStream.close();
			 
		} catch (IOException ex) {
			 System.out.println("Error: " + ex.getMessage());
			 ex.printStackTrace();
			 
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
				
			} catch (IOException ex) {
				 ex.printStackTrace();
			}
		 }
	 }
}
```

---

### 1.3.4 Java FTP file upload

La subida de archivos a un servidor FTP es un proceso sencillo que, al igual que la descarga, se facilita mediante la clase `FTPClient`. En este caso se utiliza el método `storeFile(String remoteFilePath, InputStream local)`.

**Pasos para subir un archivo:**

2. **Preparación del entorno:**
    
    - Conectar y autenticarse en el servidor FTP.
    - Cambiar a modo pasivo local (`enterLocalPassiveMode()`) para evitar problemas con firewalls.
    - Establecer el tipo de archivo a `FTP.BINARY_FILE_TYPE` para asegurar que la transferencia se realice en modo binario.
3. **Proceso de subida:**
    
    - Crear un objeto `File` a partir de la ruta local del archivo.
    - Abrir un `InputStream` (por ejemplo, `FileInputStream`) para leer el contenido del archivo.
    - Llamar al método `storeFile()` pasando la ruta deseada en el servidor y el `InputStream`.
    - Cerrar el `InputStream` una vez completada la transferencia.
4. **Finalización:**
    
    - Verificar que la operación fue exitosa mediante el valor de retorno de `storeFile()`.
    - Realizar el cierre de la sesión con `logout()` y desconectar del servidor.

**Ejemplo de código para la subida de un único archivo:**

```java
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
public class FtpFileUpload {

	 /**
	 * Upload a single file to the FTP server.
	 *
	 * @param ftpClient
	 * an instance of org.apache.commons.net.ftp.FTPClient class.
	 * @param localFilePath
	 * Path of the file on local computer
	 * @param remoteFilePath
	 * Path of the file on remote the server
	 * @return true if the file was uploaded successfully, false otherwise
	 * @throws IOException
	 * if any network or IO error occurred.
	 */
- 
	 public static boolean uploadSingleFile(FTPClient ftpClient, String localFilePath, String remoteFilePath) throws IOException {
- 
		 File localFile = new File(localFilePath);
		 InputStream inputStream = new FileInputStream(localFile);
1. 
		 try {
			 ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			 return ftpClient.storeFile(remoteFilePath, inputStream);
		} finally {
			 inputStream.close();
		}
	}
	
		public static void main(String[] args) {
			 String server = "192.168.56.1";
			 int port = 21;
			 String user = "xxxxx";
			 String pass = "xxxxx";
			 FTPClient ftpClient = new FTPClient();
		
		 try {
			 // connect and login to the server
			 ftpClient.connect(server, port);
			 ftpClient.login(user, pass);
	  
			 // use local passive mode to pass firewall
			 ftpClient.enterLocalPassiveMode();
			 System.out.println("Connected");
			 String remoteFilePath = "./file.xml";
			 String localFilePath = "C:\\Users\\Name\\Downloads\\file.xml";
			 Boolean res = uploadSingleFile(ftpClient,localFilePath,remoteFilePath);
	  
			 if (res){
				 System.out.println("Upload successfully completed");
			 }
	 
			 // log out and disconnect from the server
			 ftpClient.logout();
			 ftpClient.disconnect();
			 System.out.println("Disconnected");
	 
		 } catch (IOException ex) {
			 ex.printStackTrace();
		 }
	 }
}

```

> **Nota Importante:**  
> Siempre se recomienda manejar las excepciones de E/S y asegurarse de cerrar correctamente los streams y conexiones para evitar pérdidas de recursos y posibles problemas de seguridad.


# 2. SFTP
