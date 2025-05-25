# Build stage: build project bằng Maven
FROM maven:3.8.7-openjdk-21 AS build

WORKDIR /app

# Copy pom.xml và source code vào
COPY pom.xml .
COPY src ./src

# Build project, skip test để nhanh (nếu muốn test thì bỏ -DskipTests)
RUN mvn clean package -DskipTests

# Final stage: chỉ dùng JDK để chạy
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copy file jar từ stage build sang
COPY --from=build /app/target/*.jar app.jar

# Chạy app
ENTRYPOINT ["java", "-jar", "app.jar"]
