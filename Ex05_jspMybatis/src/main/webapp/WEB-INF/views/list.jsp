<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style>
	body {width:800px; margin:0 auto;}
	a {text-decoration:none; cursor:pointer; color:black;}
	.alignRight{text-align:right;}
</style>
</head>
<body>
		<br>
		<h1 align="center">게 시 판</h1>
		<p class="alignRight">총 레코드수 : ${totalRecord }</p>
		<table class="table table-hover">
			<tr align="center">
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="l" items="${RecordList }">
				<tr align="center">
					<td>${l.boardno }</td>
					<td><a href="detail?boardno=${l.boardno }">${l.title }</a></td>
					<td>${l.writer }</td>
					<td><a href="delete?boardno=${l.boardno }"><button class="btn btn-outline-warning">삭제</button></a></td>
				</tr>
			</c:forEach>
			
		</table>
		<p align="right"><a href="writerForm"><button type="button" class="btn btn-outline-primary">글작성</button></a></p>
</body>
</html>