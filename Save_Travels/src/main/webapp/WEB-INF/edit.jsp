<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Save</title>
</head>
<body>
    <h1>Edit Save</h1>
    <form action="/edit/${save.id}" method="POST"> <!-- Replace "/edit/${save.id}" with the appropriate URL mapping for updating a save -->
        <input type="hidden" name="id" value="${save.id}" /> <!-- Include a hidden field for the save ID -->
        
        <label for="expense">Expense:</label>
        <input type="text" id="expense" name="expense" value="${save.expense}" /><br/>
        
        <label for="author">Author:</label>
        <input type="text" id="author" name="author" value="${save.author}" /><br/>
        
        <label for="author">Vendor:</label>
        <input type="text" id="vendor" name="vendor" value="${save.vendor}" /><br/>
        
        <label for="amount">Amount:</label>
        <input type="text" id="amount" name="amount" value="${save.amount}" /><br/>
        
        <input type="submit" value="Save" />
    </form>
</body>
</html>
