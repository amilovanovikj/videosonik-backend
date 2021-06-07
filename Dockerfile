# Build stage
FROM maven:3.8-jdk-8-slim as build
WORKDIR /home/videosonik
COPY src ./src
COPY pom.xml .
RUN mvn clean package -DskipTests

# Package stage
FROM openjdk:8-alpine
COPY --from=build /home/videosonik/target/store-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","store-0.0.1-SNAPSHOT.jar"]