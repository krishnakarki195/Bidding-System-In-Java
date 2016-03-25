<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
  
    
    <div class="formBody">
	<h2>
		<strong>My Bids</strong> <br>
		<em>${save } </em>
	</h2>
	<div class="table">
		<table>
			<tr>
			<th><spring:message code="list.user.sno" /></th>
			<th>Product</th>
			
			<th> Bid Amount</th>
			<th><spring:message code="list.user.delete" /></th>
		</tr>
			<c:forEach items="${bids }" var="bid">
			<tr>
				<td>1</td>
				<td>${bid.product.productName} </td>
				<td>${bid.bidAmount}</td>
				<td>  <a href='<c:url value="/bid/delete/${bid.bidId }"/>'>Delete </a>  </td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>