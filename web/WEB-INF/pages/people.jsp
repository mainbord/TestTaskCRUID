<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>People list</h1>

<c:if test="${!empty listPeople}">
    <table class="tg">
        <tr>
            <th width="80">id</th>
            <th width="120">name</th>
            <th width="120">age</th>
            <th width="120">isAdmin</th>
            <th width="120">createdDate</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listPeople}" var="person">
            <tr>
                <td>${person.id}</td>
                <td>${person.name}</td>
                <td>${person.age}</td>
                <td>${person.isAdmin}</td>
                <td>${person.createdDate}</td>
                <td><a href="<c:url value='/edit/${person.ID}'/>">">Edit</a></td>
                <td><a href="<c:url value='/remove/${person.ID}'/>">">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Book</h1>

<%--<c:url var="addAction" value="/people/add"/>

<form:form action="${addAction}" commandName="person">
    <table>
        <c:if test="${!empty person.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
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
                <form:input path="Age"/>
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
        <tr>
            <td>
                <form:label path="createdDate">
                    <spring:message text="createdDate"/>
                </form:label>
            </td>
            <td>
                <form:input path="createdDate"/>
            </td>
        </tr>
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
</form:form>--%>
</body>
</html>
