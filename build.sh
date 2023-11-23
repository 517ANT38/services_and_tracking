#!/bin/sh
cd $(dirname $0) || exit 1
cd consumer
DOCKER_BUILDKIT=1 docker build -f build-docker/Dockerfile -t serv/consumer .
cd ..
cd producer
DOCKER_BUILDKIT=1 docker build -f build-docker/Dockerfile -t serv/producer .
cd ..