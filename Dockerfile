FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/bookstoremain.jar app.jar

ENTRYPOINT ["java", "-jar", "app.ja r"]