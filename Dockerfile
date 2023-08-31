# 1. Building the App with Maven
FROM maven:3.8.7-eclipse-temurin-19-alpine
ADD . /scm-springboot
WORKDIR /scm-springboot
# Just echo so we can see, if everything is there :)
RUN ls -l
# Run Maven build
RUN mvn clean install

# install open jdk 20
FROM openjdk:20-jdk
# https://security.alpinelinux.org/vuln/CVE-2021-46848
RUN apk add --upgrade libtasn1-progs
# https://security.alpinelinux.org/vuln/CVE-2022-37434
RUN apk update && apk upgrade zlib

RUN addgroup -g 10014 choreo && \
    adduser  --disabled-password  --no-create-home --uid 10014 --ingroup choreo choreouser \

VOLUME /tmp

USER 10014

# Add Spring Boot app.jar to Container
COPY --from=0 "/smc-springboot/target/school-*.jar" app.jar

# Fire up our Spring Boot app by default
CMD [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=render -jar /app.jar" ]

