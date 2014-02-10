<%--
  Created by IntelliJ IDEA.
  User: ecervena
  Date: 1/19/14
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>List of contacts loaded by jdbcTemplate</title>
</head>
<body>
<h2>Contact list:</h2>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>email</td>
        <td>action</td>
    </tr>
    <c:forEach var="contact" items="${contactList}">
        <tr>
            <td>${contact.id}</td>
            <td>${contact.firstName} ${contact.lastName}</td>
            <td>${contact.email}</td>
            <td><a href="delete/contact?id=${contact.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>

<div class="hyper"><a href="/jpa-spring-springmvc-jquery/servlet/jdbcTemplate/form">new contact</a></div>
<div class="new-button">
    <button met
</div>
</body>
</html>
