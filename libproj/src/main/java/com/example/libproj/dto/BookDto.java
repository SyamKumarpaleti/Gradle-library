package com.example.libproj.dto;

public class BookDto {
	
	 
		private Long id;
		private String title;
	    private String author;
	    private String isbn;
	    private int publishedYear;
	    
	    
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
		public int getPublishedYear() {
			return publishedYear;
		}
		public void setPublishedYear(int publishedYear) {
			this.publishedYear = publishedYear;
		}
		@Override
		public String toString() {
			return "BookDto [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn
					+ ", publishedYear=" + publishedYear + "]";
		}
		
		
		

}
