FROM openjdk:11
LABEL SAI KALYAN UPPALA
COPY target/REST-For-Postman-1.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]