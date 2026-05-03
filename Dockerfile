FROM openjdk:17

WORKDIR /app

# ❌ Wrong file name (jar won’t exist)
COPY target/demo.jar app.jar

# ❌ Running as root
ENTRYPOINT ["java","-jar","app.jar"]