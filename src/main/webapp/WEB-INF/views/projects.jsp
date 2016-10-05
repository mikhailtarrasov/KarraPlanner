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
    <a href="/welcome">Back to main menu</a>
    <br>
    <br>

    <h1>Project List</h1>

    <c:if test="${!empty listProjects}">
        <table>
            <tr>
                <th>name</th>
                <th>description</th>
                <th>deadline</th>
                <th>creator</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${listProjects}" var="project">
                <tr>
                    <td><a href="/projectdata/${project.ID}" target="_blank">${project.name}</a></td>
                    <td>${project.description}</td>
                    <td>${project.deadline}</td>
                    <td>${project.id_creator}</td>
                    <td><a href="<c:url value='/edit/${project.ID}'/>">Edit</a></td>
                    <td><a href="<c:url value='/remove/${project.ID}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <h1>Add a Project</h1>

    <c:url var="addAction" value="/projects/add"/>

    <form:form action="${addAction}" commandName="project">
        <table>
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
                        <spring:message text="Name"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="name"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="description">
                        <spring:message text="Description"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="description"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="deadline">
                        <spring:message text="Deadline"/>
                    </form:label>
                </td>
                <td>
                    <form:input type="date" path="deadline"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="id_creator">
                        <spring:message text="ID_creator"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id_creator"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${!empty project.name}">
                        <input type="submit" value="<spring:message text="Edit Project"/>"/>
                    </c:if>
                    <c:if test="${empty project.name}">
                        <input type="submit" value="<spring:message text="Add Project"/>"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
