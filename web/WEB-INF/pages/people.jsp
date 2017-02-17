<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <th width="80">ID</th>
            <th width="120">name</th>
            <th width="120">age</th>
            <th width="120">isAdmin</th>
            <th width="120">createdDate</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listPeople}" var="person">
            <tr>
                <td>${person.ID}</td>
                <td>${person.name}</td>
                <td>${person.age}</td>
                <td>${person.isAdmin}</td>
                <td>${person.createdDate}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
