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
	<c:choose>
		<c:when test="${not empty failure }">
			<h1>회원 ${title }에 실패했습니다.</h1>
		</c:when>
		<c:otherwise>
			<h1>회원 ${title } 성공</h1>
			ID : ${member.id }
			NAME : ${member.name }
			생성된 날짜 : ${member.createdAt}
		</c:otherwise>
	</c:choose>
</body>
</html>