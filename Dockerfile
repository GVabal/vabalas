FROM eclipse-temurin:21-jre-noble
COPY target/app-*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
