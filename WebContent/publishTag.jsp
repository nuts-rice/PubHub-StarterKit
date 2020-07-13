<!-- Your next task is to use your newfound knowledge of clientside technologies to design the JSPs that will display your application to the users. As usual, you have some discretion regarding how to approach this - you may choose to implement your tagging and searching functionality in new, separate JSPs, or you may decide to add that functionality to existing JSPs. -->

<!-- You will need to, at minimum: -->

<!--     Create a page to search for books that have a provided tag. -->
<!--     Create a page (or edit bookDetails.jsp) to add and remove tags from a book. -->



<!-- Header goes here -->
<jsp:include page = "header.jsp"/>

<!-- JSTIL includes -->

	<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<header>
	
	<div class = "container"/>
	
	<c:choose>
	<c:when test="${not empty message }">
	  <p class="alert ${messageClass}">${message }</p>
	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>
	</c:when>
	</c:choose>
	
	<h1>PUBHUB <small>tag to publish</small></h1>
<!-- 	this enctype is file upload control. InputType must be a file for this -->
<!-- 	to support this enctype, the servlet uses Multipart config  -->
	<form action = "PublishTag" method = "post" class = "form-horizantal" enctype = "multipart/form-data"
	<div class = "form-group">
	<label for = "tagName" class ="col-sm-4 control-label">Tag name</label>
	<div class="col-sm-5">
	<input type="text" class="form-control" id="tagName" name="tagName" placeholder="Tag name" required="required" value="${param.tagName }" />
		</div>
	</div>
	
	
	
	
	</form>
	
	
		
	%>
	
	
	
	
	
	<!-- Footer -->
	<jsp:include page="footer.jsp" />
	
	