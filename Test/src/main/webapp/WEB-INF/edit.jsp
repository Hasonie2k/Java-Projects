<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Test Model</title>
</head>
<body>
    <h1>Edit Test Model</h1>
    <form:form action="/users/update/${testModel.id}" method="post" modelAttribute="testModel">
        <div>
            <label for="price">Price:</label>
            <form:input type="number" path="price" id="price" />
            <form:errors path="price" cssClass="error" />
        </div>
        <div>
            <label for="updatedAt">Updated At:</label>
            <form:input type="date" path="updatedAt" id="updatedAt" />
            <form:errors path="updatedAt" cssClass="error" />
        </div>
        <div>
            <input type="submit" value="Update" />
        </div>
    </form:form>
</body>
</html>
