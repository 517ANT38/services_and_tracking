#!/bin/sh
cd $(dirname $0) || exit 1
cd kafka-consumer
docker build -f build-docker/Dockerfile -t serv/consumer .
cd ..
cd kafka-producer
docker build -f build-docker/Dockerfile -t serv/producer .
cd ..