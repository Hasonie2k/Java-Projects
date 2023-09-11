<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test Models</title>
</head>
<body>
    <h1>All Test Models</h1>
 <table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Price</th>
            <th>Created At</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${testModels}" var="testModel">
            <tr>
                <td>${testModel.id}</td>
                <td>${testModel.price}</td>
                <td>${testModel.createdAt}</td>
                <td><a href="/users/edit/${testModel.id}">Edit</a></td>
                <td><a href="/users/delete/${testModel.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
 

    <div>
        <a href="/users/create">Create New Test</a>
    </div>
</body>
</html>

