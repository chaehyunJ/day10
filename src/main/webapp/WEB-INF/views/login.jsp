<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<form method="POST">
	<p><input name="userid" placeholder="ID" required autofocus></p>
	<p><input type="password" name="userpw" placeholder="PW" required></p>
	<p>
		<label><input type="checkbox" name="saveid" ${  empty cookie.save ? '' : 'checked' }>ID저장</label>
		<label><input type="checkbox" name="auto">자동로그인</label>
	</p>
	<p><input type="submit" value="로그인"></p>
</form>
</body>
</html>