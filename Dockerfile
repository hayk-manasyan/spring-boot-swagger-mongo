FROM openjdk:8
VOLUME /data/springboot-docker-compose-app
ADD target/demo-1.jar demo-1.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","demo-1.jar"]