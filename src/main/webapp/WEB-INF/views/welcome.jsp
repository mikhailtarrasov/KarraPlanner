<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

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
                <div class="container">
                    <ul class="nav navbar-nav">
                        <li><a href="/projects">Проекты</a></li>
                        <li class="active"><a href="/welcome">Домой</a></li>
                        <li><a onclick="document.forms['logoutForm'].submit()">Выйти</a></li>
                    </ul>
                </div>
                <%--<ul class="nav navbar-nav navbar-right">
                    <li><a href="${contextPath}/index">Home</a></li>
                    <li><a onclick="document.forms['logoutForm'].submit()">Logout</a></li>
                </ul>--%>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <div class="jumbotron">
            <h1>Добро пожаловать, ${pageContext.request.userPrincipal.name}!</h1>
            <p>Рады приветствовать вас в нашем сервисе - KarraPlanner. Вы можете приступить к работе над проектами прямо сейчас.</p>
            <p><a class="btn btn-primary btn-lg" href="/projects" role="button">Перейти к проектам</a></p>
        </div>

        <a href="/admin">Go to admin panel</a>
    </c:if>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>