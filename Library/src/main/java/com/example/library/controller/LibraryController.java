package com.example.library.controller;

import com.example.library.model.dto.LibraryDto;
import com.example.library.service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private static final Logger LOG = LoggerFactory.getLogger(LibraryController.class);

    // We can provide more services here like:
    // (1) update book/ quantity
    // (2) add a new book in Library
    // (3) get details of a particular book

    @Autowired
    private LibraryService libraryService;

    @RequestMapping(value = "/libBooks", method = RequestMethod.GET)
    public ResponseEntity<List<LibraryDto>> getLibraryBooks() {
        LOG.info("libBooks API called");
        List<LibraryDto> libraryDtos = libraryService.getLibraryBooks();
        return new ResponseEntity<List<LibraryDto>>(libraryDtos, HttpStatus.OK);
    }

}