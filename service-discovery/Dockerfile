FROM openjdk:8-jdk-alpine
MAINTAINER Rich.Lee <rich04230@gmail.com>

RUN apk --no-cache add curl
RUN apk add --no-cache bash

VOLUME /tmp
EXPOSE 8761

COPY target/service-discovery-1.0.0.jar app.jar
ENV JAVA_OPTS="-Xmx128m -Xms128m"
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar