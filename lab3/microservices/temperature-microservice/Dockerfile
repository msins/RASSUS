FROM amazoncorretto:17
ARG JAR_FILE=target/temperature-microservice-0.0.1.jar
COPY ${JAR_FILE} /temperature-microservice-0.0.1.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/temperature-microservice-0.0.1.jar"]