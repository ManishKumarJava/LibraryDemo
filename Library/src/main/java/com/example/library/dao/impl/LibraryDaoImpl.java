package com.example.library.dao.impl;

import com.example.library.dao.LibraryDao;
import com.example.library.dao.repo.LibraryRepository;
import com.example.library.model.Library;
import com.example.library.model.dto.BookDto;
import com.example.library.model.dto.LibraryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class LibraryDaoImpl implements LibraryDao {


    @Autowired
    private LibraryRepository libraryRepository;

    @Transactional
    public List<LibraryDto> getLibraryBooks(){
        List<Library> libraryList = libraryRepository.findAll();
        List<LibraryDto> libraryDtoList = libraryList.stream().map(l -> new LibraryDto(l.getId(), l.getIsbn(), l.getQuantity())).collect(Collectors.toList());
        return libraryDtoList;
    }

}