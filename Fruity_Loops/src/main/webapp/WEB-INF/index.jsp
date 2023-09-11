<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Fruits</title>
</head>
<body>
	    <table>
        <tr>
            <th>Price</th>
            <th>Name</th>
        </tr>
        <c:forEach items="${fruits}" var="fruit">
            <tr>
                <td><c:out value="${fruit.price}" /></td>
                <td><c:out value="${fruit.name}" /></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
