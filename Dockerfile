# Use an official OpenJDK runtime as a parent image
FROM adoptopenjdk/openjdk17:alpine-jre

# Set the working directory to /app
WORKDIR /app

# Copy the pom.xml file to the container
COPY . /app/

# Give permission to mvnw
RUN chmod +x mvnw

# Build the application
RUN ./mvnw package

# Expose port 8080
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "./target/xmeme-0.0.1-SNAPSHOT.jar"]