package com.example.library.service;

import com.example.library.model.dto.BookDto;
import com.example.library.model.dto.LibraryDto;

import java.util.List;

public interface LibraryService {

    List<LibraryDto> getLibraryBooks();

    // We can provide more services here like:
    // (1) update book/ quantity
    // (2) add a new book in Library
    // (3) get details of a particular book
}


