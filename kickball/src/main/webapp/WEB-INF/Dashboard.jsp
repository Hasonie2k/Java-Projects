<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Teams</title>
</head>
<h1>Welcome ${currentUser.userName}</h1>
<body>
    <table>
        <thead>
            <tr>
                <th>Team Name</th>
                <th>Skill Level (1-5)</th>
                <th>Game Day</th>
                
            </tr>
        </thead>
        <tbody>
            <c:forEach var="team" items="${teams}">
                <tr>
                    <td><a href="<c:url value='/team/view/team/${team.id}'/>">${team.teamName}</a></td>
                    <td>${team.skill}</td>
                    <td>
                    <c:out value = "${team.gameDate}">
                    </c:out>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/team/create">Create Team</a>
    <a href="/logout">Logout :(</a>
</body>
</html>
