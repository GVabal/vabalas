#!/usr/bin/env bash

echo "▗▄▄▖ ▗▖ ▗▖▗▄▄▄▖▗▖   ▗▄▄▄ "
echo "▐▌ ▐▌▐▌ ▐▌  █  ▐▌   ▐▌  █"
echo "▐▛▀▚▖▐▌ ▐▌  █  ▐▌   ▐▌  █"
echo "▐▙▄▞▘▝▚▄▞▘▗▄█▄▖▐▙▄▄▖▐▙▄▄▀"
echo "                         "

echo "mvn clean package"
mvn clean package && \

echo "docker build -t website:prod ."
docker build -t website:prod . && \

echo "Done!"
