# Bank Spring Boot Project

Project containing the basics of a Spring Boot API. 


## Swagger

The API contract is declared in the bank-api.yml OpenAPI specification file. 

Swagger will generate a boilerplate interface for us for the API Controller class which we can then implement and override its methods. 

The API endpoints can be accessed via the Swagger UI when the app is running locally:

http://localhost:8080/swagger-ui/index.html


## Database

The project will run with a local H2 Database. 

H2 DB dependency is present in the pom.xml. 

The tables in the H2 DB are created automatically by Spring Boot based on the @Entity classes. 

The data.sql file will populate these tables with some sample data. 


## Entities

The app contains two types of objects:
* Bank Account
* Customer

Bank Account has a foreign key dependency on Customer.  


## Endpoints

* GET /customers - return a list of all customers
* POST /customers - create a new customer
* GET /customers/{customer-id} - return a specific customer
* GET /bankaccounts - return a list of all bank accounts
* POST /bankaccounts - create a new bank account
* GET /bankaccounts/{bankAccountNumber} - return a specific bank account

