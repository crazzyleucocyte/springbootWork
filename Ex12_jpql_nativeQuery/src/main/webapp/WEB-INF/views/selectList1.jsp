<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JPQL - Name Like</title>
</head>
<body>
	<h1>JPQL - Name Like</h1>
	<div align="center">
	
	<table width="800px">
		<tr>
			<th width="25%">ID</th>
			<th width="50%">EMAIL</th>
			<th width="25%">NAME</th>
		</tr>
		<c:forEach var="l" items="${members }">
			<tr align="center">
				<td>${l.id }</td>
				<td>${l.email }</td>
				<td>${l.name }</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	
</body>
</html>