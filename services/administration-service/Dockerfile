FROM openjdk:23-jdk

WORKDIR /app

RUN microdnf install findutils

COPY . /app

RUN ./gradlew dependencies --no-daemon || true

EXPOSE 8080