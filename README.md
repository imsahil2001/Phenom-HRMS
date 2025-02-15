# HRMS
A basic employee management system with no hirerachy/departments and desginations.

## Usage
- Employee can add its details
- Edit the employee details
- Delete the employee from the DB
- Get a list of all employees

## Project Pre-Requisite
- Java 17
- Add the boot file TaskApplication.java

## Database 
- H2 Console in memory DB

## Project run 
- project will start on http://localhost:8080 url
- api endpoints start with /api/v1/employees

## Technical Doc
### Endpoints
- http://localhost:8080/api/v1/employees
- http://localhost:8080/api/v1/employees/{employeeID}
- http://localhost:8080/api/v1/employees/add
- http://localhost:8080/api/v1/employees/update
- http://localhost:8080/api/v1/employees/delete/{employeeID}

# Postman Curls to start with project on the go
the sequence of the commands are same as mentioned in section Endpoints

- `curl --location 'http://localhost:8080/api/v1/employees'`


- `curl --location 'http://localhost:8080/api/v1/employees/2'`


- `curl --location 'http://localhost:8080/api/v1/employees/add' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "firstName":"abasda",
  "lastName":"eadsaadas",
  "email":"something@phenom.com"
  }'`


- `curl --location --request PATCH 'http://localhost:8080/api/v1/employees/update' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "employeeID": 6,
  "firstName": "eadsaadas",
  "lastName": "ea",
  "email": "UPDATED@phenom.COM"
  }'`



- `curl --location --request DELETE 'http://localhost:8080/api/v1/employees/delete/1'`


## Database stuff 
- to acccess DB go to http://localhost:8080/h2-console
- Credentials to access H2 
  - username - phenom
  - databaseName - jdbc:h2:mem:hrms
