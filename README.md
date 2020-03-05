# Ally Auction Programming Challenge
### Prerequisites
* [JDK 11](https://adoptopenjdk.net/)
* [PostgreSQL](https://www.postgresql.org/)
### IDE
* [Intellij IDEA Community](https://www.jetbrains.com/idea/)
### Technologies
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Gradle](https://gradle.org/)
* [Lombok](https://projectlombok.org/)
* [Hibernate](https://hibernate.org/)
### Front End
* [Ally Auction Angular UI](https://github.com/syousif87/ally-auction-ui)
```bash
# This project requires a local instance of PostgreSQL running, and set up as shown below.
# ally-auction-ui Angular project is used for the front end, link above
```
```bash
# setting up database
$ psql postgres
# create superuser "dev"
$ CREATE ROLE dev WITH SUPERUSER;
# create database "ally" with superuser "dev"
$ CREATE DATABASE ally WITH OWNER dev;
```
```bash
# to run tests, note this will use the local instance of PostgreSQL as integration testing was not fully developed
# with an in memory database
$ ./gradlew test
```
```bash
# to run in command line
$ ./gradlew bootRun
```
```bash
# to run in IntelliJ IDEA
# import gradle project, add lombok plugin and entable annotation processing
```
