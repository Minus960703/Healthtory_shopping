<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 상품 등록</title>
<!-- 제이쿼리 -->
<script src='https://code.jquery.com/jquery-3.5.1.min.js'></script>

<!-- 썸머노트 -->
<script src="${pageContext.request.contextPath}/resources/js/summernote/summernote-lite.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/summernote/summernote-lite.css">

<script type="text/javascript">
function uploadImageFile(file, editor) {
	data = new FormData();
	data.append("file", file);
	
	$.ajax({
		data : data,
		type : "POST",
		url : "./imgUpload",	
		dataType:'json',
	    async: true,
		processData: false,		
		contentType: false,				
		success : function(data) {
	    	//항상 업로드된 파일의 url이 있어야 한다.
	    	alert("업로드에 지연시간이 있습니다..");
	    	setTimeout(function(){
	    		   // 1초 후 작동해야할 코드
	    		alert(data.url);
	    		$(editor).summernote('insertImage', data.url);
	    		if(document.getElementById('goodsThumbnail').value=="null"){
	    			document.getElementById('goodsThumbnail').value=data.url;	
	    		}
	    		
	    		   }, 1000);  	
	    	
		},
		error:function(request,status,error){			
			alert("code = "+ request.status);
			alert(" message = " + request.responseText);
			alert(" error = " + error);			 	
			$(editor).summernote('insertImage', '');
		}
	
	});
	}
	
$(document).ready(function() {
	$('#summernote').summernote({
		height: 300,                 // 에디터 높이
		minHeight: null,             // 최소 높이
		maxHeight: null,             // 최대 높이
		focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		lang: "ko-KR",					// 한글 설정
		placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
		callbacks: {	//여기 부분이 이미지를 첨부하는 부분
			onImageUpload : function(files) {
				uploadImageFile(files[0],this);				
			},
			onPaste: function (e) {
				var clipboardData = e.originalEvent.clipboardData;
				if (clipboardData && clipboardData.items && clipboardData.items.length) {
					var item = clipboardData.items[0];
					if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
						e.preventDefault();
					}
				}
			}
		}
});

});
</script>

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
				<option value="strap">스트랩/벨트</option>
			</select> <br /> 
			<label>상품번호</label> 
			<input type="text" name="goodsNum" id="goodsNum" /><br />
			 
			<label>상품이름</label>
			<input type="text" name="goodsName" id="goodsName" /><br />
			
			<label>상품가격</label>
			<input type="text" name="goodsPrice" id="goodsPrice" /><br /> 
			
			<label>상품재고</label>
			<input type="text" name="goodsStock" id="goodsStock" /><br /> 
			
			<label>상품 설명</label>
			<textarea id="summernote" name="goodsImage" class="editordata"></textarea>
			
			<input type="hidden" id="goodsThumbnail" name="goodsThumbnail" value="null"/>
			
			<%=request.getRealPath("/")%>

			<button type="submit">등록</button>
		</form>
	</section>

	<!-- footer -->
	<%@ include file="../include/footer.jsp"%>

</body>
</html>
