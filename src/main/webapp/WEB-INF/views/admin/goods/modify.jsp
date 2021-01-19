<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 상품수정</title>
	<!-- 제이쿼리 -->
	 <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
</head>
<body>
	<!-- nav -->
	<%@ include file="../include/nav.jsp" %>

	<!-- main -->
	<section id="container">
		<form role="form" method="post" autocomplete="off">
			<input type="hidden" name="goodsNum" value="${goods.goodsNum}">
			<h2> 상품 수정 </h2><br/>
			<label>분류</label> 
			<select name="goodsPart" id="goodsPart">
				<option value="protein">프로틴</option>
				<option value="gainer">게이너</option>
				<option value="chicken">닭가슴살</option>
				<option value="shaker">쉐이커</option>
				<option value="strap">스트랩</option>
				<option value="belt">리프팅벨트</option>
			</select>
			<br/>
			<label>상품번호</label>
			<input type="text" name="goodsNum" id="goodsNum" value="${goods.goodsNum}" readonly="true"/><br/>
			
			<label>상품이름</label>
			<input type="text" name="goodsName" id="goodsName" value="${goods.goodsName}"/><br/>
			
			<label>상품가격</label>
			<input type="text" name="goodsPrice" id="goodsPrice" value="${goods.goodsPrice}"/><br/>
			
			<label>상품재고</label>
			<input type="text" name="goodsStock" id="goodsStock" value="${goods.goodsStock}"/><br/>
			
			<button type="submit" id="update_Btn">완료</button>
			<button type="button" id="back_Btn">취소</button>
			<script>
				$("#back_Btn").click(function(){
					location.href = "/admin/goods/view?goodsNum=" + ${goods.goodsNum};
				});
			</script>
		</form>
	</section>

	<!-- footer -->
	<%@ include file="../include/footer.jsp" %>
</body>
</html>