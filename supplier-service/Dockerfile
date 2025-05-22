FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy only necessary files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY ../pom.xml ../pom.xml
COPY src src

# Build the JAR inside Docker image
RUN ./mvnw clean package -DskipTests

# Automatically detect and run the built JAR
RUN cp target/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8083

CMD ["java", "-jar", "app.jar"]
