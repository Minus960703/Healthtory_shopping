<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 상품 조회</title>
	 <!-- 제이쿼리 -->
	 <script src='https://code.jquery.com/jquery-3.5.1.min.js'></script>
</head>
<body>
	<!-- nav -->
	<%@ include file="../include/nav.jsp" %>

	<!-- main -->
	<section id="container">
		<form role="form" method="post" autocomplete="off" enctype="multipart/form-data">
		
		<input type="hidden" name="goodsNum" value="${goodsView.goodsNum}"/>
			<h2> 상품 등록 </h2><br/>
			<label>분류</label> 
				<span>${goodsView.goodsPart}</span>
			<br/>
			<label>상품 번호</label>
				<span>${goodsView.goodsNum}</span>
			<br/>
			
			<label>상품 이름</label>
				<span>${goodsView.goodsName}</span>
			<br/>
			
			<label>상품 가격</label>
				<fmt:formatNumber value="${goodsView.goodsPrice}" pattern="###,###,###"></fmt:formatNumber>
			<br/>
			
			<label>상품 재고</label>
				<span>${goodsView.goodsStock}</span>
			<br/>
			
			<label>이미지</label>
				<span>${goodsView.goodsImage}"</span>
			<br/>
			
			<label>썸네일</label>
				<span><img src="${goodsView.goodsThumbnail}"/></span>
			<br/>
			
			
			<div class="inputArea">
			 <button type="button" id="modify_Btn" class="btn btn-warning">수정</button>
			 <button type="button" id="delete_Btn" class="btn btn-danger">삭제</button>
			 
			 <script>
			  var formObj = $("form[role='form']");
			  
			  $("#modify_Btn").click(function(){
			   formObj.attr("action", "/admin/goods/modify");
			   formObj.attr("method", "get")
			   formObj.submit();
			  });
			  
			  $("#delete_Btn").click(function(){    
				  var con = confirm("정말로 삭제 하시겠습니까?");	//true, false 반환
				  
				  if(con){
					  formObj.attr("action", "/admin/goods/delete");
					  formObj.submit();
				  }
			  });
			 </script>
			</div>
		</form>
	</section>

	<!-- footer -->
	<%@ include file="../include/footer.jsp" %>
	
</body>
</html>