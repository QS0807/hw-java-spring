FROM eclipse-temurin:18

WORKDIR /app

COPY target/hw-java-spring.jar hw-java-spring.jar
EXPOSE 8080

CMD ["java", "-jar", "hw-java-spring.jar"]