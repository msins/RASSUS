FROM amazoncorretto:17
ARG JAR_FILE=target/humidity-microservice-0.0.1.jar
COPY ${JAR_FILE} /humidity-microservice-0.0.1.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/humidity-microservice-0.0.1.jar"]