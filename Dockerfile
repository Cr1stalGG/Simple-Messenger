FROM openjdk:20

ADD ./target/Simple-Messenger-0.0.1-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]