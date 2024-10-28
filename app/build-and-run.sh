#!/usr/bin/env bash

echo '  _           _ _     _                   _                    '
echo ' | |         (_) |   | |                 | |                   '
echo ' | |__  _   _ _| | __| |   __ _ _ __   __| |  _ __ _   _ _ __  '
echo ' | '_ \| | | | | |/ _` |  / _` | '_ \ / _` | | '__| | | | '_ \ '
echo ' | |_) | |_| | | | (_| | | (_| | | | | (_| | | |  | |_| | | | |'
echo ' |_.__/ \__,_|_|_|\__,_|  \__,_|_| |_|\__,_| |_|   \__,_|_| |_|'
echo '                                                               '
mvn clean package && \
docker build -t app:prod . && \
docker-compose up -d
