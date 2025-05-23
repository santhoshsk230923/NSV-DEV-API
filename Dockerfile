# ---------- STAGE 1: Build ----------
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copy full source
COPY . .
RUN chmod +x mvnw

# Accept a build-time argument to choose the module
ARG MODULE
RUN ./mvnw clean package -pl $MODULE -am -DskipTests

# ---------- STAGE 2: Run ----------
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

ARG MODULE
COPY --from=builder /app/${MODULE}/target/*.jar app.jar

EXPOSE 8088
CMD ["java", "-jar", "app.jar"]
