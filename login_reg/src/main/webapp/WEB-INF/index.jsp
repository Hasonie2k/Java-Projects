<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
    <h1>Login Page</h1>
    
    <!-- Register Section -->
    <h2>Register</h2>
    <form method="post" action="/register">
        <label for="username">Username:</label>
        <input type="text" id="username" name="userName" required><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        
        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" name="confirm" required><br>
        
        <input type="submit" value="Register">
    </form>
    
    <!-- Login Section -->
<h2>Login</h2>
<form method="post" action="/login">
    <label for="loginEmail">Email:</label>
    <input type="email" id="loginEmail" name="email" required><br>
    
    <label for="loginPassword">Password:</label>
    <input type="password" id="loginPassword" name="password" required><br>
    
    <input type="submit" value="Login">
</form>
</body>
</html>