FROM openjdk:8-jdk-alpine
EXPOSE 9999
COPY /target/springbootappbootcamp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
MAINTAINER "Avishek Modak"

