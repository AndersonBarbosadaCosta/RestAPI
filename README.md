# REST API Spring Boot

Web service de produtos utilizando Spring Boot e Swagger para documentação do mesmo.

Bibliotecas e tecnologias utilizadas:
- Java 8
- Spring Boot
- Swagger 2
- MySql
- Maven


![APIREST](https://i.imgur.com/BC8DZ4s.png"APIREST")

### Instalação

requisitos

- Java 8
- Maven
- MySql 

### Passo a Passo

-  clone o repositório https://github.com/AndersonBarbosadaCosta/RestAPI.git

- importe o projeto em sua IDE preferida

-  instale as dependências do projeto contidas no arquivo pom.xml contida na pasta raíz do projeto.  

- Crie um schema no MySql com o nome de restapidb

- Execute a  classe RestApiApplication.java e o Spring inicia o servidor Tom Cat  na porta 80.

A url http://localhost:8080/v2/api-docs contém a documentação da api

Podemos conferir por exemplo o recurso GET de products  no endpoint: http://localhost:8080/products


