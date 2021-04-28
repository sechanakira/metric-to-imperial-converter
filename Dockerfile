FROM openjdk:11-jre-slim
EXPOSE 8090
WORKDIR /app
COPY target/metric-to-imperial-converter-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "metric-to-imperial-converter-0.0.1-SNAPSHOT.jar" ]
