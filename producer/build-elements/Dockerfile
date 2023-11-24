FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /app
COPY . /app/.
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true

FROM eclipse-temurin:17-jre-alpine
VOLUME /tmp

WORKDIR /app
COPY --from=builder /app/target/*.jar /app/producer.jar
COPY --from=builder --chmod=0755 /app/build-elements/run.sh /run.sh
EXPOSE 8080

ENTRYPOINT ["/run.sh"]