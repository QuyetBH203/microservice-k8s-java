# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file generated by Maven into the container
# Assumes the JAR file is named api-gateway.jar in the target directory
# You might need to adjust the JAR file name based on your pom.xml (artifactId and version)
COPY target/api-gateway-*.jar app.jar

# Make port 9000 available to the world outside this container
EXPOSE 9000

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]