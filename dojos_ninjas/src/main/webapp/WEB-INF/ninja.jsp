<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ninjas</title>
</head>
<body>
    <h2>All Ninjas:</h2>
    <table>
        <tr>
            <th>Age</th>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        <c:forEach var="ninja" items="${ninjas}">
            <tr>
                <td><c:out value="${ninja.age}" /></td>
                <td><c:out value="${ninja.firstName}" /></td>
                <td><c:out value="${ninja.lastName}" /></td>
            </tr>
        </c:forEach>
    </table>

    <h2>Add Ninja:</h2>
    <form action="/ninjas" method="POST">
        <label for="dojoId">Choose Dojo:</label>
        <select id="dojoId" name="dojo.id">
            <c:forEach var="dojo" items="${dojos}">
                <option value="${dojo.id}">${dojo.name}</option>
            </c:forEach>
        </select><br>
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required><br>
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required><br>
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br>
        <input type="submit" value="Add Ninja">
    </form>
    <a href="/">Go back to Dojos</a>
</body>
</html>


