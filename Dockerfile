FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/rest-0.0.1-SNAPSHOT.jar rest.jar
ENTRYPOINT ["java","-jar","/rest.jar"]
