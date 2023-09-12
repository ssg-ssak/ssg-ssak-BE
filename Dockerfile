# server를 위한 dockerfile

FROM openjdk:17-alpine
COPY build/libs/ssgpoint-user-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]