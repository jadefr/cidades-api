# cidades-api

O framework **Spring Boot** foi utilizado para fazer uma API sobre cidades do Brasil.

Os dados — provenientes de um documento CSV — são transformados em objetos da classe _City_ e, então, persistidos num banco de dados MySQL, através do _Spring Data JPA_.

# Tech Stack

* Java 8
* SQL

# Dependências

* Web
* JPA
* Lombok
* MySql
* Hateoas

# Estrutura Base

      
      src
        ├ java
        |  ├── api
        |  |  └── CityResource.java 
        |  |  
        |  ├── model
        |  |  ├── City.java
        |  |  └── CityNotFoundException.java 
        |  |  
        |  ├── repository
        |  |  ├── CityRepository.java
        |  |  └── CsvReader.java 
        |  |       
        |  ├── service
        |  |  └── CityService.java 
        |  |
        |  └── CidadesApiApplication.java
        |  
        └── resources 
            ├── application.properties
            └── arquivo.csv
            
           

# API

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

