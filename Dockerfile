# Build
FROM maven:3.6.3-jdk-11-slim AS BUILD

ENV APP_FOLDER=~/game-store-api

WORKDIR ${APP_FOLDER}

COPY src src
COPY pom.xml pom.xml

RUN --mount=type=cache,target=/root/.m2 mvn -Dmaven.test.skip=true clean package

# Run
FROM openjdk:11-jre-slim

ENV APP_NAME=game-store
ENV APP_FOLDER=~/game-store-api

WORKDIR ${APP_FOLDER}

COPY --from=BUILD  "${APP_FOLDER}/target/${APP_NAME}*.jar" ${APP_NAME}.jar

ENTRYPOINT java -jar ${APP_NAME}.jar