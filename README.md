# WebFlux Functional
 
## Build
 
Para efetuar o build da aplicação, execute o comando abaixo, no terminal.  

```
$ mvn clean install  
```
## DDL

```
CREATE KEYSPACE example WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'} AND durable_writes = true;

-- User table
               
CREATE TABLE example.user (
    name text,
    cpf text,
    domain text,
    PRIMARY KEY (cpf)
);