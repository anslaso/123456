FROM maven:3.8-jdk-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY src/main/webapp ./src/main/webapp
COPY src/main/resources ./src/main/resources
RUN mvn -f pom.xml -DskipTests package

FROM tomcat:9.0-jdk11
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=build /app/target/ssm-demo.war /usr/local/tomcat/webapps/ssm-demo.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
