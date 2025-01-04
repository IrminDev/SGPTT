FROM openjdk:23-jdk as builder

WORKDIR /app

RUN microdnf install findutils

COPY build.gradle.kts /app/

COPY settings.gradle.kts /app/

COPY gradlew /app/

COPY gradle /app/gradle

RUN ./gradlew dependencies --no-daemon || true

COPY src /app/src

RUN ./gradlew build --no-daemon

FROM eclipse-temurin:23-jre-alpine

WORKDIR /app

COPY --from=builder /app/build/libs/auth-service-0.0.1-SNAPSHOT.jar /app/jar/app.jar

EXPOSE 8090

CMD ["java", "-jar", "./jar/app.jar"]