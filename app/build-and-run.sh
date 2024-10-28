#!/usr/bin/env bash

echo "▗▄▄▖ ▗▖ ▗▖▗▄▄▄▖▗▖   ▗▄▄▄ "
echo "▐▌ ▐▌▐▌ ▐▌  █  ▐▌   ▐▌  █"
echo "▐▛▀▚▖▐▌ ▐▌  █  ▐▌   ▐▌  █"
echo "▐▙▄▞▘▝▚▄▞▘▗▄█▄▖▐▙▄▄▖▐▙▄▄▀"
echo "                         "
mvn clean package && \
docker build -t app:prod . && \
echo "Done!"
