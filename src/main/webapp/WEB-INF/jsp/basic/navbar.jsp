<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="header">
	Change Language <a href="?language=en">English</a> |
	<a href="?language=np">Nepali</a>
</div>
<div class="menu">
	<div class="link">
		<a href='<c:url value="/"/>'>Home  </a>
	</div>

	<c:if test="${sessionScope.userRole == 'ROLE_ADMIN' }">
	<div class="link">
		<a href='<c:url value="/user"/>'>User</a>
	</div>
	</c:if>
	<div class="link">
		<a href='<c:url value="/product"/>'>Product</a>
	</div>
	<c:if test="${not empty sessionScope.userRole }">
	<div class="link">
		<a href="<c:url value='/logout' />">Logout</a>
	</div>
	</c:if>
	<c:if test="${empty sessionScope.userRole}">
	<div class="link">
		<a href="<c:url value='/login' />">Login</a>
	</div>
	</c:if>
</div>