FROM openjdk:11
COPY target/gateway-0.0.1-SNAPSHOT.jar /gateway-service.jar
RUN keytool -genkeypair -alias name.keystore -keypass adminadmin -keyalg RSA -keysize 2048 -validity 365 -keystore ./ebook.keystore -storepass adminadmin
ENTRYPOINT ["java", "-jar", "/gateway-service.jar", "--server.ssl.key-store=./ebook.keystore", "--", "-c"]
EXPOSE 8080 443