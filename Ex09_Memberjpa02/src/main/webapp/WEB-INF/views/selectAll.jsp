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
	<h1>Member JPA #01 - Select${title }</h1>
	<c:choose>
		<c:when test ="${empty list }">
			데이터가 존재하지 않습니다.
		</c:when>
		<c:otherwise>
			<c:forEach var="l" items="${list }">
			아이디 : ${l.id }<br>
			이름 : ${l.username }<br>
			이메일 : ${l.email}<br><br>
			</c:forEach>
		</c:otherwise>
	</c:choose>

</body>
</html>