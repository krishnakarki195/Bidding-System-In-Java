<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="formBody">

<h2>
		<strong>Products</strong>
	</h2>
	<div class="link" >
		<a href='<c:url value="/product/add"/>'>Add Product</a>
	</div>
<table>
	<tr>
		
		<td><spring:message code="list.product.name"/></td>
		<td><spring:message code="list.product.details"/></td>
		<td><spring:message code="list.product.startdate"/> </td>
		<td><spring:message code="list.product.enddate"/></td>
		<td><spring:message code="list.product.delete"/></td>
		
	</tr>
 <c:forEach items="${ product }" var="products">
	<tr>
		
		<td>${products.productName }</td>
		<td>${products.productDescription }</td>
		<td>${products.productStartDate }</td>
		
		<td>${products.productEndDate }</td>
		<td><a href='<c:url value="/product/delete/${products.id }"/>'> Delete </a></td>
		
	</tr>

</c:forEach>
</table>

</div>