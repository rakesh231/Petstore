FROM adoptopenjdk/openjdk8:alpine
VOLUME /tmp
ARG GIT_COMMIT
LABEL GitCommit=${GIT_COMMIT}
ADD target/petstore-demo-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT exec java -Xmx2000m -Xms500m -XX:+UseG1GC -jar /app/app.jar
