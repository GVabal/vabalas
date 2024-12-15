FROM maven:3.9.9-eclipse-temurin-21 AS build
ARG APP_PATH
WORKDIR /app
RUN mkdir -p $APP_PATH
COPY ./pom.xml .
COPY ./$APP_PATH/pom.xml ./$APP_PATH
COPY ./$APP_PATH/src ./$APP_PATH/src
RUN mvn package -f $APP_PATH/pom.xml -DskpTests

FROM eclipse-temurin:21-jre-noble
ARG APP_PATH
VOLUME /tmp
COPY --from=build /app/$APP_PATH/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
