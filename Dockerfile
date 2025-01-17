# Etapa de construcción
FROM eclipse-temurin:17-alpine AS builder

WORKDIR /app

COPY ./pom.xml ./mvnw ./
COPY ./.mvn .mvn/

# Instalamos dependencias antes de copiar el código fuente
RUN ./mvnw dependency:go-offline -B

# Copiamos el código fuente y construimos la aplicación
COPY ./src ./src
RUN ./mvnw clean package -DskipTests && rm -rf ./src

# Etapa de ejecución
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Creamos la carpeta de logs
RUN mkdir ./logs

# Copiamos el jar generado
COPY --from=builder /app/target/ms-moneda-0.0.1-SNAPSHOT.jar .

# Variables de entorno y puerto
ENV PORT=8080
EXPOSE $PORT

# Configuramos el entrypoint
ENTRYPOINT ["java", "-jar", "ms-moneda-0.0.1-SNAPSHOT.jar"]