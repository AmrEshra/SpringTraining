<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Student</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName" />
		<br>
		Last name: <form:input path="lastName" />
		<br>
		Country: <form:select path="country">
					<form:options items="${countries}" />
				</form:select>
		<br>
		Gender <form:radiobutton path="gender" value="Male" label="Male"/> 
				<form:radiobutton path="gender" value="Female" label="Female"/> 
		<br>
		Skills  <form:checkbox path="skills" value="Java" label="Java"/>
				<form:checkbox path="skills" value="C#" label="C#"/>
				<form:checkbox path="skills" value="PHP" label="PHP"/>
				<form:checkbox path="skills" value="ORACLE" label="ORACLE"/>
		<input type="submit" value="Submit" />

	</form:form>


</body>

</html>


