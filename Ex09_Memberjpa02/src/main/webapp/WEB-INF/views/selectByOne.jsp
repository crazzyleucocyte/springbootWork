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
	<h1>Member JPA #01 - SelectBy${title }</h1>
	<c:choose>
		<c:when test ="${empty member }">
			데이터가 존재하지 않습니다.
		</c:when>
		<c:otherwise>
			아이디 : ${member.id }<br>
			이름 : ${member.username }<br>
			이메일 : ${member.email}<br><br>
		</c:otherwise>
	</c:choose>

</body>
</html>