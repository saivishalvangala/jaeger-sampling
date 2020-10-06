FROM openjdk:11
WORKDIR example-app/src
EXPOSE 8082
ADD ./target/example-app-0.0.1-SNAPSHOT.jar example-app.jar
CMD ["java", "-jar", "example-app.jar"]
