<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>${param.title}</title>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>List of Players</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>List of Players</h2>  
    <table>
        <c:forEach items="${players}" var="player">
            <tr>
            <td>${player.firstName}</td>
            <td>${player.lastName}</td>
            </tr>
        </c:forEach>
    </table>
    <br/>
</body>
</html>