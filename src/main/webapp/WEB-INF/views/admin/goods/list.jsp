<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 상품 목록</title>
<style>
	img {width:150px; height:auto;}
</style>
</head>
<body>

	<!-- nav -->
	<%@ include file="../include/nav.jsp" %>
	
	<!--  section -->
	<section id="container">
		<h2>상품 목록</h2>
		<table>
		 <thead>
		  <tr>
		   <th>썸네일</th>
		   <th>이름</th>
		   <th>카테고리</th>
		   <th>가격</th>
		   <th>수량</th>
		  </tr>
		 </thead>
		 <tbody>
		  <c:forEach items="${goodslist}" var="goodslist">
		  <tr>
		   <td><img src="${goodslist.goodsThumbnail}"></td>
		   <td><a href="/admin/goods/view?goodsNum=${goodslist.goodsNum}">${goodslist.goodsName}</a></td>
		   <td>${goodslist.goodsPart}</td>
		   <td>
		   	<fmt:formatNumber value="${goodslist.goodsPrice}" pattern="###,###,###"></fmt:formatNumber>
		   </td>
		   <td>${goodslist.goodsStock}</td>
		  </tr>   
		  </c:forEach>
		 </tbody>
		</table>
	</section>
	
	<!-- footer -->
	<%@ include file="../include/footer.jsp" %>
</body>
</html>