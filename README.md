[English](README.md) | [Português](README.pt-br.md)

# Transaction Management Service

This microservice, built with Spring Boot, is responsible for managing transactions in a bookstore. To retrieve information about books, users, and addresses, it communicates with two other microservices, [Book Management Service](https://github.com/georgrybski/book-management-service) and [User Management Service](https://github.com/georgrybski/user-management-service), through REST API calls.

However, to increase efficiency, the microservices will be updated in the future to use RabbitMQ for communication instead of REST API calls. Additionally, this microservice will also be updated to store necessary information from user, address, and book entities in its own database, instead of actively fetching this data from other microservices with every request. This will improve response times and reduce the load on the other microservices.

It is important to note that these changes are not yet implemented, but are planned for the future. Once implemented, RabbitMQ will be used to keep this information updated across all microservices.

## Installation

To use this service, you will need to have Java 17+ and you'll also need to have PostgreSQL installed. 

You will also need to run the [Book Management Service](https://github.com/georgrybski/book-management-service) and [User Management Service](https://github.com/georgrybski/user-management-service).

Once you have PostgreSQL, the [Book Management Service](https://github.com/georgrybski/book-management-service), and the [User Management Service](https://github.com/georgrybski/user-management-service) running, and `application.properties` configured, you can start the Image Management Service by running the following command:

```./mvnw spring-boot:run```

## Configuration

The service is configured using the `application.properties` file, located in the root folder of the project. You can change the database URL, username, and password by modifying the `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` properties, respectively.

You will also need to set up the appropriate URLs for the [User Management Service](https://github.com/georgrybski/user-management-service) and [Book Management Service](https://github.com/georgrybski/book-management-service). These URLs are set using the `book-service.url` and `user-service.url` properties, respectively.

Assuming that the [Book Management Service](https://github.com/georgrybski/book-management-service) is running on `http://localhost:8080` and the [User Management Service](https://github.com/georgrybski/user-management-service) is running on `http://localhost:9090`, you can set the URLs in the `application.properties` file as follows:

```
book-service.url=http://localhost:8080
user-service.url=http://localhost:9090
```

## Usage

The Transaction Management Service currently provides the following endpoints:

## GET /api/transactions/{id}

Retrieves the transaction with the specified `id`. The response will be in JSON format.

## GET /api/transactions

Retrieves all transactions. The response will be in JSON format.

## POST /api/transactions

Creates a new transaction. The request body should contain the necessary information for the transaction, including user ID, address ID, and book ID(s). The response will have an HTTP status of 201 CREATED.

## GET /api/transactions/example

Retrieves an example transaction creation request body. The response will be in JSON format.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
