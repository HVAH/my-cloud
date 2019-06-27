FROM openjdk:8-jre-alpine
MAINTAINER Ken Huang <ken.h@ycvr.com>

VOLUME ["/tmp"]
ARG JAR_FILE
ADD target/${JAR_FILE} app.jar
#RUN sh -c 'touch /app.jar'
EXPOSE 18000

ENTRYPOINT ["/usr/bin/java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
