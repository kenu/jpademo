# JPA relation demo

## MariaDB Account
* `src/main/resources/application.properties`

```sql
create database devdb default character set utf8mb4 collate utf8mb4_unicode_ci;
GRANT ALL PRIVILEGES ON devdb.* TO devuser@localhost IDENTIFIED BY 'devpass';
```

## build
```sh
git clone https://github.com/kenu/jpademo
cd jpademo
./mvnw spring-boot:run
```
