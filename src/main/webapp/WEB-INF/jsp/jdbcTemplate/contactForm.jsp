<%--
  Created by IntelliJ IDEA.
  User: ecervena
  Date: 1/18/14
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Contact details</title>
</head>
<body>

    <h1>Contact details</h1>

    <form:form action="save" method="post" modelAttribute="contact">
        First name:<div><form:input path="firstName" id="firstName" /></div>
        Last name:<div><form:input path="lastName" id="lastName" /></div>
        e-mail:<div><form:input path="email" id="email" /></div>
        <div><input type="submit" value="Save" /></div>
    </form:form>

</body>
</html>
