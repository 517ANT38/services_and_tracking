#!/bin/sh
cd $(dirname $0)/.. || exit 1
# cd consumer
# DOCKER_BUILDKIT=1 docker build -t serv/consumer .
# cd ..
cd producer
DOCKER_BUILDKIT=1 docker build -f build-elements/Dockerfile -t serv/producer1 .
cd ..