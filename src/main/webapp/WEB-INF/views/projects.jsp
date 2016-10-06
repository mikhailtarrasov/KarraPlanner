<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form"%>
<%@page session="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project list</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
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
                        <li class="active"><a href="/projects">Projects</a></li>
                        <li><a href="#">Users</a></li>
                        <li><a href="/welcome">Home</a></li>
                    </ul>
                    <!--<ul class="nav navbar-nav navbar-right">
                        <li><a href="/welcome">Home</a></li>
                    </ul>-->
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <div class="container-fluid">
            <div class="row">
                <h1>Список проектов</h1>

                <c:if test="${!empty listProjects}">
                    <table class="table table-striped">
                        <tr>
                            <th>Название</th>
                            <th style="min-width: 100px;">Дедлайн</th>
                            <th>Создатель</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <c:forEach items="${listProjects}" var="project">
                            <tr>
                                <td><a href="/projectdata/${project.ID}" target="_blank">${project.name}</a></td>
                                <td>${project.deadline}</td>
                                <td>${project.id_creator}</td>
                                <td><a class="btn btn-warning btn-sm" href="<c:url value='/edit/${project.ID}#bottom'/>">Ред.</a></td>
                                <td><a class="btn btn-danger btn-sm" href="<c:url value='/remove/${project.ID}'/>">Удалить</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>

                <h1>Добавить новый проект</h1>

                <c:url var="addAction" value="/projects/add"/>

                <form:form action="${addAction}" commandName="project">
                        <div class="col-md-6" style="padding: 0px;">
                            <table class="table">
                                <c:if test="${!empty project.name}">
                                    <tr>
                                        <td>
                                            <form:label path="ID">
                                                <spring:message text="ID"/>
                                            </form:label>
                                        </td>
                                        <td>
                                            <form:input path="ID" readonly="true" size="8" disabled="true"/>
                                            <form:hidden path="ID"/>
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
                                        <form:input path="name" class="form-control"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="description">
                                            <spring:message text="Описание"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="description" class="form-control"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="deadline">
                                            <spring:message text="Дедлайн"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input type="date" path="deadline" class="form-control"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="id_creator">
                                            <spring:message text="Создатель"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="id_creator" class="form-control"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <c:if test="${!empty project.name}">
                                            <input type="submit" class="btn btn-primary" value="<spring:message text="Edit Project"/>"/>
                                        </c:if>
                                        <c:if test="${empty project.name}">
                                            <input type="submit" class="btn btn-success" value="<spring:message text="Add Project"/>"/>
                                        </c:if>
                                        <a type="hidden" name="bottom"></a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>
