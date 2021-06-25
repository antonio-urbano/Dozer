FROM maven:3.8.1-openjdk-11 AS BUILD

WORKDIR /app

COPY pom.xml pom.xml
COPY src src

RUN mvn package assembly:single

