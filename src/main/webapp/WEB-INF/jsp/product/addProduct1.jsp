<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>

<form:form commandName="product" cssClass="form-horizontal registrationForm"  autocomplete="off"  enctype="multipat/form-data" >

<div class="form-group">
		<label for="productName" class="col-sm-2 control-label"> <spring:message text=""  code="addProduct.form.productName.label"/> </label>
		<div class="col-sm-10">
			<form:input path="productName" cssClass="form-control" required="required" />
			<form:errors path="productName" />
		</div>
	</div>

	<div class="form-group">
		<label for="productDescription" class="col-sm-2 control-label"><spring:message text=""  code="addProduct.form.productDescription.label"/>:</label>
		<div class="col-sm-10">
			<form:input path="productDescription" cssClass="form-control" required="required"/>
			<form:errors path="productDescription" />
		</div>
	</div>

	<div class="form-group">
		<label for="productImage" class="col-sm-2 control-label"><spring:message text=""  code="addProduct.form.productImage.label"/>:</label>
		<div class="col-sm-10">
			<form:input type="file" path="productImage" cssClass="form-control" required="required" />
			<form:errors path="productImage" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="productStartDate" class="col-sm-2 control-label"><spring:message text=""  code="addProduct.form.productStartDate.label"/>:</label>
		<div class="col-sm-10">
			<form:input path="productStartDate" cssClass="form-control" required="required" type="date"/>
			<form:errors path="productStartDate" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="productEndDate" class="col-sm-2 control-label"><spring:message text=""   code="addProduct.form.productEndDate.label"/>:</label>
		<div class="col-sm-10">
			<form:input path="productEndDate" cssClass="form-control" required="required" type="date"/>
			<form:errors path="productEndDate" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="productInitialPrice" class="col-sm-2 control-label"><spring:message text=""  code="addProduct.form.productInitialPrice.label"/>:</label>
		<div class="col-sm-10">
			<form:input path="productInitialPrice" cssClass="form-control" required="required"/>
			<form:errors path="productInitialPrice" />
		</div>
	</div>


	<div class="form-group">

		<div class="col-sm-10">
			<input type="submit" value="Save" class="btn btn-large btn-primary">
		</div>

	</div>



</form:form>

</div>

</body>
</html>