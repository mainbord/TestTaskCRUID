<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Title</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>People list</h1>

<c:if test="${!empty listPeople}">
    <table class="tg">
        <tr>
            <th width="80">Id</th>
            <th width="120">Name</th>
            <th width="120">Age</th>
            <th width="120">IsAdmin</th>
            <th width="120">CreatedDate</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listPeople}" var="person">
            <tr>
                <td>${person.id}</td>
                <td><a href="/persondata/${person.id}" target="_blank">${person.name}</a></td>
                <td>${person.age}</td>
                <td>${person.isAdmin}</td>
                <td>${person.createdDate}</td>
                <td><a href="<c:url value='/edit/${person.id}'/>">Edit </a></td>
                <td><a href="<c:url value='/remove/${person.id}'/>">Delete ${person.id}</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

__________________
${hhh}
_____________

<h1>Add a Person</h1>

<c:url var="addAction" value="/people/add"/>

<form:form action="${addAction}" commandName="person">
    <table>
        <c:if test="${!empty person.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="Id"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
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
                <form:label path="age">
                    <spring:message text="Age"/>
                </form:label>
            </td>
            <td>
                <form:input path="age"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="isAdmin">
                    <spring:message text="IsAdmin"/>
                </form:label>
            </td>
            <td>
                <form:input path="isAdmin"/>
            </td>
        </tr>
<%--        <tr>
            <td>
                <form:label path="createdDate">
                    <spring:message text="CreatedDate"/>
                </form:label>
            </td>
            <td>
                <form:input path="createdDate"/>
            </td>
        </tr>--%>
        <tr>
            <td colspan="2">
                <c:if test="${!empty person.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Person"/>"/>
                </c:if>
                <c:if test="${empty person.name}">
                    <input type="submit"
                           value="<spring:message text="Add Person"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

<c:url var="searchAction" value="/people/find/{name}"/>

<form:form action="${searchAction}" commandName="person">
    <tr>
        <td colspan="3">
            <input type="submit"
                   value="<spring:message text="Find Person by name"/>"/>
        </td>
    </tr>


<%--    <td>
        <form:input path="search_name"/>
    </td>--%>
</form:form>
</body>
</html>