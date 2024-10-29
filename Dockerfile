FROM openjdk:17-jdk
COPY target/cafe.project-0.0.1-SNAPSHOT.jar cafe.project-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "cafe.project-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
