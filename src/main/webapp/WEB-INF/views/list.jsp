<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<table border="1" cellpadding="7" cellspacing="0">
	<tr>
		<th>IDX</th>
		<th>NAME</th>
		<th>WRITER</th>
		<th>DESCRIPTION</th>
		<th>IMAGE</th>
		<th>WRIRTEDATE</th>
	</tr>
	<c:forEach var="ls" items="${ list }">
	<tr>
		<th>${ ls.idx }</th>
		<th>${ ls.name }</th>
		<th>${ ls.writer }</th>
		<th>${ ls.description }</th>
<%-- 		<th><img src="/display?name=${ ls.fileName }" style="width :100px; height : 100px;"></th> --%>
		<th>
		<div class="modal hidden">
			<div class="overlay"></div>
			<div class="modal-body">
				<img src='<spring:url value="/image/${ ls.fileName }"></spring:url>' style="width :300px; height : 300px;">			
			</div>
			<button class="closeBtn">닫기</button>
		</div>
			<button class="imgBtn"><img src='<spring:url value="/image/${ ls.fileName }"></spring:url>' style="width :100px; height : 100px;"></button>
		</th>
		<th>${ ls.writeDate }</th>
	</tr>
	</c:forEach>
</table>

<script>
	const closeBtnList = document.querySelectorAll('.closeBtn')
	const imgBtnList = document.querySelectorAll('.imgBtn')
	const modal = document.querySelector('.modal')
	const overlay = document.querySelectorAll('.overlay')

	console.log(closeBtnList)
	console.log(imgBtnList)
	console.log(modal)
	
	imgBtnList.forEach(function(btn){
		btn.onclick = function(event){
			modal.classList.remove('hidden')
		}
	})
	closeBtnList.forEach(function(btn){
		btn.onclick = function(event){
			modal.classList.add('hidden')
		}
	})
</script>
</body>
</html>