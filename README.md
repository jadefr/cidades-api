# cidades-api

O framework **Spring Boot** foi utilizado para fazer uma API sobre cidades do Brasil.

Os dados — provenientes de um documento CSV — são transformados em objetos da classe _City_ e, então, persistidos num banco de dados MySQL, através do _Spring Data JPA_.

## Tech Stack

* Java 8
* SQL

## Dependências

* Web
* JPA
* Lombok
* MySql
* Hateoas

## Estrutura Base

      
      src
        ├── java
        |    ├── api
        |    |  └── CityResource.java 
        |    |  
        |    ├── model
        |    |  ├── City.java
        |    |  ├── CityNotFoundException.java 
        |    |  └── CityReader.java 
        |    |  
        |    ├── repository
        |    |  └── CityRepository.java
        |    |       
        |    ├── service
        |    |  └── CityService.java 
        |    |
        |    └── CidadesApiApplication.java
        |  
        └── resources 
            ├── application.properties
            └── arquivo.csv
            
## Arquitetura

![Image of architecture](https://raw.githubusercontent.com/jadefr/cidades-api/master/src/main/resources/img/cidades-api.png)           

## Classes

Segue-se uma breve descrição de algumas classes.

### model/City

Representa a entidade que será mapeada à tabela do banco de dados.

Por terem sido utilizadas as anotações @AllArgsConstructor e @NoArgsConstructor não se fez necessária a criação dos getters, setters e construtor.

### repository/CityRepository

É uma interface, anotada com @Repository, que estende a interface JpaRepository<T, ID> (no caso, <City, String>).

Não é necessária a implementação de nenhum método.

### service/CityService

Instancia um objeto privado do CityRepository. 

São feitos os métodos que serão utilizados no controller. Estes métodos manipulam o objeto da classe CityRepository. São utilizadas ***lambda expressions***.

### api/CityResource

Controller.

Implementa os métodos responsáveis pela comunicação HTTP request-response.

## API

| HTTP  | Métodos do Controller | URI | Parâmetros |
| ------------- | ------------- | ------------- | ------------- | 
| GET  | getAllCities  | localhost:8080/api/v2/cidades  | |
| GET  | getCityById  | localhost:8080/api/v2/cidades/{id}  | |
| POST  | addCity  | localhost:8080/api/v2/cidades  | |
| PUT  | updateCity  | localhost:8080/api/v2/cidades/{id}  | |
| DELETE  | deleteCity  | localhost:8080/api/v2/cidades/{id}  | |
| GET  | getCapitals  | localhost:8080/api/v2/cidades?capitais  | |
| GET  | getSortedCapitals  | localhost:8080/api/v2/cidades?capitais&sort | sort=asc ou sort=des |
| GET  | getTotal  | localhost:8080/api/v2/cidades?total |  |


## Conexão com o Banco de Dados
  
  Arquivo _application.properties_:
  
    ## Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
    spring.datasource.url=jdbc:mysql://localhost:3306/cidades_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    spring.datasource.username=
    spring.datasource.password=
    spring.batch.initialize-schema=ALWAYS
    spring.batch.job.enabled=false

    # Dialeto SQL para melhorar o SQL gerado pelo Hibernate
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
    
    # Hibernate ddl auto (create, create-drop, validate, update)
    spring.jpa.hibernate.ddl-auto=update 


Código para gerar o banco, em SQL:

    CREATE DATABASE cidades_db;
