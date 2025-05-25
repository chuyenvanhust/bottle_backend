FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
# Copy từ thư mục demo/ (build context) vào container
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]