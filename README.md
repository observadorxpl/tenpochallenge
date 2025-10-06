

# Tenpo Challenge

Challenge Backend for Java Developer


## Tech Stack

**Spring / Spring Boot:** Web, Redis, JPA, Swagger, Kafka

**Docker:** Docker Hub, Docker Compose

## Components

![App Components](https://raw.githubusercontent.com/observadorxpl/tenpochallenge/refs/heads/master/tenpoapi.png)


## Docker Hub

**Repository:** https://hub.docker.com/r/joseluiscayo97/tenpoapi


## Deployment

To deploy this project run

```bash
  docker-compose up -d
```

## Test API

To calculate amount execute this endpoint

```bash
  curl --location 'localhost:8080/amounts?num1=3&num2=4' 
```

To get history transactions execute:
```bash
  curl --location 'localhost:8080/transactions' 
```
Or import postman collection: tenpoapi.postman_collection.json
