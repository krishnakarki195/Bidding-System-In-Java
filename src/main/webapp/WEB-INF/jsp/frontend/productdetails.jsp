<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="formBody">
	<h2>
		<strong>Bid Form</strong>
	</h2>
	<div class="row">
		<div class="product-image">
			<img src="" />
		</div>
		<div class="formLebel">
			<strong>Name:</strong> ${product.productName }
		</div>
		<div class="formLebel">
			<Strong>Description:</Strong>${product.productDescription }
		</div>
		<div class="formLebel">
			<Strong>Product Price :</Strong>${product.productInitialPrice }
		</div>

		<div class="formLebel">
			<Strong>Product End Date:</Strong>${product.productEndDate }
		</div>
	</div>
	<form:form  commandName="bid" method="POST">
		<div class="row">

			<div class="formLebel">
				<label>BId Amount: </label>
				<form:input path="bidAmount" type="number"
					min="${product.productInitialPrice }" />
			</div>
			<div class="formError"></div>
			<div class="formInput">
				<input type="submit" value="Bid" />
			</div>
		</div>
	</form:form>
</div>
