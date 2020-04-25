package com.example.library.service;

import com.example.library.dao.LibraryDao;
import com.example.library.model.dto.BookDto;
import com.example.library.model.dto.LibraryDto;
import com.example.library.service.impl.LibraryServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;


public class LibraryServiceTest {

    public static final String TEST_ISBN = "test-isbn";
    public static final int TEST_QUANTITY = 10;

    @InjectMocks
    private LibraryServiceImpl libraryService;

    @Mock
    private LibraryDao libraryDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        List<LibraryDto> libraryDtoList = new ArrayList<>();
        LibraryDto libraryDto = getTestLibraryDto();
        libraryDtoList.add(libraryDto);
        when(libraryDao.getLibraryBooks()).thenReturn(libraryDtoList);
    }

    private LibraryDto getTestLibraryDto() {
        LibraryDto libraryDto = new LibraryDto(TEST_ISBN, TEST_QUANTITY);
        return libraryDto;
    }

    @Test
    public void getBooksTest() {
        List<LibraryDto> libraryDtosActual = libraryService.getLibraryBooks();
        Assert.assertEquals(1, libraryDtosActual.size());
        Assert.assertEquals(TEST_ISBN, libraryDtosActual.get(0).getIsbn());
        Assert.assertEquals(TEST_QUANTITY, libraryDtosActual.get(0).getQuantity());
    }

}
