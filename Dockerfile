#FROM bitnami/nginx:1.25.1
#
#WORKDIR /app
#
#COPY ./src .

FROM amazoncorretto:17-alpine
RUN apk update \
&& apk add curl
RUN mkdir -p /opt/laa-dces-dummy-drc/
WORKDIR /opt/laa-dces-dummy-drc/
COPY ./build/libs/laa-dces-dummy-drc*.jar /opt/laa-dces-dummy-drc/app.jar
RUN addgroup -S appgroup && adduser -u 1001 -S appuser -G appgroup
USER 1001
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]