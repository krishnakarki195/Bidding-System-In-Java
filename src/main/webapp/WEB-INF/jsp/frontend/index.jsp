<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="product-list">
	<c:forEach items="${product }" var="products">
		<div class="product">
			<div class="product-image">
				<img src='<c:url value="/resources/images/${products.imagePath }.png"/>' alt="Product Image" />
			</div>
			<div class="product-name">
				<strong>Name:</strong>${products.productName }
			</div>
			<div class="product-description">
				<strong>Description:</strong> <p> ${products.productDescription } </p>
			</div>
			<div class="product-initial-price">
				<strong>Initial Price:</strong>${products.productInitialPrice }
			</div>
			<div class="product-end-date">
				<strong>Product Bit End Date:</strong> ${products.productEndDate }
			</div>
			<div class="product-bit-now">
				<a href='<c:url value="/bid/details/${products.id }"/>'>Bid Now</a>
			</div>
		</div>
	</c:forEach>

</div>
