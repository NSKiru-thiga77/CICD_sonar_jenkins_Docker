FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/*.jar app.jar

RUN addgroup app && adduser --system --ingroup app app
USER app

ENTRYPOINT ["java","-jar","app.jar"]