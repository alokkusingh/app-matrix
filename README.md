# app-matrix
Some description

Table of Contents
=================

* [Docker Build](#docker-build)
* [Docker Run](#docker-run)
* [Kubernetes Deployments](#kubernetes-deployment)
* [Avaiable APIs](#available-apis)

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

## Kubernetes Deployment
### Create Namespace
```
kubectl apply -f yaml/monitoring-namespace.yaml
```
### Deploy Hello Service
```
kubectl apply -f yaml/hello-service-config.yaml
kubectl apply -f yaml/hello-service-deploy.yaml
kubectl autoscale deployment hello-service --min=2 --max=3 -n monitoring
```
### Deploy Prometheus
```
kubectl apply -f yaml/prometheus-config.yaml
kubectl apply -f yaml/prometheus-roles.yml
```
#### Auto Scale
```
kubectl apply -f yaml/prometheus-deployment.yaml
```
### Deploy Grafana
```
kubectl apply -f yaml/grafana.yaml
```
### Monitoring Commands
```
kubectl get ep hello-service -n monitoring
kubectl describe svc hello-service -n monitoring

kubectl logs pod/hello-service-c668fb66-jtf97 app-matrix -n monitoring
kubectl logs pod/prometheus-c6d5c4d95-2c59b prometheus -n monitoring

kubectl describe pod/grafana-756fb84d84-b8mzm -n monitoring

kubectl get all -n monitoring
```

### Undeploy All
```
kubectl delete namespace monitoring
```
## Available APIs
### Hello Service
GET http://jgte:30080/hello/app/hello/greet
### Prometheus Dashboard   
GET http://jgte:30900/
### Grafana
GET http://jgte:3000/login