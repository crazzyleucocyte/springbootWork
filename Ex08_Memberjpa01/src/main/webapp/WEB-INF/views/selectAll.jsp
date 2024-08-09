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
	<h1>Member JPA #01 - SelectAll</h1>
	<c:choose>
		<c:when test="${empty mList }">
			데이터가 존재하지 않습니다.
		</c:when>
		<c:otherwise>
			<c:forEach var="m" items="${mList }">
			아이디 : ${m.id }<br>
			이름 : ${m.username }<br>
			날짜 : ${m.createDate}<br><br>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>