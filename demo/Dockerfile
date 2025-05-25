# Dùng JDK 17 để chạy ứng dụng Spring Boot
FROM openjdk:21-jdk-slim

# Thư mục làm việc bên trong container
WORKDIR /app

# Sao chép file jar từ local vào container
COPY target/*.jar app.jar

# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
