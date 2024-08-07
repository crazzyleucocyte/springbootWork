<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style>
	body {width:900px; margin:0 auto;}
	table {width:900px;}
</style>
</head>
<body>
	<form action="write" method="post">
	<table class="table">
		<tr>
			<th colspan="2"><h2 align="center"><b>글 작 성</b></h2></th>
		</tr>
		<tr>
			<td width="25%">작성자 : </td>
			<td><input name="writer"  class="form-control" id="exampleFormControlInput1"></td>
		</tr>
		<tr>
			<td>제목 : </td>
			<td><input name="title"  class="form-control" id="exampleFormControlInput1"></td>
		</tr>
			<tr>
				<td>내용 : </td>
				<td>
  					<textarea class="form-control" id="exampleFormControlTextarea1" name="content" cols="100" rows="5"></textarea>
				</td>
			</tr>
		<tr>
			<td colspan="2" align="center">
			<button class="btn btn-outline-primary">글쓰기</button>
			<a href="list"><button type="button" class="btn btn-outline-primary">목록</button></a>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>