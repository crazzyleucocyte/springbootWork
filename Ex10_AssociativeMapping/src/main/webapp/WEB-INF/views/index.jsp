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
	<form action="minsert" method="post">
		ID : <input name="id"> <br>
		NAME : <input name="name"><br>
		PASSWORD : <input type="password" name="password"><br>
		<button>회원가입</button><br><br>
	</form>
	<hr><br>
	<form action="binsert" method="post">
		제목 : <input name="title"><br>
		내용 : <input name="content"><br>
		<button>게시글 작성</button><br><br>
	</form>
	<hr><br>
	<c:if test="${error eq 22 }">
		error!!!! 존재하지 않는 아이디입니다.
	</c:if>
	<c:if test="${error eq 11 }">
		error!!!! 비밀번호가 다릅니다.
	</c:if>
	<form action ="mupdate" method="post">
		기존 Id : <input name="id"><br>
		바꿀 NAME : <input name="name"><br>
		바꿀 PASSWORD : <input type="password" name="chPWD"><br>
		PASSWORD 재입력 : <input type="password" name="checkPWD"><br>
		<button>입력 완료</button>
	</form>
	
</body>
</html>