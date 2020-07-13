package examples.pubhub.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import examples.pubhub.model.Book;
import examples.pubhub.model.Tag;

public class TagDAOImplTest0 {
    

    public static void main(String[] args){
        Tag testTag0 = new Tag();
        testTag0.setTagName("female protag");
        testTag0.setAuthorName("Margaret Atwood");
        testTag0.setIsbn13("978-0385721677");
        testTag0.setPublishDate();
        TagDAO testDAO = new TagDAOImpl();


        testDAO.addTag2Book(tag);
        testDAO.deleteBookByISBN();
        testDAO.removeTag2Book(isbn13);
        testDAO.retrieveBook2Tag();
        testDAO.retrieveTag2Book(isbn13);
        

        
           
    }
}