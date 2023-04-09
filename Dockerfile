# Pull tomcat latest image from dockerhub
FROM tomcat:8.0.51-jre8-alpine
MAINTAINER kusumwakare511@gmail.com
# copy war file on to container
COPY ./target/restro*.war /usr/local/tomcat/webapps
EXPOSE  8080
USER restro
WORKDIR /usr/local/tomcat/webapps
CMD ["catalina.sh","run"]