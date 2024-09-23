# SpringBoot, MongoDB, and ElasticSearch
## The purpose of this project is to learn more about MongoDB and ElasticSearch.

### Steps for running this application
#### 1. Setup the environment using docker
```
docker-compose up -d
```

#### 2. Open `Mongo Express` and create a `demo` _database_
```py
http://localhost:8081
```

#### 3. Run the Maven Spring Boot application
```
mvn clean install
mvn spring-boot:run
```

#### 4. Make a `POST` request to add a _document_ to the `person` _collections_ in MongoDB and ElasticSearch
```py
POST http://localhost:8080/api/v1/persons
```
```json
{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@gmail.com"
}

```

#### 5. Make a `GET` request to retrieve the _document(s)_ in the `person` _collection_ in MongoDB
```py
GET http://localhost:8080/api/v1/persons
```

#### 6. Open `Mongo Express` to view the `person` _collection_ in MongoDB
```py
http://localhost:8081/db/demo/person
```

#### 7. Open `Kibana` to view the `person` _collection_ in ElasticSearch
```py
http://localhost:5601
```
