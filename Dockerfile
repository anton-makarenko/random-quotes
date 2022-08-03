FROM amazoncorretto:17.0.3

RUN mkdir /opt/spring3-training

COPY build/libs/spring3-training-0.0.1.jar /opt/spring3-training

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/opt/spring3-training/spring3-training-0.0.1.jar"]