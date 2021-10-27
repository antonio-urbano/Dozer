FROM maven:3.8.1-openjdk-11 AS BUILD

WORKDIR /app

COPY pom.xml pom.xml

RUN mvn dependency:go-offline

COPY src src

RUN mvn package assembly:single

FROM openjdk:11

COPY --from=BUILD /app/target/seraph.pipeline-0.1-jar-with-dependencies.jar /app/seraphengine.jar

CMD ["java", "-jar", "/app/seraphengine.jar"]

