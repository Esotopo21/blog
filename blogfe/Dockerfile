FROM tomcat:9-jre8-alpine
RUN rm -R /usr/local/tomcat/webapps/* && \
    mkdir -p /usr/local/tomcat/webapps/ROOT

RUN mkdir -p /usr/local/tomcat/webapps/blog
ADD target/blogfe.war /usr/local/tomcat/webapps/blog
RUN cd /usr/local/tomcat/webapps/blog/ && unzip blogfe.war
EXPOSE 4200
CMD ["catalina.sh", "run"]
