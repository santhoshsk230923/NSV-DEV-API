FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy everything from root, assuming the Docker build context is the root of the project
COPY . .

# Make sure mvnw is executable
RUN chmod +x mvnw

# Build only the transaction-service module
RUN ./mvnw clean package -pl invoice-with-gst-services -am -DskipTests

# Set working directory to the module
WORKDIR /app/invoice-with-gst-services

# Copy the generated JAR to a consistent name
RUN cp target/*.jar app.jar

EXPOSE 8085

CMD ["java", "-jar", "app.jar"]
