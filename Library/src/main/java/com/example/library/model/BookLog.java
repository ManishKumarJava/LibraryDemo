package com.example.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "BOOK_LOG")
public class BookLog {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column
    private int userId;

    @Column
    private int bookId;

    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate issuedOn;

    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate dueReturnDate;

    @Column
    @Temporal(TemporalType.DATE)
    private Date actualReturnDate;


    public BookLog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public LocalDate getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(LocalDate issuedOn) {
        this.issuedOn = issuedOn;
    }

    public LocalDate getDueReturnDate() {
        return dueReturnDate;
    }

    public void setDueReturnDate(LocalDate dueReturnDate) {
        this.dueReturnDate = dueReturnDate;
    }

    public Date getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(Date actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }
}
