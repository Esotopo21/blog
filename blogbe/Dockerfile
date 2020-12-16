FROM tomcat:9-jre8-alpine
RUN rm -R /usr/local/tomcat/webapps/* && \
    mkdir -p /usr/local/tomcat/webapps/ROOT

ADD rest/target/blogbe.war /usr/local/tomcat/webapps
EXPOSE 8080
CMD ["catalina.sh", "run"]
