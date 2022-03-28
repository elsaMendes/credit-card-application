
# Springboot Dockerized Credit Card Application 

This is a small Credit Card Application that exposes two endpoits to create and retrieve credit cards.

## Getting Started

### Build and run the project
```docker
mvn clean package
docker build -t springio/creditcard-application .
docker run -p 8080:8080 springio/creditcard-application:latest
```

### Create Credit Card
```curl
curl --location --request POST 'http://localhost:8080/v1.0/api/creditcards/' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "Test 1",
"number": "4847352989263094",
"expireDate": "2023-05-23",
"issueDate": "2023-05-23",
"securityCode": 222,
"limit": 5000,
"balance": 0
}'
```

### Get Credit Cards
```curl
curl --location --request GET 'http://localhost:8080/v1.0/api/creditcards/
```
## Author
* **Elsa Mendes** - https://github.com/elsaMendes