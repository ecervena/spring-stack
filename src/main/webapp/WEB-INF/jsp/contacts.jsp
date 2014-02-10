<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<!-- Problem with jquery library as local resource. Servlet configuration for static resources mvc:resources is not recognized in mvc-3.1.xsd -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.7.js"></script>
<script type="text/javascript">
	function loadJSON(id) {
		var uri = "/jpa-spring-springmvc-jquery/servlet/contacts/json/" + id;
		$("#demo").load(uri);
	}

	function loadXML(id) {
		var uri = "/jpa-spring-springmvc-jquery/servlet/contacts/xml/" + id;
		$("#demo").load(uri);

	}
</script>
</head>
<body>
	<h2>Hello Contacts!</h2>
	<div id="contact-data" class="contacts">
		<c:forEach var="contact" items="${contactsModel.contacts}">
			<span class="contact">Hello ${contact.firstName}
				${contact.lastName} <a onclick="loadXML('${contact.id}')"
				href="javascript:void(0)" id="${contact.lastName}-xml">xml</a> <span>/</span>
				<a onclick="loadJSON('${contact.id}')"
				href="javascript:void(0)" id="${contact.lastName}-json">json</a></br>
			</span>
		</c:forEach>
	</div>
	<h2>Response:</h2>
	<textarea id="demo" readonly
		style="margin: 2px; width: 445px; height: 115px;">This is a textarea.</textarea>

	<p>Save a contact, save the world:</p>
	<form action="/jpa-spring-springmvc-jquery/servlet/contacts/save" method="post">
		First Name: <input type="text" name="firstName" id="firstName" /><br>
		Last Name: <input type="text" name="lastName" id="lastName" /><br>
		<input type="submit" value="submit" id="submit" />
	</form>

</body>
</html>
