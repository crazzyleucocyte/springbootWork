<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Project and External Dependencies에 해당 파일 안에 있는 resources가 root경로임 -->
<!-- 이렇게 그래들에 링크해주고 project and External Dependencies에 있는 파일로 링크를 걸어준다. -->
<!-- dependency에 다운이 되어있기 때문에 인터넷 연결이 없어도 실행이 됟다. -->
<link href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
<script src="/webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>

</head>
<body>
	<br><br>
	<div align="center">
		<button type="button" class="btn btn-outline-primary">Primary</button>
		<button type="button" class="btn btn-outline-secondary">Secondary</button>
		<button type="button" class="btn btn-outline-success">Success</button>
		<button type="button" class="btn btn-outline-danger">Danger</button>
		<button type="button" class="btn btn-outline-warning">Warning</button>
		<button type="button" class="btn btn-outline-info">Info</button>
		<button type="button" class="btn btn-outline-light">Light</button>
		<button type="button" class="btn btn-outline-dark">Dark</button>
	</div>
</body>
</html>