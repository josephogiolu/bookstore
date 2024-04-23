##LABEL authors="josephogiolu"
# Use a base image with Java (choose an appropriate JDK version)
FROM openjdk:21-jdk

# Set the working directory inside the container
##
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/bookstore-service.jar /app/bookstore-service.jar

# Expose the port your application will run on
EXPOSE 8007

# Specify the command to run your application
CMD ["java", "-jar", "bookstore-service.jar"]