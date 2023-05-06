FROM amazoncorretto:20-alpine-jdk
VOLUME tmp
EXPOSE 5000
ARG JAR_FILE=target/onnee-0.0.1-SNAPSHOT.jar
COPY target/onnee-0.0.1-SNAPSHOT.jar onnee-1.jar
ADD ${JAR_FILE} onnee-1.jar
ENTRYPOINT ["java","-jar","/onnee-1.jar"]