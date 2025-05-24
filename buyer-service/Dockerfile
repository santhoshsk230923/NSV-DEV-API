# ---------- STAGE 1: Build ----------
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

COPY . .
RUN chmod +x mvnw

ARG MODULE
RUN ./mvnw clean package -pl $MODULE -am -DskipTests

# ---------- STAGE 2: Run ----------
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

ARG MODULE
COPY --from=builder /app/${MODULE}/target/*.jar app.jar

ENV SPRING_PROFILES_ACTIVE=staging
EXPOSE 8080
CMD ["sh", "-c", "java -jar app.jar --spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]
