## DU4 - Exercise 8 - Search Wikipedia API information and upload to ftp server

Your task is to connect to the Wikipedia API to download information about the most viewed articles by country on a given date.

The program has to request the **country code** and the **date** from the user. Using that information, it has to connect to the web service and get the information.

After receiving the information, it has to **store** it in a **json file** whose **path** has to **report** the **country code** and **date**. **Pretty print** the data in the **json file**.

**Upload** the file to your local Serva **FTP server** using the **same name** used in the **project**. Do not use an anonymous user.

---

Tu tarea es conectarte a la API de Wikipedia para descargar información sobre los artículos más vistos por país en una fecha determinada.

El programa debe solicitar al usuario el código de país y la fecha. Con esa información, debe conectarse al servicio web y obtener la información.

Después de recibir la información, debe almacenarla en un archivo json cuya ruta debe indicar el código de país y la fecha. Imprime los datos en el archivo json.

Sube el archivo a tu servidor FTP local de Serva usando el mismo nombre que se usó en el proyecto. No uses un usuario anónimo.

- Ejemplo de API: https://wikimedia.org/api/rest_v1/metrics/pageviews/top/es.wikipedia/all-access/2025/02/25