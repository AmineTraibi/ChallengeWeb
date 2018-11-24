# ChallengeWeb

this is an application using spring boot

## Built With
This project is based on the Spring Boot project and uses these packages :
* [Spring Data (jpa/Hibernate & MySQL)]
* [Maven]- Dependency Management
* [Spring MVC (Tomcat)]
* [JSP]


### Installing

The project is created with Maven, so you just need to import it to your IDE(Eclipse,..) and build the project to resolve the dependencies

### Database configuration

Create a MySQL database with the name webchallenge (or import webchallenge file sql which contains the shops) add the credentials to /resources/application.properties.
The default ones are :

```
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/webchallenge
spring.datasource.username=root
spring.datasource.password=
```
### Interfaces
![interface to authenticate or register](https://github.com/AmineTraibi/ChallengeWeb/blob/master/index.png)
![interface to register](https://github.com/AmineTraibi/ChallengeWeb/blob/master/register.png)
![interface that introduces the shop](https://github.com/AmineTraibi/ChallengeWeb/blob/master/Interface.png)
![interface that introduces the preferred shop](https://github.com/AmineTraibi/ChallengeWeb/blob/master/mypreferred.png)
