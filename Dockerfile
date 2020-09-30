FROM openjdk:8-jdk-alpine
EXPOSE 8082
COPY /target/Junit-Test-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
MAINTAINER "Avishek Modak"

