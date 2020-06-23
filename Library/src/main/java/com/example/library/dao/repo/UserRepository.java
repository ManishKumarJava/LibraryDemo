package com.example.library.dao.repo;

import com.example.library.model.Book;
import com.example.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUserId(String isbn);

    List<User> findAll();

}