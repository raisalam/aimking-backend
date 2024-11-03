# Use the official JDK 17 image
FROM openjdk:17-jdk-slim

# Expose the application port
EXPOSE 8080

# Copy your application JAR file to the container (assuming it's in the local directory)
COPY build/libs/*.jar aimking-backend.jar

# Run the application
ENTRYPOINT ["java", "-jar", "aimking-backend.jar"]
