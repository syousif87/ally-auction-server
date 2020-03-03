# Ally Auction Programming Challenge
## Prerequisites
* [JDK 11](https://adoptopenjdk.net/)
* [PostgreSQL](https://www.postgresql.org/)
### IDE
* [Intellij IDEA Community](https://www.jetbrains.com/idea/)
### Technologies
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Gradle](https://gradle.org/)
* [Lombok](https://projectlombok.org/)
* [Hibernate](https://hibernate.org/)
```bash
# setting up database
$ psql postgres
# create superuser "dev"
$ CREATE ROLE dev WITH SUPERUSER;
# create database "ally" with superuser "dev"
$ CREATE DATABASE ally WITH OWNER dev;
```
