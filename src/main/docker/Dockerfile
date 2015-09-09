FROM java:8
VOLUME /tmp
ADD spring-boot-docker-test-00.01.00.jar app.jar
RUN bash -c "touch /app.jar"
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
