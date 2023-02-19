FROM maven:3.8.7 AS maven
# Create a workdir for our app
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN --mount=type=cache,id=m2-cache,target=/root/.m2 mvn -f $HOME/pom.xml clean package


# Using java 11
FROM openjdk:17-jdk
ARG JAR_FILE=/usr/app/target/*.jar
# Copying JAR file
COPY --from=maven ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]