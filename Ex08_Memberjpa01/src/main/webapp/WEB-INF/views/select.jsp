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
	<h1>Member JPA #01 - SelectById</h1>
	<c:choose>
		<c:when test="${empty member }">
			찾을 수 없는 id입니다.
		</c:when>
		<c:otherwise>
			아이디 : ${member.id }<br>
			이름 : ${member.username }<br>
			날짜 : ${member.createDate}<br>
		</c:otherwise>
	</c:choose>
</body>
</html>