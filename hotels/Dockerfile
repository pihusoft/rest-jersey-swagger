FROM tomcat:9.0

MAINTAINER "Amit Kumar"

EXPOSE 8080

RUN rm -rf /usr/local/tomcat/webapps/*

COPY ./target/hotels.war /usr/local/tomcat/webapps/ROOT.war

CMD ["catalina.sh","run"]