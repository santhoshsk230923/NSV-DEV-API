# Stage 1: Build the JAR
FROM maven:3.9.6-eclipse-temurin-17 as builder
WORKDIR /app

# Copy pom.xml and download dependencies first (leverages Docker cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy rest of the source code
COPY src ./src

# Build the JAR file
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:17
WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8084

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]

