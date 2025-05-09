FROM tomcat:9-jdk11-temurin

ADD target/DAPP01Practica05-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps

EXPOSE 8080

CMD ["catalina.sh", "run"]
