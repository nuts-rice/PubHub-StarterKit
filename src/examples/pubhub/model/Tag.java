package examples.pubhub.model;
// Your next task is to create a Tag POJO that can store and map the data you're saving in your database tables,
// and relate it to the Book class if necessary. You may decide to keep the two as separate entities, 
// or you may decide to relate them through a collection.

import java.time.LocalDate;

public class Tag {
	private String tagName;
	private String isbn13;
	private String authorName;
	private LocalDate publishDate;
	

	//No argument/default constructor 
	public Tag(){
		this.tagName = null;
		this.isbn13 = null;
		this.authorName = null;
		this.publishDate = null;
		
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	
	
}
