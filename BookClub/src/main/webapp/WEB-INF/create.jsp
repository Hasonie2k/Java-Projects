<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Create Book</title>
</head>
<body>
    <h1>Add a Book to Your Shelf</h1>
    <form:form action="/users/create/book" method="post" modelAttribute="newBook">
        <div>
            <label for="author">Author:</label>
            <form:input type="text" path="author" id="author" />
            <form:errors path="author" cssClass="error" />
        </div>
        <div>
            <label for="title">Title:</label>
            <form:input type="text" path="title" id="title" />
            <form:errors path="title" cssClass="error" />
        </div>
        <div>
            <label for="thoughts">Thoughts:</label>
            <form:textarea path="thoughts" id="thoughts" />
            <form:errors path="thoughts" cssClass="error" />
        </div>
        <div>
            <input type="submit" value="Create" />
        </div>
    </form:form>
</body>
</html>


