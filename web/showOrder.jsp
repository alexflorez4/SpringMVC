<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Show Books</title>
</head>

<body>

<h1>Welcome back, ${order.customer.name}</h1>

<ul>
    <c:forEach items="${order.booksOrdered}" var="book">
        <li>
            ${book.title}
        </li>
    </c:forEach>
</ul>

</body>
</html>