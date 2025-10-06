

# Tenpo Challenge

Challenge Backend for Java Developer


## Tech Stack

<div>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="40" alt="java logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="40" alt="spring logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/redis/redis-original.svg" height="40" alt="redis logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" height="40" alt="postgresql logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/apachekafka/apachekafka-original.svg" height="40" alt="apachekafka logo"  />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/docker/docker-original.svg" height="40" alt="docker logo"  />

</div>

## Components

![App Components](https://raw.githubusercontent.com/observadorxpl/tenpochallenge/refs/heads/master/tenpoapi.png)


## Docker Hub

**Repository:** https://hub.docker.com/r/joseluiscayo97/tenpoapi


## Deployment
Download [docker-compose.yaml](https://github.com/observadorxpl/tenpochallenge/blob/master/docker-compose.yaml) and execute the next command.


```bash
  docker-compose up -d
```
- Docker Desktop / Docker Engine is required

## Test API

To calculate amount execute this endpoint

```bash
  curl --location 'localhost:8080/amounts?num1=3&num2=4' 
```

To get history transactions execute:
```bash
  curl --location 'localhost:8080/transactions' 
```
Or import postman collection: [tenpoapi.postman_collection.json](https://github.com/observadorxpl/tenpochallenge/blob/master/tenpoapi.postman_collection.json)
