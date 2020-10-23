FROM openjdk:8-jre-alpine
ADD /src/main/resources/application.properties //

ADD /target/bookinventory-0.0.1-SNAPSHOT.jar //
ENTRYPOINT ["java", "-jar", "/bookinventory-0.0.1-SNAPSHOT.jar"]
