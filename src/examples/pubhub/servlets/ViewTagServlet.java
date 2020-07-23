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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.model.Book;
import examples.pubhub.model.Tag;
import examples.pubhub.dao.TagDAO;
import examples.pubhub.utilities.DAOUtilities;


//This servlet helps user view the tag and which books it corrosponds to 

//our task is now to build the Java Servlets that will direct a user through the application 
//by serving them new views, and process their data manipulation.

@WebServlet("/ViewTagDetails")
public class ViewTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String tagName0 = request.getParameter("tagName");
		TagDAO dao = DAOUtilities.getTagDAO();
		Tag tag = dao.getTagByName(tagName0);
		request.setAttribute("tag", tag);
		
		// We can use a forward here, because if a user wants to refresh their browser on this page,
		// it will just show them the most recent details for their book. There's no risk of data
		// miss-handling here.
		request.getRequestDispatcher("tagDetails.jsp").forward(request, response);
}
}
