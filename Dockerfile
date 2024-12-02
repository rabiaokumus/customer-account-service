FROM eclipse-temurin:21.0.2_13-jdk as stage

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory within the container
WORKDIR /app

# Copy the application source code and Maven files to the container
COPY src /app/src
COPY pom.xml /app/
# Download the project dependencies and build the application
RUN mvn -f /app/pom.xml clean package -DskipTests
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "/app/target/customeraccount-0.0.1-SNAPSHOT.jar"]