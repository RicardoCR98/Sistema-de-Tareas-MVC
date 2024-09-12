# Primera etapa: Usar Maven con OpenJDK 11 como base
FROM maven:3.8.6-openjdk-11 AS build

# Crear un directorio de trabajo
WORKDIR /app

# Copiar el archivo pom.xml y descargar dependencias
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copiar todo el código fuente del proyecto
COPY src ./src

# Compilar el proyecto y generar el WAR usando Java 11
RUN mvn clean package -DskipTests

# Segunda etapa: Usar una imagen base de Tomcat con JDK 11 para ejecutar la aplicación
FROM tomcat:9.0-jdk11

# Instalar el cliente MySQL
RUN apt-get update && apt-get install -y mysql-client

# Configurar Tomcat para desplegar automáticamente archivos WAR
RUN sed -i 's/<Context>/<Context unpackWARs="true">/' /usr/local/tomcat/conf/context.xml

# Eliminar cualquier aplicación predeterminada en ROOT
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copiar el archivo WAR generado en la primera etapa
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Exponer el puerto 8080
EXPOSE 8080

# Comando para iniciar Tomcat
CMD ["catalina.sh", "run"]
