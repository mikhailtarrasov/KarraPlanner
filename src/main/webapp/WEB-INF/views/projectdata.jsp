<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form"%>
<%@page session="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project tasks</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <nav class="navbar navbar-default navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">KarraPlanner</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/projects">Project details</a></li>
                    <li><a href="/projects">Projects</a></li>
                    <li><a href="#">Users</a></li>
                    <li><a href="/welcome">Home</a></li>
                </ul>
                <!--<ul class="nav navbar-nav navbar-right">
                    <li><a href="/welcome">Home</a></li>
                </ul>-->
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

    <h1>Детали проекта</h1>

    <table class="table">
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
</div>
</body>
</html>
