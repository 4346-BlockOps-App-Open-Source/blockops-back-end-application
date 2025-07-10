# Use official openjdk 21 LTS runtime as base
FROM eclipse-temurin:21-jdk as builder

WORKDIR /app

# Copiamos el código fuente y construimos el JAR con Maven wrapper
COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw
COPY src src
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# En la imagen final solo copiamos el jar generado
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/blockops-backend-aplication-0.0.1-SNAPSHOT.jar app.jar

ENV PORT=8080
EXPOSE ${PORT}
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=${PORT}"]