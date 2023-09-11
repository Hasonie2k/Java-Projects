<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add a Hunt</title>
</head>
<body>
    <h1>Add a Team to Your List</h1>
    <a href="/team/home">Go to Home</a>
    <form:form action="/team/create/team" method="post" modelAttribute="newTeam">
        <div>
            <label for="teamName">Team Name:</label>
            <form:input type="text" path="teamName" id="teamName" />
            <form:errors path="teamName" cssClass="error" />
        </div>
        <div>
            <label for="skill">Skill level (1-5):</label>
            <form:input type="number" path="skill" id="skill" />
            <form:errors path="skill" cssClass="error" />
        </div>
        <div>
        <label for="gameDate">Game Day:</label>
        <form:input type="text" path="gameDate" id="gameDate" />
        <form:errors path="gameDate" cssClass="error" />
    </div>
        <div>
            <input type="submit" value="Create" />
        </div>
    </form:form>
</body>
</html>
