[![Java CI with Maven](https://github.com/yliborio/demo-spring-app/actions/workflows/maven.yml/badge.svg)](https://github.com/yliborio/demo-spring-app/actions/workflows/maven.yml)

# Spring API Demo

This repository contains a Spring API (Spring Boot v3) that provides a simple manipulation of a database of products.

## Prerequisites

- Java Development Kit (JDK) 17
- Maven
- Docker

## Build and Run the Application Locally


### Clone this repository:

```bash
  git clone https://github.com/yliborio/demo-spring-app
```


### The Setting up PostgreSQL with Docker:

Navigate to the docker directory:

```bash
  cd docker
```

Build the Docker image for PostgreSQL with the desired tag name (e.g., postgres-spring-api):

```bash
  docker build -t postgres-spring-api .
```

Run the PostgreSQL container:

```bash
  docker run -d -p 5432:5432 --name postgres-spring-api
```

You can replace the credentials with your desired PostgreSQL password in the Dockerfile.

The PostgreSQL database will be accessible at localhost:5432. Now we can connect the database with the Spring API.

### Build and run the Spring API
Navigate to the project directory and build the project using Maven or via IDE:

```bash
  mvn clean install
```
 Run the application:
```bash
  mvn spring-boot:run
```
The API will be accessible at http://localhost:8080.

For API documentation and usage, access the Swagger UI at http://localhost:8080/swagger-ui/index.html.

