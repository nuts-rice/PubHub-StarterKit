// package examples.pubhub.dao;

// import java.util.List;

// // import examples.pubhub.model.Book;

// // public interface VIPTagDAOImpl extends BookDAO {
// // 	public void addTag2Book();	//A method to add a tag to a book, given the tag name and a reference to a book 
// // 	//(either a Book reference variable or just an ISBN-13)	
// // 	public void removeTag2Book();	//A method to remove a tag from a book, given the tag name and a reference to a book 
// // 		//(either a Book reference variable or just an ISBN-13)
// // 	public List<Tag> retrieveTag2Book();	//A method to retrieve all tags that have been added to a given book
// // 	public List<Book> retrieveBook2Tag();	//A method to retrieve all books that have a given tag. 
// // 		//Hint: This will require either a SQL JOIN statement or a nested query.
	
// // 	//addTag2Book: INSERT INTO Book_Tags
// // 				//(isbn13, tag_name)
	
// // 	//removeTag2Book: DELETE FROM Book_Tags
// // 					//(isbn13, tag_name)
	
// // 	//retrieveTag2Book: SELECT * FROM Book_tags WHERE (isbn13)
	
// // 	//retrieveBook2Tag: Select Tag_name,
// // 					// FROM
// // 					// Book_tags
// // 					// INNER JOIN Books
// // 					//ON Book.Books_tags.isbn13
// // }
