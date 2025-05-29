# Use Java 17 base image
FROM eclipse-temurin:17-jdk-jammy

# Create a directory in the image
WORKDIR /app

# Copy the built JAR into the image
COPY target/ajopayback-0.0.1-SNAPSHOT.jar app.jar

# Expose the port (default for Spring Boot)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
