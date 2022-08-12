FROM amazoncorretto:17.0.4

RUN mkdir /opt/random-quotes-downloader

COPY build/libs/downloader-1.0.0.jar /opt/random-quotes-downloader

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/opt/random-quotes-downloader/downloader-1.0.0.jar"]