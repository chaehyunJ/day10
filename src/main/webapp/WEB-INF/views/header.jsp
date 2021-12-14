<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${ pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	ul{
		list-style: none;
		display : flex;
	}
	li{
		width : 120px;
	}
	a{
		text-decoration: none;
		color : inherit;
	}
	a:hover{
		color : green;
	}
	.hidden {
		display : none;
	}
	.model{
		position: fixed;
		top : 0;
		left : 0;
		width : 100%;
		height : 100%;
		text-align: center;
	}
	.model-body{
		width : 700px;
		height : 700px;
		border : 1px solid white;
		border-radius: 10px;
	}
	.overlay{
		background-color: rgba(0,0,0,0.5);
		width : 100%;
		height : 100%;
		position: absolute;
		z-index: -5;
	}
</style>
</head>
<body>

<h2>이미지 게시판</h2>

<ul>
	<li><a href="${ cpath }/list">게시판</a></li>
	<li><a href="${ cpath }/upload2">목록 추가</a></li>
	<c:if test="${ empty login }">
		<li><a href="${ cpath }/login">로그인</a></li>	
	</c:if>
	<c:if test="${ not empty login }">
		<li><a href="${ cpath }/logout">로그아웃</a></li>
	</c:if>
</ul>