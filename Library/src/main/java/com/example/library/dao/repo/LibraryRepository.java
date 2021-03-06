package com.example.library.dao.repo;

import com.example.library.model.Library;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LibraryRepository extends CrudRepository<Library, Long> {

    List<Library> findAll();

}