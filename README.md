# Introduction.
 This is Book Store application which perform below operation.<br />
 It Stores the Book Details in DB.<br />
 It fetch Book data from DB based on the bookId.<br />
 It can update Book details if user want to change detail.<br />
 It Delete the Book details from DB.<br />
 Also It will perform checkout operation where user can buy one and more than one Book.<br />


# Internal Structure of Book Store Application.
**Controller Layer (BookStoreController)**: It Exposes five endpoint so that user can perform CRUD operation as well as checkout operation.<br />
**Service Layer(BookStoreServiceImpl,BookChekoutImpl)**: This layer perform business operation.<br />
**Cache-Service Layer (BookCacheService)**: whenever user search book based on the book id ,first time it fetch data from DB and Second time it fetch data from Cache thus improve the performance of application.<br />
**Mapper(BookMapper)**: Mapper is used to separate DAO Layer with service layer. At Both layer we are converting DTO to Entity and Vice versa. Mapper is use to make application     loosely coupled.<br />
**Domain Class(BookDO)**:  We are performing Business related validation in domain object.<br />
**Entity Class(BookEntity)**:  We are performing DB operation through this class.<br />
**DAO Layer(BookDaoImpl)**: With the help of Entity class we are performing DB Operation in this layer.<br />
**Unit Testing** : We have implement Junit test cases for book store application.<br />

# Getting Started
Checkout code from below location<br />
<h1>Git Command</h1>
git clone <br />
https://github.com/sheeraz21/BookStore.git

<h1>Maven Command</h1>
cd BookStore<br />
Run Below Command<br />
mvn install<br />
mvn clean<br />

<h1>Docker Command </h1>
./mvnw package && java -jar target/book-store-0.0.1-SNAPSHOT.jar<br />
docker build -t springio/book-store<br />
./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=springio/book-store<br />

<h1>Technology And Tools</h1> 
1.Java<br />
2.Spring Boot<br />
3.Spring Web<br />
4.Spring Data<br />
5.Spring Security<br />
6.Spring Actuator<br />
7.Spring DevTools<br />
8.Spring Validation<br />
9.MySql Database<br />
10.EhCache<br />
11.Swagger Open API Specification<br />
12.Postman<br />
13.Git and GitHub<br />
14.Docker <br />
15.Junit and Mockito<br />


<h1> Swagger URL</h1>
http://localhost:8080/swagger-ui.html#/

http://localhost:8080/swagger-ui.html#/bookstore/getBookByIdUsingGET

http://localhost:8080/v2/api-docs



<h1>DB Script Location</h1>
https://github.com/sheeraz21/BookStore/tree/main/book-store/src/main/resources/static/DB/book.sql


<h1>Rest Doc Location</h1>
https://github.com/sheeraz21/BookStore/tree/main/book-store/src/main/resources/static/RestDoc/Book Store App.postman_collection.json







 
 
