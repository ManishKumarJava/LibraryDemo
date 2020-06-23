package com.example.library.dao.impl;

import com.example.library.dao.BookDao;
import com.example.library.dao.repo.BookLogRepository;
import com.example.library.dao.repo.BookRepository;
import com.example.library.model.Book;
import com.example.library.model.BookLog;
import com.example.library.model.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * Not doing exception handling
 *
 */
@Repository
public class BookLogDaoImpl implements BookDao {


    @Autowired
    private BookRepository bookRepository;


    @Autowired
    private BookLogRepository bookLogRepository;




    @Transactional
    public void borrowBook(int bookId, int userId){
        BookLog bookLog = new BookLog();
        bookLog.setBookId(bookId);
        bookLog.setUserId(userId);
        LocalDate dueReturnDate = LocalDate.now().plusDays(7);
        bookLog.setDueReturnDate(dueReturnDate);
        bookLog.setIssuedOn(LocalDate.now());

        Optional<Book> book =  bookRepository.findById(new Long(bookId));

    }

    @Transactional
    public List<BookDto> getBooks() {
        List<Book> bookList = bookRepository.findAll();
        List<BookDto> bookDtoList = bookList.stream().map(b ->  getBookDto(b)).collect(Collectors.toList());
        return bookDtoList;
    }

    @Transactional
    public BookDto getBook(String isbn) {
        Book book = getBookEntity(isbn);
        return getBookDto(book);
    }

    public Book getBookEntity(String isbn){
        List<Book> bookList = bookRepository.findByIsbn(isbn);
        //Assuming all calls are genuine and it will return some thing.
        //TODO Exception Handling
        return bookList.get(0);
    }

    //returning dto to client (instead of entity)
    private BookDto getBookDto(Book book){
        return new BookDto(book.getId(), book.getIsbn(),book.getBookName(), book.getAuthor());
    }

    @Override
    @Transactional
    public BookDto updateBook(BookDto book) {
        Book bookEntity = getBookEntity(book.getIsbn());
        bookEntity.setAuthor(book.getAuthor());
        //only updating Author, we can update the whole book object.
        Book bookEntityResult = bookRepository.save(bookEntity);
        return getBookDto(bookEntityResult);
    }

    @Override
    @Transactional
    public BookDto addBook(BookDto bookDto) {
        Book book = new Book(bookDto.getIsbn(), bookDto.getBookName(), bookDto.getAuthor());
        Book bookEntityResult = bookRepository.save(book);
        return getBookDto(bookEntityResult);
    }

    @Override
    @Transactional
    public boolean deleteBook(String isbn) {
        Book bookEntity = getBookEntity(isbn);
        bookRepository.delete(bookEntity);
        return true;
    }

}