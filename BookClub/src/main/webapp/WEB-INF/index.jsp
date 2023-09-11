<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registration</title>
</head>
<body>
    <h1>Registration</h1>
    <form:form action="/users/register" method="post" modelAttribute="newUser">
        <form:errors class="error" path="userName" />

        <label for="userName">UserName:</label>
        <form:input type="text" path="userName" id="userName" /><br />

        <form:errors class="error" path="email" />
        <label for="email">Email:</label>
        <form:input type="email" path="email" id="email" /><br />

        <form:errors class="error" path="password" />
        <label for="password">Password:</label>
        <form:input type="password" path="password" id="password" /><br />

        <form:errors class="error" path="confirm" />
        <label for="confirm">Confirm Password:</label>
        <form:input type="password" path="confirm" id="confirm" /><br />
        <input type="submit" value="Submit" />
    </form:form>
    <h2>Login</h2>
		<form:form action="/users/login" method="post" modelAttribute="loginUser">
	    <form:errors path="email"/>
	    <label for="email">Email:</label>
	    <form:input type="email" path="email" id="email" /><br />
	    <form:errors path="password"/>
	    <label for="password">Password:</label>
	    <form:input type="password" path="password" id="password" /><br />
	    <input type="submit" value="Login" />
	</form:form>
</body>
</html>
