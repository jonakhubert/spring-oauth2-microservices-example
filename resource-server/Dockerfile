# maven image to build the application
FROM maven:3.8.8-eclipse-temurin-21-alpine AS builder

# working directory for the application
WORKDIR /app

# copy pom file from host to the container
COPY pom.xml ./

# download all project dependencies
RUN mvn dependency:go-offline

# copy java source code to the container
COPY src ./src

# build the application
RUN mvn clean package

# smaller JDK runtime image to run the application
FROM alpine/java:21-jdk

WORKDIR /app

# copy the built JAR from the builder stage
COPY --from=builder /app/target/resource-server.jar /app/resource-server.jar

# run the application
CMD ["java", "-jar", "/app/resource-server.jar"]