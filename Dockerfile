FROM eclipse-temurin:17-jdk

COPY target/studentApplication-0.0.1-SNAPSHOT.jar studentApplication.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","studentApplication.jar"]