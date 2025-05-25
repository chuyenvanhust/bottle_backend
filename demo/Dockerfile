# Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Thiết lập thư mục làm việc
WORKDIR /app

# Copy pom.xml và src từ thư mục demo vào container
COPY pom.xml .
COPY src ./src      

# Build project
RUN mvn clean package -DskipTests

# Runtime stage
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]