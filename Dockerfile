FROM amazoncorretto:17.0.4

RUN mkdir /opt/random-quote-generator

COPY build/libs/random-quote-generator-1.0.0.jar /opt/random-quote-generator

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/opt/spring3-training/random-quote-generator-1.0.0.jar"]