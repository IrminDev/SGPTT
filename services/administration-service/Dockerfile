FROM openjdk:23-jdk AS builder

WORKDIR /app

RUN microdnf install findutils

COPY build.gradle settings.gradle gradlew /app/

COPY gradle /app/gradle

RUN ./gradlew dependencies --no-daemon || true

COPY src /app/src

RUN ./gradlew build -x test --no-daemon

FROM eclipse-temurin:23-jre-alpine

WORKDIR /app

COPY --from=builder /app/build/libs/administration-service-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]