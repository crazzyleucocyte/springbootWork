<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h1>JPA Paging - Name Like Paging</h1>
	총게시글의 갯수 : ${totalRecord}<br>
	총 페이지 수 : ${totalPages }<br>
	한 페이지당 항목 수 : ${size }<br>
	현재 페이지 : ${nowPage+1}<br>
	현재 페이지의 항목 수 : ${numberOfElements }<br>
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