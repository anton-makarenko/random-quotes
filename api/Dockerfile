FROM amazoncorretto:17.0.4

RUN mkdir /opt/random-quotes-api

COPY build/libs/api-1.0.0.jar /opt/random-quotes-api

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/opt/random-quotes-api/api-1.0.0.jar"]