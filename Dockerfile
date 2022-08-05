FROM amazoncorretto:17.0.4

RUN mkdir /opt/random-quotes-web

COPY build/libs/random-quotes-web-1.0.0.jar /opt/random-quotes-web

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/opt/spring3-training/random-quotes-web.jar"]