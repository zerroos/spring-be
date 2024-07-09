# Backend Routes

## Install

1) cd into the main directory of the project

2) In one terminal run:

```bash
docker compose up
```
3) In another terminal run:
```bash
./mvnw clean install

./mvnw spring-boot:run
```

## Issues

* Try deleting the docker instance if one exists
* Ensure Java is on version 22
* Make sure no port needed by the docker containers are in use by other processes!