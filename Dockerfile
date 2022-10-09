FROM openjdk:11
VOLUME /tmp
COPY target/studentProgram-0.0.1-SNAPSHOT.jar backend.jar
RUN bash -c "touch /backend.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","backend.jar"]