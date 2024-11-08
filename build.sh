#!/usr/bin/env bash

echo "▗▄▄▖ ▗▖ ▗▖▗▄▄▄▖▗▖   ▗▄▄▄ "
echo "▐▌ ▐▌▐▌ ▐▌  █  ▐▌   ▐▌  █"
echo "▐▛▀▚▖▐▌ ▐▌  █  ▐▌   ▐▌  █"
echo "▐▙▄▞▘▝▚▄▞▘▗▄█▄▖▐▙▄▄▖▐▙▄▄▀"
echo "                         "

echo "APP" && \
cd app && \
mvn clean package && \
docker build -t website:prod . && \
cd .. && \

echo "Done!"
