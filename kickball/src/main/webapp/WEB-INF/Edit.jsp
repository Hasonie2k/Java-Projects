<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit team</title>
</head>
<body>
<h1>Edit Team</h1>
    <a href="/team/home">Go to Home</a>
<form:form action="/team/update/team/${team.id}" method="post" modelAttribute="team">

    <div>
        <label for="teamName">Team Name:</label>
        <form:input type="text" path="teamName" id="teamName" />
        <form:errors path="teamName" cssClass="error" />
    </div>
    <div>
        <label for="skill">Skill Level (1-5):</label>
        <form:input type="number" path="skill" id="skill" />
        <form:errors path="skill" cssClass="error" />
    </div>
    <div>
        <label for="gameDate">Game Day:</label>
        <form:input type="text" path="gameDate" id="gameDate" />
        <form:errors path="gameDate" cssClass="error" />
    </div>
    <div>
        <input type="submit" value="Update" />
    </div>
</form:form>

</body>
</html>
