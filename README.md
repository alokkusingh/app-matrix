# app-matrix
Some description

Table of Contents
=================

* [Docker Build](#docker-build)
* [Docker Run](#docker-run)

Created by [Alok Singh](https://github.com/alokkusingh)

## Docker Build
Build Docker Image
### For ARM64 V8 Processor
```
cd app-matrix
docker build -t alokkusingh/app-matrix:arm64v8 --build-arg JAR_FILE=target/app-matrix-0.0.1-SNAPSHOT.jar --build-arg ARCH=arm64v8/ .
docker push alokkusingh/app-matrix:arm64v8
```
### For AMD64 Processor
```
cd app-matrix
docker build -t alokkusingh/app-matrix:amd64 --build-arg JAR_FILE=target/app-matrix-0.0.1-SNAPSHOT.jar --build-arg ARCH=amd64/ .
docker push alokkusingh/app-matrix:amd64
```

## Docker Run
Run the application by executing following command
### For ARM64 V8 Processor based environment
```
docker run --rm --name app-matrix -p 8080:8080 alokkusingh/app-matrix:arm64v8
```
### For AMD64 Processor based environment
```
docker run --rm --name app-matrix -p 8080:8080 alokkusingh/app-matrix:amd64
```
