package examples.pubhub.dao;

import java.util.ArrayList;
import java.util.List;
import examples.pubhub.model.Tag;
import examples.pubhub.model.Book;
/**
 * Interface for our Data Access Object to handle database queries related to Tags.
 */
public interface TagDAO {

	
	
	
	
    public boolean addTag2Book(Tag tag);	//A method to add a tag to a book, given the tag name and a reference to a book 
        //(either a Book reference variable or just an ISBN-13)	
    public boolean removeTag2Book(String isbn13);
    public boolean deleteTagByISBN(String isbn);	//A method to remove a tag from a book, given the tag name and a reference to a book 
        //(either a Book reference variable or just an ISBN-13)

    public List<Tag> retrieveTag2Book(String isbn13);	//A method to retrieve all tags that have been added to a given book
    public ArrayList<Book> retrieveBook2Tag(Tag tag);	//A method to retrieve all books that have a given tag. 
		//Hint: This will require either a SQL JOIN statement or a nested query.
    
    
    //TODO: define these access methods to be used by the Servlets
    public List<Tag> getAllTags();
    public Tag getTagByName(String tagName);
    public boolean updateTag(Tag tag);
    public boolean deleteTag(String tagName);
    
}
    
