<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>DashBoard</title>
</head>
<body>
    <h1>Hello</h1>

    <table>
        <thead>
            <tr>
                <th>Expense</th>
                <th>Author</th>
                <th>Vendor</th>
                <th>Amount</th>
                <th>Edit</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${saves}" var="save">
        	<tr>
	            <td><a href="/view/${save.id}"><c:out value="${save.expense}" /></a></td>
	            <td><c:out value="${save.author}" /></td>
	            <td><c:out value="${save.vendor}" /></td>
	            <td><c:out value="${save.amount}" /></td>
	            <td><a href="/edit/${save.id}">Edit</a></td>
	            <td><a href="/delete/${save.id}">Delete</a></td>
       		 </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <h2>Create Save</h2>
    <form action="/save" method="POST">
        <label for="expense">Expense:</label>
        <input type="text" id="expense" name="expense" /><br/>
        
        <label for="author">Author:</label>
        <input type="text" id="author" name="author" /><br/>
        
        <label for="vendor">Vendor:</label>
        <input type="text" id="vendor" name="vendor" /><br/>
        
        <label for="amount">Amount:</label>
        <input type="text" id="amount" name="amount" /><br/>
        
        <input type="submit" value="Create" />
    </form>
</body>
</html>
