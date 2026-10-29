# Etapa 1: Construcción con Maven
FROM maven:3.9.9-eclipse-temurin-17-alpine AS build

# Establecer directorio de trabajo
WORKDIR /app

# Copiar archivos de Maven
COPY pom.xml .
COPY src ./src

# Compilar el proyecto (saltando tests)
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final para ejecutar
FROM eclipse-temurin:17-jre-alpine

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el JAR compilado desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto 8080
EXPOSE 8080

# Comando para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]