<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리별 상품</title>
	<link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet" type="text/css">
	<link rel="shortcut icon" type="image⁄x-icon" href="${pageContext.request.contextPath}/resources/images/stepIcon.png">
</head>
<body>
	<!-- Nav 네비게이션 -->
		<%@ include file="../include/nav.jsp" %>
		
	<!-- first Page -->
    <div id="wrap">
	    <section id="first">
	       <div id="banner">
	           
	       </div>
	        <div id="content">
	            <ul>
	            	<c:forEach items="${list}" var="list">
	            	<li>
	            		<div class="goodsThumb">
	            			<img src="${list.goodsThumbnail}">
	            		</div>
	            		<div class="goodsName">
	            			<a href="/shop/view?n=${list.goodsNum}">${list.goodsName}</a>
	            		</div>
	            	</li>
	            	</c:forEach>
	            </ul>
	        </div>
	    </section>
    </div>
    
    <!-- footer -->
    	<%@ include file="../include/footer.jsp" %>
</body>
</html>