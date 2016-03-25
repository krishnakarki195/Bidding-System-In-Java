<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="formBody">
	<h2>
		<strong>Users</strong>
	</h2>
	<div class="link" >
		<a href='<c:url value="/user/add"/>'>Add User</a>
	</div>
	<div class="table">
		<table>
			<tr>
			<th><spring:message code="list.user.sno" /></th>
			<th><spring:message code="list.user.name" /></th>
			<th><spring:message code="list.user.email" /></th>
			<th><spring:message code="list.user.edit" /></th>
			<th><spring:message code="list.user.delete" /></th>
		</tr>
			<c:forEach items="${ users }" var="user">
			<tr>
				<td>1</td>
				<td>${user.userName }</td>
				<td>${user.userEmail }</td>
				<td>${user.id }</td>
				<td><a href='<c:url value="/user/delete/${user.id }"/>'>Delete </a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>