<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form"%>
<%@page session="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Project Details</h1>

<table>
    <tr>
        <th>name</th>
        <th>description</th>
        <th>deadline</th>
        <th>creator</th>
    </tr>
    <tr>
        <td>${project.name}</td>
        <td>${project.description}</td>
        <td>${project.deadline}</td>
        <td>${project.id_creator}</td>
    </tr>
</table>
</body>
</html>
