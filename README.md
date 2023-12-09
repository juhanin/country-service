# Country Service

A small web service that offers a list of countries and detailed information about them.

## Getting Started

### Prerequisites / Built With

A note about development; this project was created with the use of IntelliJ IDEA Ultimate. Here are some of the important tools
that IDEA itself used:

- Java 17
- Spring Boot 3.2.0

If you want to install and run the minimal React client, here are tools and versions used in development:

- node v20.3.0
- npm 9.6.7

## Usage

Make sure that you meet the prerequisites listed above, especially concerning Java version 17. Using maven wrapper, running
on Unix should be as simple as:

`./mvnw clean install`

and

`./mvnw spring-boot:run`

For Windows, you need to use mvnw.cmd instead, for example:

`mvnw.cmd clean install`

For development though (and personally for myself), the easier way to run the application is straight from IDEA itself.

Once the service is running, you can probe it with curl/postman/browser at

`http://localhost:8080/countries` and `http://localhost:8080/countries/{name}` where name is a name of a country, for example
`http://localhost:8080/countries/finland`

Alternatively, you can install and run the minimal React client to probe the Spring Boot service:

`cd client`

`npm install`

`npm run dev`

Make sure that you meet the versions required listed above for Node and NPM. Once your client (and backend service) is running,
navigate to `http://localhost:1234` in your browser. You should get a minimal list of all the countries.

## Roadmap

- Add a root element "countries" to the list of countries fetched from /countries
- Add tests for Controller/Service, even if there's very little business logic here
- Clean up countries further when fetching them all, only name and country code needed (only single country needs further information)