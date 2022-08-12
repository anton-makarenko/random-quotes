FROM amazoncorretto:17.0.4

RUN mkdir /opt/random-quotes

COPY build/libs/api-1.0.0.jar /opt/random-quotes

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/opt/random-quotes/api-1.0.0.jar"]