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
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

# Puerto configurable (Railway usa $PORT, por defecto 8080)
ENV PORT=8080

EXPOSE ${PORT}

ENTRYPOINT ["java","-jar","app.jar","--server.port=${PORT}"]
