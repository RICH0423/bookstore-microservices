FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
VOLUME /tmp
COPY target/order-service-1.0.0.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -jar /app.jar