package com.example.libproj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libproj.model.Book;
import com.example.libproj.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book addBook(Book book) {
        validateBookData(book);
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        validateBookData(book);
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    private void validateBookData(Book book) {
        try {
            int publishedYear = Integer.parseInt(book.getPublishedYear());
            if (publishedYear < 1500 || publishedYear > 2100) {
                throw new IllegalArgumentException("Published year should be between 1500 and 2100");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Published year must be a valid integer");
        }
    }

}