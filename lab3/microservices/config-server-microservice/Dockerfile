FROM amazoncorretto:17
ARG JAR_FILE=target/config-server-microservice-0.0.1.jar
COPY ${JAR_FILE} /config-server-microservice-0.0.1.jar
ENTRYPOINT ["java","-jar","/config-server-microservice-0.0.1.jar"]