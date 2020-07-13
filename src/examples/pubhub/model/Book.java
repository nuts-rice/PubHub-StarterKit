package examples.pubhub.model;


//POJO - a Plain Old Java Object - for which a single instance represents a single tag. For reference, look at the Book class contained in the Starter Kit - that's a POJO too.

//For all intents and purposes, a POJO is just a Java class that defines some properties, and has getters and setters for accessing and manipulating those properties. 
//Every instance of a POJO represents an instance of a tangible object or idea - in this case, each instance of a Book class represents a single Book. 
//Put another way, each row of the Book table corresponds to a single instance of a Book object.

import java.time.LocalDate;

public class Book {

	private String isbn13;			// International Standard Book Number, unique
	private String title;
	private String author;
	private LocalDate publishDate;	// Date of publish to the website
	
	private double price;
	
	private byte[] content;

	// Constructor used when no date is specified
	public Book(String isbn, String title, String author, byte[] content) {
		this.isbn13 = isbn;
		this.title = title;
		this.author = author;
		this.publishDate = LocalDate.now();
		this.content = content;
	}
	
	// Constructor used when a date is specified
	public Book(String isbn, String title, String author, byte[] content, LocalDate publishDate) {
		this.isbn13 = isbn;
		this.title = title;
		this.author = author;
		this.publishDate = publishDate;
		this.content = content;
	}
	
	// Default constructor
	public Book() {
		this.isbn13 = null;
		this.title = null;
		this.author = null;
		this.publishDate = LocalDate.now();
		this.content = null;
	}
	
	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
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

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
	
	
}
