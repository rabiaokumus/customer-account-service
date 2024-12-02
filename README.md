# Customer Account Service

## Tech Stack

- Java 19
- MySQL
  
## App Configuration

| VARIABLES                      | Type    | Default | Description                                                                                       |
|--------------------------------|---------|---------|---------------------------------------------------------------------------------------------------|
| PORT                           | Number  | 7504    | The port number on which the application will listen for incoming requests.                       |


## Run

```bash
 mvn clean package
 docker compose up --build 
```

## Tests

```shell
mvn test
```


## API Reference

The API reference documentation is available at http://localhost:7504/swagger-ui/index.html
It provides detailed information about the available endpoints, request and response formats, and sample code snippets.
