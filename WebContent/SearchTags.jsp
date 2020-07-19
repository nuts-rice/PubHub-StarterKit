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


<!-- Test goes here  -->
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
	

<h1>PUBHUB <small>search tags</small></h1>
<hr class="tag-primary">


