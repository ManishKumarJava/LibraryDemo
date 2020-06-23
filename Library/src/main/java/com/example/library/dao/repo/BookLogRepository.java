package com.example.library.dao.repo;

import com.example.library.model.Book;
import com.example.library.model.BookLog;
import com.example.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookLogRepository extends JpaRepository<BookLog, Long> {


    List<BookLog> findAll();
//
////    //borrow=save ,
////
//// returns=save
//    @Query("update BookLog bl set bl.dueReturnDate <: today and  bl.actualReturnDate is null ")
//    List<Integer> depositBook(@Param("today") Date today);


    //get the defaulters
    @Query("select bl.userId from BookLog bl where bl.dueReturnDate <: today and  bl.actualReturnDate is null ")
    List<Integer> getAllDefaulterList(@Param("today") Date today);

}