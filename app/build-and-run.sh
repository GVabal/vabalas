#!/usr/bin/env bash

mvn clean package && \
docker build -t app:prod . && \
docker-compose -f docker-compose.prod.yaml -p app up -d
