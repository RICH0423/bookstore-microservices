FROM openjdk:8-jdk-alpine
MAINTAINER Rich.Lee <rich04230@gmail.com>

RUN apk --no-cache add curl
RUN apk add --no-cache bash

ENV SPRING_PROFILES_ACTIVE local
ENV EUREKA_DEFAULT_ZONE http://localhost:8761/eureka/

VOLUME /tmp

COPY target/order-service-1.0.0.jar app.jar
ENV JAVA_OPTS="-Xmx128m -Xms128m"
ENTRYPOINT ["java", $JAVA_OPTS, "-jar", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "-Deureka.client.serviceUrl.defaultZone=${EUREKA_DEFAULT_ZONE}", "/app.jar"]