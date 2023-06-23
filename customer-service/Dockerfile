FROM openjdk:19-alpine3.16
COPY ./target/customer-service-0.0.1-SNAPSHOT.jar customer-service.jar
ENTRYPOINT ["java","-jar","/customer-service.jar"]
EXPOSE 8762