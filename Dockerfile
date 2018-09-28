FROM openjdk:8-jre-alpine
ENV APP_FILE test-service-1.1-SNAPSHOT.jar
ENV APP_HOME /usr/apps
VOLUME ["/tmp", "/tmp/config", "/tmp/logs"]
ENV TIME_ZONE Europe/Tallinn
#RUN apk --no-cache add \
#	tzdata \
#    # Set timezone
#    && echo "${TIME_ZONE}" > /etc/timezone \ 
#	&& ln -sf /usr/share/zoneinfo/${TIME_ZONE} /etc/localtime
RUN echo "${TIME_ZONE}" > /etc/timezone 
#RUN ln -sf /usr/share/zoneinfo/${TIME_ZONE} /etc/localtime 
EXPOSE 8090
COPY target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]