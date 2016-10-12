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
    <c:set var="project" value="${project}" scope="page"/>
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
                    <li class="active"><a href="#">Детали проекта</a></li>
                    <li><a href="/projects">Другие проекты</a></li>
                    <li><a href="/welcome">Домой</a></li>
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
            <th>Название</th>
            <th>Описание</th>
            <th style="min-width: 100px;">Дедлайн</th>
            <%--<th>Создатель</th>--%>
        </tr>
        <tr>
            <td>${project.name}</td>
            <td>${project.description}</td>
            <td>${project.deadline}</td>
            <%--<td>${project.id_creator}</td>--%>
        </tr>
    </table>

    <h1>Задачи проекта</h1>

    <c:if test="${!empty listTasks}">
        <table class="table table-striped">
            <tr>
                <th>Название</th>
                <th>Описание</th>
                <th style="min-width: 100px;">Дедлайн</th>
                <%--<th>Статус</th>--%>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${listTasks}" var="task">
                <tr>
                    <td>${task.name}</td>
                    <td>${task.description}</td>
                    <td>${task.deadline}</td>
                    <%--<td>${task.id_status}</td>--%>
                    <td><a class="btn btn-primary btn-sm" href="<c:url value='/projectdata/${project.ID}/edit/${task.ID}#b'/>">Ред.</a></td>
                    <td><a class="btn btn-danger btn-sm" href="<c:url value='/projectdata/${project.ID}/remove/${task.ID}'/>">Удалить</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:url var="addAction" value="/projectdata/add"/>

    <form:form action="${addAction}" commandName="task">
        <c:if test="${!empty task.name}">
            <h1>Редактировать задачу</h1>
        </c:if>
        <c:if test="${empty task.name}">
            <h1>Добавить новую задачу</h1>
        </c:if>
        <div class="col-md-6" style="padding: 0px;">
            <table class="table">
                <c:if test="${!empty task.name}">
                    <tr>
                        <td>
                            <form:label path="IdTask">
                                <spring:message text="IdTask"/>
                            </form:label>
                        </td>
                        <td>
                            <%--<form:input path="ID" readonly="true" size="8" disabled="true"/>--%>
                            <form:hidden path="IdTask"/>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        <form:label path="name">
                            <spring:message text="Название"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="name" class="form-control" required="required"/>
                    </td>
                </tr>
                <tr hidden>
                    <td>
                        <form:label path="id_project">
                            <spring:message text="Идентификатор проекта"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="id_project" value="${project.ID}" readonly="true" class="form-control"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="description">
                            <spring:message text="Описание"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="description" class="form-control" required="required"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="deadline">
                            <spring:message text="Дедлайн"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input type="date" path="deadline" class="form-control" required="required"/>
                    </td>
                </tr>
                <tr hidden>
                    <td>
                        <form:label path="id_status">
                            <spring:message text="Статус"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="id_status" class="form-control"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <c:if test="${!empty task.name}">
                            <input type="submit" class="btn btn-primary" value="<spring:message text="Edit Task"/>"/>
                        </c:if>
                        <c:if test="${empty task.name}">
                            <input type="submit" class="btn btn-success" value="<spring:message text="Add Task"/>"/>
                        </c:if>
                        <a type="hidden" name="bottom"></a>
                    </td>
                </tr>
            </table>
        </div>
    </form:form>
</div>
</body>
</html>
