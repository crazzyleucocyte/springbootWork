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
	<c:if test="${param.error !=null }">
		LoginError!!!!! <br>
		${error_msg }
	</c:if>
	<!-- springboot security에서 기본적으로 아이디를 아이디라고 하지 않고 username라고 하기때문에 input name에 uesername이라고 해야한다 -->
	<form action="login_check" method="post">
		ID : <input name="username"><br>
		PW : <input name="pwd"><br>
		<input type="submit" value="LOGIN">
	</form>	

</body>
</html>