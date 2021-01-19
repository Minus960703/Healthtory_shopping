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
            <li><a href="javascript:(0)">menu1</a></li>
            <li><a href="javascript:(0)">menu2</a></li>
            <li><a href="javascript:(0)">menu3</a></li>
            <li><a href="javascript:(0)">menu4</a></li>
            <li><a href="javascript:(0)">menu5</a></li>
        </ul>
       </div>
    </div>