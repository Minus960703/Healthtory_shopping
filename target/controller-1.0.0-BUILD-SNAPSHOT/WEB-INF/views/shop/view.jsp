<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 제이쿼리 -->
<script src='https://code.jquery.com/jquery-3.5.1.min.js'></script>

	<script>
			function commentList(){
	        			var goodsNum = ${view.goodsNum};
	        			$.getJSON("/shop/view/commentList" + "?n=" + goodsNum, function(data){
	        				var str ="";
	        				
	        				$(data).each(function(){
	        					console.log(data);
	        					
	        					var comDate = new Date(this.comDate);
	        					comDate = comDate.toLocaleDateString("ko-US")
	        					
	        					str +="<li data-goodsNum='" + this.goodsNum +"'>"
		        				     + "<span class='userName'>" + this.userName + "</span>"
		        				     + "<span class='date'>" + comDate + "</span>"
		        				     + "<div class='comCon'>" + this.comCon + "</div>"
		        				     + "</li>";           
	        				  	});
	        				  
	        				  $("section.commentList ol").html(str);
	        				 });
			}
	   </script>
</head>
<body>
	<!-- Nav 네비게이션 -->
		<%@ include file="../include/nav.jsp" %>
		
	<!-- first Page -->
    <div id="wrap">
	    <section id="first">
	       <div id="banner">
	           
	       </div>
	       <form role="form" method="post">
	       	<input type="hidden" name="goodsNum" value="${view.goodsNum}" />
	       </form>
	        <div id="content">
	            <div class="Thumb">
	            	<img src="${view.goodsThumbnail}"/>
	            </div>
	            <p>
	            	상품 이름 : ${view.goodsName}
	            </p>
	            <p>
	            	상품 가격 : ${view.goodsPrice}
	            </p>
	            <p>
	            	상품 수량 : ${view.goodsStock}
	            </p>
	            
	            <p>
	            	구입 수량 :
	            	<button type="button" class="add">+</button> 
	            	<input type="number" class="num" min="1" max="${view.goodsStock}" value="1" />
	            	<button type="button" class="subtract">-</button>
	            	
	            	<script>
	            		$(".add").click(function(){
	            		   var num = $(".num").val();
	            		   var addNum = Number(num) + 1;
	            		   
	            		   if(addNum >= ${view.goodsStock}) {
	            		    $(".num").val(num);
	            		   } else {
	            		    $(".num").val(addNum);          
	            		   }
	            		  });
	            		  
	            		  $(".subtract").click(function(){
	            		   var num = $(".num").val();
	            		   var subtractNum = Number(num) - 1;
	            		   
	            		   if(subtractNum <= 0) {
	            		    $(".num").val(num);
	            		   } else {
	            		    $(".num").val(subtractNum);          
	            		   }
	            		  });
	            	</script>
	            </p>
	            
	            <p>
	            	<button type="button">장바구니 추가</button>
	            </p>
	            <p>
	            	상품 설명 : ${view.goodsImage}
	            </p>
	        </div>
	        <div id="comment">
	        	<c:if test="${user == null}">
	        		<p>소감을 남기시려면 <a href="/user/login">로그인</a>해주세요</p>
	        	</c:if>
	        	
	        	<c:if test="${user != null}">
	        	<section class="commentForm">
	        		<form role="form" method="post" autocomplete="off">
	        			<input type="hidden" name="goodsNum" id="goodsNum" value="${view.goodsNum}"/>
	        			<textarea name="comCon" id="comCon"></textarea>
	        			<button type="button" id="comment_btn">댓글 등록</button>
	        			
	        			<script>
	        				$("#comment_btn").click(function(){
	        					var formObj = $(".commentForm form[role='form']");
	        					  var goodsNum = $("#goodsNum").val();
	        					  var comCon = $("#comCon").val()
	        					  
	        					  var data = {
	        					    goodsNum : goodsNum,
	        					    comCon : comCon
	        					    };
	        					  
	        					  $.ajax({
	        					   url : "/shop/view/commentregist",
	        					   type : "post",
	        					   data : data,
	        					   success : function(){
	        					    commentList();
	        					    $("#comCon").val("");
	        					   }
	        					  });
	        					 });
	        			</script>
	        		</form>
	        	</section>
	        	</c:if>
	        	<section class="commentList">
	        		<ol>
	        			<!-- 
	        			<c:forEach items="${comment}" var="comment">
	        			<li>
	        				<p class="userName">${comment.userName}</p>
	        				<p class="date"><fmt:formatDate value="${comment.comDate}" pattern="yyyy-MM-dd"/></p>
	        				<p class="comCon">${comment.comCon}</p>
	        			</li>
	        			</c:forEach>
	        			 -->
	        		</ol>
	        		
	        		<script>
	        			commentList();
	        		</script>
	        		
	        	</section>
	        </div>
	       
	    </section>
    </div>
    
    <!-- footer -->
    	<%@ include file="../include/footer.jsp" %>

</body>
</html>