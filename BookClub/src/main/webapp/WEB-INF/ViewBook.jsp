<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View Book</title>
</head>
<body>

<h2>${book.title}</h2>

<c:if test="${isCreator}">
    <p> ${currentUser.userName} read ${book.title} by ${book.author} </p>
</c:if>

<p>Author: ${book.author}</p>
<p>Title : ${book.title}</p>
<p>Thoughts: ${book.thoughts}</p>
<c:if test="${isCreator}">

    <form action="/users/delete/book/${book.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Delete Book">
    </form>

    <form action="/users/edit/book/${book.id}" method="get">
        <input type="submit" value="Edit Book">
    </form>
</c:if>
<a href="/users/home">Go to Home</a>
</body>
</html>
