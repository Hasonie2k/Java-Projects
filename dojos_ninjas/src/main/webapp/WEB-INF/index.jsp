<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dojos and Ninjas</title>
</head>
<body>
    <h2>Add Dojo:</h2>
    <form action="/dojos" method="POST">
        <label for="dojoName">Dojo Name:</label>
        <input type="text" id="dojoName" name="name" required><br>
        <input type="submit" value="Add Dojo">
    </form>
</body>
</html>
