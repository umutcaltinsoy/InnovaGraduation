FROM maslick/minimalka:jdk11
MAINTAINER Umut Cagri Altinsoy <umutcaltinsoy@gmail.com>
WORKDIR /app
EXPOSE 9001
COPY target/banking-project-innovapatika-0.0.1-SNAPSHOT.jar ./app.jar
CMD java $JAVA_OPTIONS -jar app.jar