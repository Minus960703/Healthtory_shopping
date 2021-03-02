<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
	<div id = "nav">
        <div id="logo">
            <h1>Logo</h1>
        </div>
        <div id="user">
            <ul>
            <c:if test="${user == null}">
                <li><a href="/user/login">Login</a></li>
                <li><a href="/user/join">Join</a></li>
            </c:if>
            <c:if test="${user != null}">
            	<c:if test="${user.grade == 1}">
            		<li><a href="/admin/index">Admin</a></li>
            	</c:if>
            	<li><a href="/user/logout">Logout</a></li>
                <li><a href="/user/mypage">MyPage</a></li>
            </c:if>
            </ul>
        </div>
       <div id="menubar">
        <ul>
            <li><a href="/shop/list?c=protein">프로틴</a></li>
            <li><a href="/shop/list?c=gainer">게이너</a></li>
            <li><a href="/shop/list?c=chicken">닭가슴살</a></li>
            <li><a href="/shop/list?c=shaker">쉐이커</a></li>
            <li><a href="/shop/list?c=starp">스트랩/벨트</a></li>
        </ul>
       </div>
    </div>