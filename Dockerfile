FROM openjdk:11
LABEL SAI KALYAN UPPALA
COPY target/REST-For-Postman-1.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# to build an image ---> docker build --tag=rest-for-postman:latest .
# to run above image ---> docker run --dit -p 7777:8181 3e30fdfbd6c4 (image id)