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
        ├ java
        |  ├── api
        |  |  └── CityResource.java 
        |  |  
        |  ├── model
        |  |  ├── City.java
        |  |  ├── CityNotFoundException.java 
        |  |  └── CityReader.java 
        |  |  
        |  ├── repository
        |  |  └── CityRepository.java
        |  |       
        |  ├── service
        |  |  └── CityService.java 
        |  |
        |  └── CidadesApiApplication.java
        |  
        └── resources 
            ├── application.properties
            └── arquivo.csv
            
## Arquitetura

![Image of screenshot](https://raw.githubusercontent.com/jadefr/cidades-api/master/src/main/resources/img/cidades-api.png)           

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


Código para gerar a tabela, em SQL:

    CREATE DATABASE cidades_db;
    
    USE cidades_db;
    
    CREATE city
    (
        ibge_id           varchar(7)   NOT NULL,
        uf                varchar(100) NULL,
        name              varchar(100) NULL,
        capital           varchar(100) NULL,
        lon               varchar(100) NULL,
        lat               varchar(100) NULL,
        no_accents        varchar(100) NULL,
        alternative_names varchar(100) NULL,
        microregion       varchar(100) NULL,
        mesoregion        varchar(100) NULL,
        PRIMARY KEY (ibge_id)
    ) ENGINE = InnoDB
      DEFAULT CHARSET = utf8;

