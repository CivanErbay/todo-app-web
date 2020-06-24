FROM openjdk:14

ENV ENVIRONMENT=prod

MAINTAINER Civan Erbay <civan.erbay@web.de>

ADD todo-app-web/target/todo-app-web.jar app.jar

CMD [ "sh", "-c", "java -Dserver.port=$PORT -jar /app.jar" ]