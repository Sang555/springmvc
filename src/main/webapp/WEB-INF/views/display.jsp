<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="com.packag.mvcemp.model.Employee" %>
<%@page import="java.util.List" %>
<table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Age</th>
            <th>Salary</th>
    
        </tr>
        
 <c:forEach items="${emplist}" var="emp">  
         <tr>
            <td><c:out value="${emp.id}"/></td>
            <td><c:out value="${emp.name}"/></td>
            <td><c:out value="${emp.age}"/></td>
            <td><c:out value="${emp.salary}"/></td>
    
        </tr>
 </c:forEach>
        
        </table>
</body>
</html>