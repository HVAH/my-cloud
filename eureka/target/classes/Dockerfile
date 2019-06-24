FROM java:8
VOLUME /tmp
ADD discovery-1.0.0.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 28000
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar" ]