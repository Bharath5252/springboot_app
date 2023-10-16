# build step
FROM node:20
RUN mkdir /app
COPY ./src /app/src
COPY ./public /app/public
COPY ./package.json /app/package.json
WORKDIR /app
RUN npm install
COPY ./docker-entrypoint.sh /app/docker-entrypoint.sh
ENV MQTT_HOST=localhost
ENV REST_HOST=localhost

CMD /app/docker-entrypoint.sh ${REST_HOST} ${MQTT_HOST}


