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

@WebServlet("/UpdateTag")
public class UpdateTagServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isSuccess = false;
		String tagName0 = request.getParameter("tagName");
		
		TagDAO database = DAOUtilities.getTagDAO();
		Tag tag0 = database.getTagByName(tagName0);
		
		if(tag0 != null) {
		tag0.setAuthorName(request.getParameter("Author name"));
		tag0.setPublishDate(LocalDate.now());
		tag0.setIsbn13(request.getParameter("isbn13"));
		request.setAttribute("tag", tag0);
		isSuccess = database.updateTag(tag0);
		}else {
			isSuccess = false;
		}
		if (isSuccess = true) {
			request.getSession().setAttribute("message", "sucessfully updated");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("ViewTagDetails?tagName=" + tagName0);
			
		}else {
			request.getSession().setAttribute("message", "There was a problem updating this tag");
			request.getSession().setAttribute("messageClass", "alert-danger");
			request.getRequestDispatcher("tagDetails.jsp").forward(request, response);
		}
		}

}

