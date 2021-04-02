1.Introduction:
This is a Book Store application that performs the below operation.
1.1 It Stores the Book Details in DB.
1.2 It fetches Book data from DB based on the bookId.
1.3 It can update Book details if user wants to change detail.
1.4 It Deletes the Book details from DB.
1.5 Also It will perform a checkout operation where user can buy one and more than one Book.


2.  Internal Structure of Book Store Application.
2.1 Controller Layer (BookStoreController): It Exposes five endpoint so that user can perform CRUD operation as well as checkout operation.

2.2 Service Layer(BookStoreServiceImpl,BookChekoutImpl): This layer perform business operation.
2.2.1 Cache-Service Layer (BookCacheService): whenever the user search the book based on the book id, the first time it fetch data from DB and the Second time it fetch data from Cache thus improve the performance of the application.

2.3 Mapper(BookMapper): Mapper is used to separating DAO Layer from the service layer. At Both layers, we are converting DTO to Entity and Vice versa. Mapper is used to making application loosely coupled.

2.4 Domain Class(BookDO):  We are performing Business related validation in the domain object.

2.5 Entity Class(BookEntity):  We are performing DB operation through this class.

2.6 DAO Layer(BookDaoImpl): With the help of Entity class we are performing DB Operation in this layer.

2.7 Unit Testing: We have  implement Junit test cases for book store application.
