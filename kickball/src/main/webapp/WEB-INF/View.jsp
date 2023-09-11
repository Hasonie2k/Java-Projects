<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view team</title>
</head>
<body>
    <h1>${team.teamName}</h1>
    <a href="/team/home">Back to Home</a>
    <p>Team Name: ${team.teamName}</p>
    <p>Skill Level: ${team.skill}</p>
    <p>Game Day: ${team.gameDate}</p>
    
   <c:if  test = "${team.user.id==currentUser.id}">
	    <a href="/team/edit/team/${team.id}">Edit</a>
	
	    <form action="/team/delete/team/${team.id}" method="post">
	        <input type="hidden" name="_method" value="DELETE" />
	        <button type="submit">Delete</button>
	    </form>
	</c:if>

</body>
</html>