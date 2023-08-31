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


RUN addgroup -g 10015 choreo && \
    adduser  --disabled-password  --no-create-home --uid 10015 --ingroup choreo1 choreouser1 \

VOLUME /tmp

USER 10015

# Add Spring Boot app.jar to Container
COPY --from=0 "/smc-springboot/target/school-*.jar" app.jar

# Fire up our Spring Boot app by default
CMD [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=render -jar /app.jar" ]

