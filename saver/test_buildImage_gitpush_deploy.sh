#!/bin/sh
set -e

echo '****************************************'
echo 'build docker image'
echo '****************************************'
docker build . -t ambroise123/saverrr:"$(git rev-parse --short HEAD)" -t ambroise123/saverrr:latest

echo '****************************************'
echo 'push image to registry'
echo '****************************************'
docker push ambroise123/saverrr:"$(git rev-parse --short HEAD)"

echo '****************************************'
echo 'push code'
echo '****************************************'
git push

echo '****************************************'
echo 'clean docker'
echo '****************************************'
#docker system prune -f

