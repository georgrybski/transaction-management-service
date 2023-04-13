[English](README.md) | [Português](README.pt-br.md)

# Serviço de Gerenciamento de Transações

Este microserviço, construído com Spring Boot, é responsável por gerenciar transações em uma livraria. Para recuperar informações sobre livros, usuários e endereços, ele se comunica com outros dois microserviços, Book Management Service e [User Management Service](https://github.com/georgrybski/user-management-service), por meio de chamadas de API REST.

No entanto, para aumentar a eficiência, os microserviços serão atualizados no futuro para usar o RabbitMQ para comunicação em vez de chamadas de API REST. Além disso, este microserviço também será atualizado para armazenar as informações necessárias das entidades de usuário, endereço e livro em seu próprio banco de dados, em vez de buscar ativamente esses dados em outros microserviços a cada solicitação. Isso melhorará os tempos de resposta e reduzirá a carga nos outros microserviços.

É importante observar que essas mudanças ainda não foram implementadas, mas estão planejadas para o futuro. Uma vez implementado, o RabbitMQ será usado para manter essas informações atualizadas em todos os microserviços.

## Instalação

Para usar este serviço, você precisará ter o Java 17+ e também precisará ter o PostgreSQL instalado.

Você também precisará executar o Book Management Service e o [User Management Service](https://github.com/georgrybski/user-management-service).

Depois de ter o PostgreSQL, o Book Management Service e o [User Management Service](https://github.com/georgrybski/user-management-service) em execução e o `application.properties` configurado, você pode iniciar o Image Management Service executando o seguinte comando:

```./mvnw spring-boot:run```

## Configuração

O serviço é configurado usando o arquivo `application.properties`, localizado na pasta raiz do projeto. Você pode alterar a URL do banco de dados, o nome de usuário e a senha modificando as propriedades `spring.datasource.url`, `spring.datasource.username` e `spring.datasource.password`, respectivamente.

Você também precisará configurar as URLs apropriadas para o [User Management Service](https://github.com/georgrybski/user-management-service) e o Book Management Service. Essas URLs são definidas usando as propriedades `book-service.url` e `user-service.url`, respectivamente.

Supondo que o Book Management Service esteja em execução em `http://localhost:8080` e o [User Management Service](https://github.com/georgrybski/user-management-service) esteja em execução em `http://localhost:9090`, você pode definir as URLs no arquivo `application.properties` da seguinte forma:

```
book-service.url=http://localhost:8080
user-service.url=http://localhost:9090
```

## Uso

O Transaction Management Service atualmente fornece os seguintes endpoints:

## GET /api/transactions/{id}

Recupera a transação com o `id` especificado. A resposta será em formato JSON.

## GET /api/transactions

Recupera todas as transações. A resposta será em formato JSON.

## POST /api/transactions

Cria uma nova transação. O corpo da solicitação deve conter as informações necessárias para a transação, incluindo ID do usuário, ID do endereço e ID(s) do livro. A resposta terá um status HTTP de 201 CREATED.

## GET /api/transactions/example

Recupera um exemplo de corpo de solicitação de criação de transação. A resposta será em formato JSON.

## Contribuindo

Contribuições  são bem-vindas. Para grandes mudanças, abra primeiro um problema para discutir o que você gostaria de mudar.

## Licença

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo [LICENSE](LICENSE) para obter detalhes.
