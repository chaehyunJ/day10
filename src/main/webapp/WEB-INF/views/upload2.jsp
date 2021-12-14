<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${ pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>파일 업로드2</h2>
<hr>

<form method="POST" enctype="multipart/form-data">
	<p><input name="name" placeholder="Name"></p>
	<p><input name="writer" value="${ login.userid }"></p>
	<p><input type="file" name="uploadFile"></p>
	<textarea name="description" style="width : 300px; height : 200px; resize : none;"></textarea>
	<p><input type="submit" value="제출"></p>
</form>
</body>
</html>