FROM amazoncorretto:17.0.4

RUN mkdir /opt/random-quotes

COPY build/libs/downloader-1.0.0.jar /opt/random-quotes

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/opt/random-quotes/downloader-1.0.0.jar"]