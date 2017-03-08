<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>People Filtered</title>
</head>


<body>





<c:if test="${!empty listPeople}">
    <table class="tg">
        <tr>
            <th width="80">Id</th>
            <th width="120">Name</th>
            <th width="120">Age</th>
            <th width="120">IsAdmin</th>
            <th width="120">CreatedDate</th>
        </tr>
        <c:forEach items="${listPeople}" var="person">
            <tr>
                <td>${person.id}</td>
                <td>${person.name}</td>
<%--                <td><a href="/persondata/${person.id}" target="_blank">${person.name}</a></td>--%>
                <td>${person.age}</td>
                <td>${person.isAdmin}</td>
                <td>${person.createdDate}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>



</body>
</html>
