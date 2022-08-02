<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8"/>
</head>

<body>
	<h2>Hello World!</h2>
	<button id="btn">AJAX!</button>
<%--	<c:set var="txt">JSTL</c:set>
	${txt }  --%>
	
	<h2>student</h2>
	<ul>
		<li><a href="${pageContext.request.contextPath }/student/studentEnroll.do">학생등록</a></li>
		<li><a href="${pageContext.request.contextPath }/student/selectOne.do">한건검색</a></li>
	</ul>
	
	<script src="${pageContext.request.contextPath }/js/jquery-3.6.0.js"></script>
	<script>
	document.querySelector("#btn").addEventListener('click',(e)=>{
		$.ajax({
			url:"${pageContext.request.contextPath}/helloworld",
			success(response){
				console.log(response);
			},
			error:console.log
		});
	});
	</script>
	
</body>
</html>
