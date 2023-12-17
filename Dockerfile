FROM openjdk:17-jdk-alpine
LABEL maintainer='jbur'
VOLUME /tmp
EXPOSE 8443
ARG JAR_FILE=target/spring-boot-ecommerce-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} spring-boot-ecommerce.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-ecommerce.jar"]
