package com.example.library.service.impl;

import com.example.library.dao.LibraryDao;
import com.example.library.model.dto.BookDto;
import com.example.library.model.dto.LibraryDto;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryDao libraryDao;

    public List<LibraryDto> getLibraryBooks(){
        return libraryDao.getLibraryBooks();
    }


}
