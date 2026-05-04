# Biblioteca API CP2

API REST para gerenciamento de livros e autores, desenvolvida com Java, Spring Boot, Spring Data JPA, MySQL e Swagger/OpenAPI.

## Requisitos

- Java 17
- Docker
- Maven Wrapper ja incluido no projeto:
  - Windows: `mvnw.cmd`
  - Linux/macOS: `./mvnw`

## Como subir o banco de dados com Docker

A aplicacao esta configurada para acessar o MySQL em `localhost:3306`, usando o banco `biblioteca`, usuario `root` e senha `root_pwd`.

Execute o comando abaixo na raiz do projeto:

```bash
docker run -d \
    --name mysql \
    --rm \
    -e MYSQL_ROOT_PASSWORD=root_pwd \
    -e MYSQL_USER=new_user \
    -e MYSQL_PASSWORD=my_pwd \
    -p 3306:3306 \
    mysql
```

Para verificar se o container esta em execucao:

```bash
docker ps
```

## Como rodar a aplicacao

Com o banco de dados em execucao, rode a API pela raiz do projeto.

No Windows:

```bash
mvn spring-boot:run
```

No Linux/macOS:

```bash
./mvnw spring-boot:run
```

A API ficara disponivel em:

```text
http://localhost:8080
```

## Swagger/OpenAPI

O Swagger esta configurado na raiz da aplicacao:

```text
http://localhost:8080/
```

Use essa pagina para visualizar e testar as rotas da API.

## Rotas principais

Versao da API configurada: `v1`.

### Livros

- `POST /api/v1/livros`
- `GET /api/v1/livros`
- `GET /api/v1/livros/{id}`
- `PUT /api/v1/livros/{id}`
- `DELETE /api/v1/livros/{id}`

Exemplo de JSON para criar ou atualizar um livro:

```json
{
  "id": 1,
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "anoPublicacao": 2008,
  "editora": "Prentice Hall"
}
```

### Autores

- `POST /api/v1/autores`
- `GET /api/v1/autores`
- `GET /api/v1/autores/{id}`
- `PUT /api/v1/autores/{id}`
- `DELETE /api/v1/autores/{id}`

Exemplo de JSON para criar ou atualizar um autor:

```json
{
  "id": 1,
  "nome": "Robert C. Martin",
  "nacionalidade": "Estados Unidos",
  "email": "robert.martin@example.com",
  "biografia": "Autor de livros sobre desenvolvimento de software."
}
```

## Configuracao do banco

As configuracoes atuais estao em `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root_pwd
spring.jpa.hibernate.ddl-auto=update
```

O Hibernate esta configurado com `ddl-auto=update`, entao as tabelas sao criadas ou atualizadas automaticamente ao iniciar a aplicacao.
