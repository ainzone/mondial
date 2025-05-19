FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/quarkus-app/lib/ /app/lib/
COPY target/quarkus-app/*.jar /app/
COPY target/quarkus-app/app/ /app/app/
COPY target/quarkus-app/quarkus/ /app/quarkus/
ENV JAVA_OPTS="-Dquarkus.http.host=0.0.0.0"
CMD ["java", "-jar", "/app/quarkus-run.jar"]