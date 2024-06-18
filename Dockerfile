FROM eclipse-temurin:18

WORKDIR /app

COPY target/hw-java-spring-0.0.1-SNAPSHOT.jar /app/hw-java-spring.jar
EXPOSE 8080

CMD ["java", "-jar", "hw-java-spring.jar"]