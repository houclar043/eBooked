FROM openjdk:11
COPY target/auth-0.0.1-SNAPSHOT.jar /user-service.jar
ENTRYPOINT ["java", "-jar", "/user-service.jar"]
EXPOSE 8088