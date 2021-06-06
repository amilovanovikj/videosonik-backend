# Build stage
FROM maven:3.8-jdk-8-slim as build
WORKDIR /home/videosonik
COPY src ./src
COPY pom.xml .
RUN mvn clean package -DskipTests

# Package stage
FROM tomcat:9.0-jdk8-slim
COPY --from=build /home/videosonik/target/store-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","store-0.0.1-SNAPSHOT.jar"]