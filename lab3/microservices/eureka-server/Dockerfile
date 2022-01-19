FROM amazoncorretto:17
ARG JAR_FILE=target/eureka-server-0.0.1.jar
COPY ${JAR_FILE} /eureka-server-0.0.1.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/eureka-server-0.0.1.jar"]