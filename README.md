# spring-webflux-tcp-example

## Request Example
```
curl --location 'http://localhost:8082/api/transaction' \
--header 'Content-Type: application/json' \
--data '{
    "message": "Something from Nothing"
}'
```

## Test TCP Connection on MacOS
Format
```
nc -zv <<IP>> <<Port>>
```
Example
```
nc -zv 127.0.0.1 10001
```