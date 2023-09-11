<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Save Details</title>
</head>
<body>
    <h1>Save Details</h1>
    
    <table>
        <tr>
            <th>Expense:</th>
            <td><c:out value="${save.expense}" /></td>
        </tr>
        <tr>
            <th>Author:</th>
            <td><c:out value="${save.author}" /></td>
        </tr>
        <tr>
            <th>Vendor:</th>
            <td><c:out value="${save.vendor}" /></td>
        </tr>
        <tr>
            <th>Amount:</th>
            <td><c:out value="${save.amount}" /></td>
        </tr>
    </table>
    
    <a href="/">Back to List</a>
</body>
</html>
