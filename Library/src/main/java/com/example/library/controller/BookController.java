package com.example.library.controller;

import com.example.library.model.dto.BookDto;
import com.example.library.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController {

    private static final Logger LOG = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    // TODO Exception handling/  Validations

    //add a new book
    @RequestMapping(value = "/addBook/{isbn}/{bookName}/{author}")
    public ResponseEntity<BookDto> addBook(@PathVariable("isbn") String isbn, @PathVariable("bookName") String bookName, @PathVariable("author") String author) {
        LOG.info("addBook API called with isbn:{}, bookName:{}, author:{} ", isbn, bookName, author);
        BookDto book = new BookDto();
        book.setIsbn(isbn);
        book.setBookName(bookName);
        book.setAuthor(author);
        BookDto bookResult = bookService.addBook(book);
        return new ResponseEntity<BookDto>(bookResult, HttpStatus.OK);
    }

    //return the book details for given isbn
    @RequestMapping(value = "/getBook/{isbn}")
    public ResponseEntity<BookDto> getBook(@PathVariable("isbn") String isbn) {
        LOG.info("getBook API called with isbn:{} ", isbn);
        BookDto bookResult = bookService.getBook(isbn);
        return new ResponseEntity<BookDto>(bookResult, HttpStatus.OK);
    }

    //Instead of passing a list of values, we can wrap it in a class and share across.
    @RequestMapping(value = "/allBooks", method = RequestMethod.GET)
    public ResponseEntity<List<BookDto>> getAllBooks() {
        LOG.info("allBooks API called ");
        List<BookDto> BookDetails = bookService.getBooks();
        return new ResponseEntity<List<BookDto>>(BookDetails, HttpStatus.OK);
    }

    //update author of the book for the given isbn. Can be extended to update other fields
    @RequestMapping(value = "/updateBook/{isbn}/{author}")
    public ResponseEntity<BookDto> updateBook(@PathVariable("isbn") String isbn, @PathVariable("author") String author) {
        LOG.info("updateBook API called with isbn:{}, author:{} ", isbn, author);
        BookDto book = new BookDto();
        book.setIsbn(isbn);
        book.setAuthor(author);
        BookDto bookResult = bookService.updateBook(book);
        return new ResponseEntity<BookDto>(bookResult, HttpStatus.OK);
    }

 }