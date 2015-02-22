# sirens
sirens is a web application for band-off management.

- Server Side
    - Spring Boot
- Client Side
    - AngularJS 1.3
    - Twitter Bootstrap 3.0
        - [Bootswatch: Superhero](http://bootswatch.com/superhero/)

## Requirement
- Java SE 1.8
- JDK 1.6 or higher (*)

(*) To execute E2E test, JDK 1.6 or higher is required.

## Run
`cd server` and `./gradlew bootRun`

## Access
`http://localhost:8080`

## Run test
`grunt test`  
or  
`grunt karma` (only unit test)  
or  
`grunt protractor:all` (only e2e test)

## License
Apache License, Version 2.0
