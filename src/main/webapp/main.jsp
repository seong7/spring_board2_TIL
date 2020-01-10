<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Board 2</title>
</head>
<body>
	<h1>Spring Board 2</h1>
	1. <a href="home">home</a><br/>
	2. <a href="list">list</a><br/>
<pre>

DB 연결 타입 : .xml 사용한 mapper 방식 (springNote2 와 같은 방식)

	개발 순서 

	springBoard2 webapp 생성
	web.xml에 filter 추가
	controller, dto, dao 패키지 생성
	lombok을 pom.xml 추가
	NoteDto.java 생성(lombok 기능 추가)
	JDBC 드라이버를 pom.xml 추가
			repositories (dependencies 위에 추가)
			5개 외부 jar 추가(dependencies 안에 추가)
	IDao.java 생성, IDO.xml 구현
	servlet-context.xml 3개의 요소를 추가		// **** xml mapper 사용할 때 꼭 추가해야함 !!! 
	controller 및 jsp 구현


</pre>

</body>
</html>