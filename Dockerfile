# Root-level Dockerfile
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy full source
COPY . .

# Make Maven wrapper executable
RUN chmod +x mvnw

# Set build argument for target module (e.g., transaction-service)
ARG MODULE=buyer-service

# Build only the specified module and its dependencies
RUN ./mvnw clean package -pl $MODULE -am -DskipTests

# Change to the module directory
WORKDIR /app/$MODULE

# Copy JAR to known name
RUN cp target/*.jar app.jar

# Expose port (you can override in Railway's config)
EXPOSE 8088

# Run the built JAR
CMD ["java", "-jar", "app.jar"]
