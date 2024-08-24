package com.example.libproj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Validation: Alphabets and numerics only, no special characters
    @NotBlank(message = "Title is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Title can only contain alphabets and numerics")
    @Size(max = 100, message = "Title should not be more than 100 characters")
    private String title;

    // Validation: Alphabets and numerics only, no special characters
    @NotBlank(message = "Author is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Author name can only contain alphabets and numerics")
    @Size(max = 50, message = "Author name should not be more than 50 characters")
    private String author;

    // Validation: Digits, spaces, and hyphens only
    @NotBlank(message = "ISBN is mandatory")
    @Pattern(regexp = "^[0-9\\- ]+$", message = "ISBN can only contain digits, spaces, and hyphens")
    @Size(min = 10, max = 13, message = "ISBN should be between 10 and 13 characters")
    private String isbn;

    // Validation: Four digits, representing a year
    @NotNull(message = "Published year is mandatory")
    @Pattern(regexp = "^(19|20)\\d{2}$", message = "Published year should be a valid four-digit year")
    private String publishedYear;
    
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getPublishedYear() {
		return publishedYear;
	}


	public void setPublishedYear(String publishedYear) {
		this.publishedYear = publishedYear;
	}


    
    
    @Override
   	public String toString() {
   		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", publishedYear="
   				+ publishedYear + "]";
   	}
    
    
}
