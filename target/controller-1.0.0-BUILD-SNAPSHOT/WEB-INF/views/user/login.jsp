<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Healthtory | 로그인</title>
	<link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet" type="text/css">
	<link rel="shortcut icon" type="image⁄x-icon" href="${pageContext.request.contextPath}/resources/images/stepIcon.png">
</head>
<body>
	<!-- Nav 네비게이션 -->
		<%@ include file="../include/nav.jsp" %>
	
	<section id="content">
		<form role="form" method="post" autocomplete="off">
			<div class="input_area">
				<label for="userId">아이디</label>
				<input type="text" id="userId" name="userId" required="required" />      
			</div>
			  
			<div class="input_area">
				<label for="userPass">패스워드</label>
				<input type="password" id="userPass" name="userPass" required="required" />      
			</div>
			       
			<button type="submit" id="login_btn" name="login_btn">로그인</button>
			  
			<c:if test="${msg == false}">
				<p style="color:#f00;">로그인에 실패했습니다.</p>
			</c:if>
		  
		</form>   
	</section>
	
	<!-- footer -->
    	<%@ include file="../include/footer.jsp" %>
</body>
</html>