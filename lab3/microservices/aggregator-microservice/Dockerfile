FROM amazoncorretto:17
ARG JAR_FILE=target/aggregator-microservice-0.0.1.jar
COPY ${JAR_FILE} /aggregator-microservice-0.0.1.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/aggregator-microservice-0.0.1.jar"]