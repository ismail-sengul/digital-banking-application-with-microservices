FROM openjdk:19-alpine3.16
COPY ./target/account-service-0.0.1-SNAPSHOT.jar account-service.jar
ENTRYPOINT ["java","-jar","/account-service.jar"]
EXPOSE 8763