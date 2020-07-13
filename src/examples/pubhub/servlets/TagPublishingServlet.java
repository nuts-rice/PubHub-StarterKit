package examples.pubhub.servlets;

import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.time.LocalDate;


import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.model.Book;
import examples.pubhub.model.Tag;
import examples.pubhub.dao.TagDAO;
import examples.pubhub.utilities.DAOUtilities;


//This servlet takes you to home page for Tags

//our task is now to build the Java Servlets that will direct a user through the application 
//by serving them new views, and process their data manipulation.

@MultipartConfig
public class TagPublishingServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("publishTag.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String isbn13 = req.getParameter("isbn13");
		String tagName0 = req.getParameter("tag name");
		
		TagDAO database = DAOUtilities.getTagDAO();
		Tag tempTag = database.getTagByName(tagName0);
		if(tempTag != null) {
			req.setParameter("message", "This tag:" + " " + tagName0 + " " + "has already been uploaded");
			req.getSession().setAttribute("messageClass", "alert-danger");
			req.getRequestDispatcher("publishTag.jsp").forward(req, resp);
		}
		else {
			Tag tag0 = new Tag();
			tag0.setTagName(req.getParameter("tag name"));
			tag0.setAuthorName(req.getParameter("author name"));
			tag0.setPublishDate(LocalDate.now());
			tag0.setIsbn13(req.getParameter("isbn13"));
			
			
			boolean isSucess = database.addTag2Book(tag0);
			
			if(isSucess) {
				req.getSession().setAttribute("message", "Tag successfully published");
				req.getSession().setAttribute("messageClass", "alert-success");
				
				resp.sendRedirect(req.getContextPath() + "/TagPublishing");
			}else {
				req.getSession().setAttribute("message", "There was a problem publishing the tag");
				req.getSession().setAttribute("messageClass", "alert-danger");
				req.getRequestDispatcher("publishTag.jsp").forward(req, resp);
			}
			
		}
		
	}
	
    
}