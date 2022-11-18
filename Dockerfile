# syntax=docker/dockerfile:1
FROM gradle:jdk8 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:8-jre-slim

EXPOSE 8080

RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/SparkExperimentation-1.0-SNAPSHOT.jar /app/spark-application.jar

ENTRYPOINT ["java", "-jar","/app/spark-application.jar"]