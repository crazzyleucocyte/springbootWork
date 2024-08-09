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
	<h1>Member JPA #01 - Delete</h1>
	<c:choose>
		<c:when test="${empty rMember }">
			데이터 삭제에 실패했습니다.
		</c:when>
		<c:otherwise>
			아이디 : ${rMember.id }<br>
			이름 : ${rMember.username }<br>
			날짜 : ${rMember.createDate}<br>
		</c:otherwise>
	</c:choose>
</body>
</html>