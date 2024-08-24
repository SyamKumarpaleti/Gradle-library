package com.example.libproj;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.example.libproj.model.Book;
import com.example.libproj.repository.BookRepository;
import com.example.libproj.service.BookService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    private Book book;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setIsbn("123-4567890123");
        book.setPublishedYear("2022");
    }

    @Test
    public void testAddBook() {
        when(bookRepository.save(book)).thenReturn(book);
        Book createdBook = bookService.addBook(book);
        assertEquals(book.getTitle(), createdBook.getTitle());
    }

    @Test
    public void testValidateBookData_invalidPublishedYear() {
        book.setPublishedYear("1400");
        assertThrows(IllegalArgumentException.class, () -> {
            bookService.addBook(book);
        });
    }

}





//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import com.example.libproj.model.Book;
//import com.example.libproj.repository.BookRepository;
//import com.example.libproj.service.BookService;
//
//class BookServiceTest {
//
//    @Mock
//    private BookRepository bookRepository;
//
//    @InjectMocks
//    private BookService bookService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testGetAllBooks() {
//        // Arrange
//        Book book1 = new Book();
//        Book book2 = new Book();
//        List<Book> books = Arrays.asList(book1, book2);
//        when(bookRepository.findAll()).thenReturn(books);
//
//        // Act
//        List<Book> result = bookService.getAllBooks();
//
//        // Assert
//        assertThat(result).hasSize(2).contains(book1, book2);
//    }
//
//    @Test
//    void testGetBookById() {
//        // Arrange
//        Book book = new Book();
//        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
//
//        // Act
//        Optional<Book> result = bookService.getBookById(1L);
//
//        // Assert
//        assertThat(result).isPresent().contains(book);
//    }
//
//    @Test
//    void testAddBook() {
//        // Arrange
//        Book book = new Book();
//        when(bookRepository.save(book)).thenReturn(book);
//
//        // Act
//        Book result = bookService.addBook(book);
//
//        // Assert
//        assertThat(result).isEqualTo(book);
//    }
//
//    @Test
//    void testDeleteBook() {
//        // Act
//        bookService.deleteBook(1L);
//
//        // Assert
//        verify(bookRepository).deleteById(1L);
//    }
//}
//
