#!/usr/bin/env bash

# --rm == remove container after run
# -i == interactive container
# -t == better output
# -v $(pwd):$(pwd) == mount a volume and make it possible to acces files in current directory
# -w $(pwd) == making the current directory the containers working directory
# -u $(id -u) == using the current user to execute commands with same permissions
# batch == multiple config files
# --clean == delete previous output
# --fail-fast == stop if it encounters trouble
# --verbose == more detailed output
# config/* == location of the config files
docker run --rm -i -t -v $(pwd):$(pwd) -w $(pwd) -u $(id -u) openapitools/openapi-generator-cli:v7.5.0 batch --clean --fail-fast --verbose config/*

(cd implementation-typescript && npm i)
(cd implementation-typescript && npm i -D jest ts-jest @types/jest)

