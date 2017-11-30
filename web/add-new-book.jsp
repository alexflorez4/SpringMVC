<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
   <head>
   	<title>Enter a new book</title>
   	<link href="<c:url value="/styles.css"/>" rel="Stylesheet" type="text/css"/>   
   </head>

   <body>
      <jsp:include page="/header.jsp"/>

      <div id="addBook">
         <form:form commandName="book">

            <label><fmt:message key="book.isbn"/></label>
                <form:input path="isbn"/>
                <form:errors path="isbn" cssClass="error"/>

            <label><fmt:message key="book.title"/></label>
                <form:input path="title"/>
                <form:errors path="title" cssClass="error"/>

            <label><fmt:message key="book.author"/></label>
                <form:input path="author"/>
                <form:errors path="author" cssClass="error"/>

            <label><fmt:message key="book.price"/></label>
                <form:input path="price"/>
                <form:errors path="price" cssClass="error"/>

		    <input type="submit" value="Add New Book"/>
	     </form:form>
      </div>
            
      <jsp:include page="/footer.jsp"/>
   </body>
</html>
