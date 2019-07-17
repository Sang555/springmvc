<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
register

<form:form action="register" modelAttribute="employee" method="post"> 
Id: <form:input path="id" />  <form:errors path="id" cssClass="error" /> <br>

Name: <form:input path="name" /><form:errors path="name" cssClass="error" />   <br>
Age: <form:input path="age" />  <form:errors path="age" cssClass="error" /> <br>
Salary: <form:input path="salary" /> <form:errors path="salary" cssClass="error" /> <br>
 <input type="submit" value="Submit" />  
</form:form>
</body>
</html>