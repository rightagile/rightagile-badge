FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD badge-boot app.jar

ENTRYPOINT ["java", "-Xms512m", "-Xmx512m", "-Dspring.profiles.active=k8s", "-jar", "app.jar"]
