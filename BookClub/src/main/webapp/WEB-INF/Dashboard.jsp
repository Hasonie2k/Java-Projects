<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Dash</title>
</head>
<body>
    <h1>Dashboard:</h1>
    <h2>Welcome , ${currentUser.userName} </h2>
    <h3>Books from everyone's shelf</h3>
    <a href="/users/create">Create Book</a>
    <table>
        <thead>
            <tr>
            	<th>Posted By</th>
                <th>Title</th>
                <th>Author</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                	<td>${currentUser.userName}</td>
                    <td><a href="/users/view/book/${book.id}">${book.title}</a></td>
                    
                    <td>${book.author}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/users/logout">Logout :(</a>
</body>
</html>

