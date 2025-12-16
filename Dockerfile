FROM eclipse-temurin:21-jdk

ARG JAR=target/*.jar

COPY ${JAR} product-service.jar

ENTRYPOINT ["java", "-jar", "product-service.jar"]

EXPOSE 8082