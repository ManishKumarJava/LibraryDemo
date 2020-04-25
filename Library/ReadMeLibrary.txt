
-------------------------------------------------------------------------------------------
Items Pending
(1) Exception Handling / Validations
-------------------------------------------------------------------------------------------
Main class to run:
LibraryApplication.Java
-------------------------------------------------------------------------------------------
H2 Database
http://localhost:8088/console/

jdbc:h2:mem:librarydb

INSERT INTO book(isbn, book_Name, author) VALUES ('12345','Java','James Gosling');
INSERT INTO book(isbn, book_Name, author) VALUES ('12346','Spring','Rod Johnson');
INSERT INTO book(isbn, book_Name, author) VALUES ('12347','Test','Test Author');
INSERT INTO book(isbn, book_Name, author) VALUES ('12348','Test2','Test Author2');

INSERT INTO library(isbn, quantity) VALUES ('12345', 5);
INSERT INTO library(isbn, quantity) VALUES ('12346', 21);
INSERT INTO library(isbn, quantity) VALUES ('12347', 100);

select * from book;
select * from library;

-------------------------------------------------------------------------------------------
Get all library books (can renamed to getAllBooks)
http://localhost:8088/library/allBooks

update Author for ISBN
@RequestMapping(value = "/updateBook/{isbn}/{author}")
http://localhost:8088/library/updateBook/12345/Manish

Adding a new book
@RequestMapping(value = "/addBook/{isbn}/{bookName}/{author}")
http://localhost:8088/library/addBook/23456/MyBook/MyAuthor

Retrieving a specific book using isbn
@RequestMapping(value = "/getBook/{isbn}")
http://localhost:8088/library/getBook/12345

Retrieving all library books
@RequestMapping(value = "/libBooks", method = RequestMethod.GET)
http://localhost:8088/library/libBooks
-------------------------------------------------------------------------------------------
