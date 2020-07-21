package examples.pubhub.dao;

// In the last dive, you wrote the interfaces that declare the methods your application will use to pull data
// from, and send data to, your tagging tables. This week, your task will be to implement those interfaces and 
// code your complete Data Access Layer.
// As usual, feel free to use the existing BookDAOImpl class as a guideline for this process.

import java.util.List;

import javax.print.DocFlavor.STRING;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import examples.pubhub.model.Book;
import examples.pubhub.model.Tag;
import examples.pubhub.utilities.DAOUtilities;

public class TagDAOImpl implements TagDAO {
    //connection is instated here
    Connection connection0 = null;
    //refer to video about JDBC Video: Statements
    //here we use a PreparedStatement to protect against SQL injections 
    PreparedStatement stmnt = null;


    //A method to add a tag to a book, given the tag name and a reference to a book 
    //(either a Book reference variable or just an ISBN-13)	

    //addTag2Book: INSERT INTO Book_Tags
    //(isbn13, tag_name)
    @Override
    public boolean addTag2Book(Tag tag){
        

        

        try{
            connection0 = DAOUtilities.getConnection(); // Get our database connection from the manager
            String sqlStr = "INSERT INTO Book_Tags WHERE isbn13 LIKE ? VALUES (?, ?, ? )";    // SQL statement
            	// Note the ? in the query
            stmnt = connection0.prepareStatement(sqlStr); // Creates the prepared statement from the query


            //set ?s here before execution
            stmnt.setString(0, tag.getIsbn13());
            stmnt.setString(1, tag.getTagName());
            stmnt.setString(2, tag.getAuthorName());
            stmnt.setString(3, tag.getPublishDate().toString());
            
            if (stmnt.executeUpdate() != 0)
            {
                return true;
            }else{
                return false;
            }


                
            }catch(SQLException e){
                e.printStackTrace();
                return false;

            }finally{
                closeResources();
            }



        }
        
    }
    //A method to remove a tag from a book, given the tag name and a reference to a book 
    //(either a Book reference variable or just an ISBN-13)

    //removeTag2Book: DELETE FROM Book_Tags
	//(isbn13, tag_name)
    @Override
    public boolean removeTag2Book(String isbn13){
        try{
            connection0 = DAOUtilities.getConnection();
            String sql = "DELETE Book_Tag WHERE isbn_13 = ?";
            stmnt = connection0.prepareStatement(sql);

            stmnt.setString(1, isbn13);

            if (stmnt.executeUpdate() != 0){
                return true;
            }
            else{
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;

        }finally{
            closeResources();
        }

    }
    //A method to retrieve all tags that have been added to a given book

    //retrieveTag2Book: SELECT * FROM Book_tags WHERE (isbn13)
    @Override
    public List<Tag> retrieveTag2Book(String isbn13){
        List<Tag> tagList = null;

        try{
            connection0 = DAOUtilities.getConnection();
            String sql = "SELECT * FROM Book_tags WHERE = ?";
            stmnt = connection0.prepareStatement(sql);
            stmnt.setString(1, isbn13);
            ResultSet rs = stmnt.executeQuery();

            if(rs.next()){
                Tag tagToAdd = new Tag();
                tagToAdd.setTagName(rs.getString("tag name"));
                tagToAdd.setIsbn13(rs.getString("isbn13"));
                tagToAdd.setAuthorName(rs.getString("author"));
                tagToAdd.setPublishDate(rs.getDate("publish date").toLocalDate());
                tagList.add(tagToAdd);
            }
        }catch(SQLException e){
            e.printStackTrace();

        }finally{
            closeResources();
        }
        return tagList;
    }

    //A method to retrieve all books that have a given tag. 
    //Hint: This will require either a SQL JOIN statement or a nested query.

    //retrieveBook2Tag: Select Tag_name,
    // FROM
    // Book_tags
    // INNER JOIN Books
    //ON Book.Books_tags.isbn13
    
//    @Override
//    public List<Book> retrieveBook2Tag(){
//        List<Book> bookList = null;
//
//        try{
//            connection0 = DAOUtilities.getConnection();
//            String sql = "SELECT * FROM Book_Tags WHERE = ? INNER JOIN Books";
//        }catch(SQLException e){
//            e.printStackTrace();
//        }finally{
//            closeResources();
//        }
//        re
//    }
    
    
    //TODO: implements for these

	@Override
	public boolean deleteTag(String tagName) {
		// TODO Auto-generated method stub
		
		try {
			connection0 = DAOUtilities.getConnection();
			String sql = "DELETE Tags WHERE tagName = ?";
			stmnt = connection0.prepareStatement(sql);
			
			stmnt.setString(1, tagName);
			if (stmnt.executeUpdate() != 0)
			{
				return true;
			}
			else {
				return false;
			}
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
		finally {
			closeResources();
		}
	}

	@Override
	public ArrayList<Book> retrieveBook2Tag(Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tag> getAllTags() {
		// TODO Auto-generated method stub
		List<Tag> tags = new ArrayList<>();
		try {
			connection0 = DAOUtilities.getConnection();
			String sql = "SELECT * FROM Tags";
			stmnt = connection0.prepareStatement(sql);
			
			ResultSet rs = stmnt.executeQuery();
			//so long as ResultSet returns a result 
			while (rs.next()) {
				// We need to populate a Tag object with info for each row from our query result
				Tag tag = new Tag();
				
				// Each variable in our Tag object maps to a column in a row from our results.
				tag.setTagName(rs.getString("tag name"));
				tag.setIsbn13(rs.getString("isbn13"));
				tag.setAuthorName(rs.getString("author"));
				// The SQL DATE datatype maps to java.sql.Date... which isn't well supported anymore. 
				// We use a LocalDate instead, because this is Java 8.
				tag.setPublishDate(rs.getDate("publish date").toLocalDate());
				
				tags.add(tag);
				
			}
			rs.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
		 closeResources();
		}
		
		return tags;
	}


	@Override
	public Tag getTagByName(String tagName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateTag(Tag tag) {
		// TODO Auto-generated method stub
		return false;
	}

    // Closing all resources is important, to prevent memory leaks. 
	// Ideally, you really want to close them in the reverse-order you open them
    private void closeResources(){
        try{
            if  (stmnt != null){
                stmnt.close();
            }
        } catch(SQLException e){
            System.out.println("Could not close statement");
            e.printStackTrace();
        }
        try{
            if (connection0 != null){
                connection0.close();
            }
        }catch (SQLException e){
            System.out.println("Could not close connection");
            e.printStackTrace();
        }   
    }
   
}
