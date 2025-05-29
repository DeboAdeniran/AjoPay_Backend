# Stage 1: Build the JAR inside Docker
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copy only the necessary files to leverage Docker cache efficiently
COPY pom.xml .
COPY src ./src

# Build the project and skip tests (optional)
RUN mvn clean package -DskipTests

# Stage 2: Use a smaller image to run the app
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copy the built JAR from the previous build stage
COPY --from=build /app/target/ajopayback-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
