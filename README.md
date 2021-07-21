# prueba-desarrollo-back

Docker compose
En la carpeta scripts se encuentra el archivo scripts/docker.compose.yml, este archivo tiene la configuración que se creara en docker.

Prerrequisito: tener instalado docker.
-	Ejecutar el comando para verificar que esta instalado: docker-compose -v.
La respuesta debe ser parecida a: docker-compose version 1.29.0, build 07737305

Si no se encuentra instalado puede seguir el siguiente link Instalación docker compose

Para crear el contenedor para el servidor de base de datos MySQL se debe ejecutar el archivo docker-compose.yml:

-	abrir la terminal en donde tenga descargado el archivo docker-compose.yml.
-	ejecutar el comando: docker-compose up
-	verificar en el Dashboard de docker la ejecución del contenedor.

Una vez creado el contenedor para el servidor MySQL procedemos a crear la entidad employees, el script se encuentra en scripts/pruebatecnica.sql

Para ejecutar la aplicación back, en localhost una vez descargado el código fuente se debe tener instalada la versión de Java 8 y Maven.

-	Abrir la consola en la carpeta donde se descargo el proyecto del back.
-	Ejecutar el comando: mvn clean build package nombre_carpeta
-	En la consola ejecutar: java -jar target/employee-manager-0.0.1-SNAPSHOT.jar

