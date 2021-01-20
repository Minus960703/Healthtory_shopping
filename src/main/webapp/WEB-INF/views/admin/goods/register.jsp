<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 상품 등록</title>
<!-- 제이쿼리 -->
<script src='https://code.jquery.com/jquery-3.5.1.min.js'></script>
</head>
<body>
	<!-- nav -->
	<%@ include file="../include/nav.jsp"%>

	<!-- main -->
	<section id="container">
		<form role="form" method="post" autocomplete="off"
			enctype="multipart/form-data">
			<h2>상품 등록</h2>
			<br /> <label>분류</label> <select name="goodsPart" id="goodsPart">
				<option value="protein">프로틴</option>
				<option value="gainer">게이너</option>
				<option value="chicken">닭가슴살</option>
				<option value="shaker">쉐이커</option>
				<option value="strap">스트랩</option>
				<option value="belt">리프팅벨트</option>
			</select> <br /> 
			<label>상품번호</label> 
			<input type="text" name="goodsNum" id="goodsNum" /><br />
			 
			<label>상품이름</label>
			<input type="text" name="goodsName" id="goodsName" /><br />
			
			<label>상품가격</label>
			<input type="text" name="goodsPrice" id="goodsPrice" /><br /> 
			
			<label>상품재고</label>
			<input type="text" name="goodsStock" id="goodsStock" /><br /> 
			
			<label>이미지</label>
			<input type="file" id="goodsImage" name="file" />
			<div class="select_img">
				<img src="" />
			</div>

			<script>
				$("#goodsImage").change(
						function() {
							if (this.files && this.files[0]) {
								var reader = new FileReader;
								reader.onload = function(data) {
									$(".select_img img").attr("src",
											data.target.result).width(500);
								}
								reader.readAsDataURL(this.files[0]);
							}
						});
			</script>

			<%=request.getRealPath("/")%>

			<button type="submit">등록</button>
		</form>
	</section>

	<!-- footer -->
	<%@ include file="../include/footer.jsp"%>

</body>
</html>
