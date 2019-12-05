FROM openjdk:8-jre-alpine

MAINTAINER Raony Barbosa

ENV LANG C.UTF-8
RUN mkdir /app
WORKDIR /app
COPY target/ecommerce-bl2-1.0.jar  ecommerce-bl2.jar 

ENTRYPOINT exec java \
$JAVA_OPTS \
$APP_ARGS
EXPOSE 8080
