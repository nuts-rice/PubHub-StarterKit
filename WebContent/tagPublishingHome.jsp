<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<!-- Header -->
	<jsp:include page="header.jsp" />
	
	<!-- JSTL includes -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
<!-- 	Just some stuff you need -->
	<header>
	  <div class="container">
	  
	<c:choose>
	<c:when test="${not empty message }">
	  <p class="alert ${messageClass}">${message }</p>
	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>
	</c:when>
	</c:choose>
	
<h1>PUBHUB <small>Tag Publishing</small></h1>

<hr class="tag-primary">

<table class="table table-striped table-hover table-responsive pubhub-datatable">
			<thead>
				<tr>
					<td>Tag name:</td>
					<td>:</td>
					<td>Isbn13:</td>
					<td>Author Name:</td>
					<td>Publish Date:</td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="tag"items ="${tags}">
			<tr>
			<td> <c:out value="${tag.tagname}"/> </td>
			<td> <c:out value ="${tag.isbn13}"/> </td>
			<td> <c:out value = "${tag.authorName}"/> </td>
			<td> <c:out value = "${tag.publishDate}"/> </td>
			
			<td> <form action = "ViewTagDetails?tagName=${tag.tagName}" method = get>
			<input type = "hidden" name="tagName" value="${tag.tagName}">
			<button class="btn btn-primary">Details</button>
			
			
			</form></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
		</header>
		
		
		
		<!-- Footer -->
	<jsp:include page="footer.jsp" />
	
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>