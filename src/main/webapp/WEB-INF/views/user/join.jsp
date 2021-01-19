<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet" type="text/css">
	<link rel="shortcut icon" type="image⁄x-icon" href="${pageContext.request.contextPath}/resources/images/stepIcon.png">
<head>
<meta charset="UTF-8">
<title>Healthtory | 회원 가입</title>
</head>
<body>
	<!-- Nav 네비게이션 -->
		<%@ include file="../include/nav.jsp" %>

	<section id="content">
		<form role="form" method="post" autocomplete="off">
		<div class="input_area">
			<label for="userId">아이디</label>
			<input type="text" id="userId" name="userId" placeholder="아이디를 입력해주세요" required="required" />      
		</div>
			  
		<div class="input_area">
			<label for="userPass">패스워드</label>
			<input type="password" id="userPass" name="userPass" required="required" />      
		</div>
			  
		<div class="input_area">
			<label for="userName">닉네임</label>
			<input type="text" id="userName" name="userName" placeholder="닉네임을 입력해주세요" required="required" />      
		</div>
			  
		<div class="input_area">
			<label for="userPhone">연락처</label>
			<input type="text" id="userPhone" name="userPhone" placeholder="연락처를 입력해주세요" required="required" />      
		</div>
		
		<div class="input_area">
			<label for="userEmail">이메일</label>
			<input type="email" id="userEmail" name="userEmail" placeholder="이메일을 입력해주세요" required="required" />      
		</div>
		
		<button type="submit" id="join_btn" name="join_btn">회원가입</button>
		  
		</form>   
	</section>

	<!-- footer -->
    	<%@ include file="../include/footer.jsp" %>
</body>
</html>