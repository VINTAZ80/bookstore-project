# Use a Java base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the project files
COPY . /app

# Install Maven Wrapper if not included
RUN ./mvnw -v || apt-get update && apt-get install -y maven

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["./mvnw", "spring-boot:run"]
