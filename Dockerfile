#FROM openjdk:8-jdk-alpine
ARG ARCH
FROM ${ARCH}adoptopenjdk:8-jre
MAINTAINER Alok Singh (alok.ku.singh@gmail.com)
EXPOSE 8080
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} /opt/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-jar","/opt/app.jar"]