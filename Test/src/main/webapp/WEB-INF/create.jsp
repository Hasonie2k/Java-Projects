<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a House</title>
</head>
<body>
    <h1>Add a House to Your List</h1>
    <form:form action="/users/create" method="post" modelAttribute="newTest">
        <div>
            <label for="price">Price:</label>
            <form:input type="number" path="price" id="price" />
            <form:errors path="price" cssClass="error" />
        </div>
        <div>
            <input type="submit" value="Submit" />
        </div>
    </form:form>
</body>
</html>
