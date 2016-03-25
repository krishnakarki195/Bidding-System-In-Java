<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="formBody">
	<em> ${save }</em>
	<h2><strong>Add Product Form</strong></h2>
	<form:form commandName="product" enctype="multipart/form-data">
		<div class="row">
			<div class="formLebel">
				<label for="productName"> 
					<spring:message text="Product" code="addProduct.form.productName.label" />
				</label>
			</div>
			<div class="formInput">
				<form:input path="productName" required="required" />
			</div>
			<div class="formError">
				<form:errors path="productName" />
			</div>
		</div>
		
		<div class="row">
			<div class="formLebel">
				<label for="productDescription"> <spring:message text=""
					code="addProduct.form.productDescription.label" />
				</label>
			</div>
			<div class="formInput">
				<form:textarea path="productDescription" required="required" />
			</div>
			<div class="formError">
				<form:errors path="productDescription" />
			</div>
		</div>
		
		
		<div class="row">
			<div class="formLebel">
				<label for="productEndDate"> <spring:message text=""
					code="addProduct.form.productEndDate.label" />
				</label>
			</div>
			<div class="formInput">
				<form:input path="productEndDate" required="required" type="" />
			</div>
			<div class="formError">
				<form:errors path="productEndDate" />
			</div>
		</div>
		
		<div class="row">
			<div class="formLebel">
				<label for="productInitialPrice"> <spring:message text=""
					code="addProduct.form.productInitialPrice.label" />
			</label>
			</div>
			<div class="formInput">
				<form:input path="productInitialPrice" required="required"
					type="number" />
			</div>
			<div class="formError">
				<form:errors path="productInitialPrice" />
			</div>
		</div>
		
		<div class="row">
			<div class="formLebel">
				<label for="productImage"> <spring:message text=""
					code="addProduct.form.productImage.label" />
			</label>
			</div>
			<div class="formInput">
				<form:input path="productImage" required="required" type="file" />
			</div>
			<div class="formError">
				<form:errors path="productImage" />
			</div>
		</div>

		<div class="row">
			<div class="formInput">
				<input type="submit" value="Save">
				<input type="reset" value="Clear">
			</div>
		</div>

	</form:form>
</div>

