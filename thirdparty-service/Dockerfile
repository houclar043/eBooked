FROM openjdk:11
COPY target/thirdparty-0.0.1-SNAPSHOT.jar /thirdparty-service.jar
ENTRYPOINT ["java", "-jar", "/thirdparty-service.jar"]
EXPOSE 8089