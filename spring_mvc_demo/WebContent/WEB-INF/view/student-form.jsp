<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

	<style>
		.error {color:red}
	</style>
<head>
<title>Student</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName" />
		<form:errors path="firstName" cssClass="error"/>
		<br>
		Last name (*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error"/>
		<br>
		Age : <form:input path="age" />
		<form:errors path="age" cssClass="error"/>
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
		<br>
		Course name: <form:input path="course" />
		<form:errors path="course" cssClass="error"/>
		<br>
	</form:form>


</body>

</html>


