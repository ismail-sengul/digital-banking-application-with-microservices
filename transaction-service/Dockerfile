FROM openjdk:19-alpine3.16
COPY ./target/transaction-service-0.0.1-SNAPSHOT.jar transaction-service.jar
ENTRYPOINT ["java","-jar","/transaction-service.jar"]
EXPOSE 8764