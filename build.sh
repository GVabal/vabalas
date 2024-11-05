#!/usr/bin/env bash

echo "▗▄▄▖ ▗▖ ▗▖▗▄▄▄▖▗▖   ▗▄▄▄ "
echo "▐▌ ▐▌▐▌ ▐▌  █  ▐▌   ▐▌  █"
echo "▐▛▀▚▖▐▌ ▐▌  █  ▐▌   ▐▌  █"
echo "▐▙▄▞▘▝▚▄▞▘▗▄█▄▖▐▙▄▄▖▐▙▄▄▀"
echo "                         "

echo "APP"
cd app
mvn clean package && \
docker build -t app:prod . && \
cd ..

echo "WEB"
cd web
# todo
cd ..

echo "Done!"
