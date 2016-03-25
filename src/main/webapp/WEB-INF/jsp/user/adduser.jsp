<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="formBody">
	<em>${save }</em>
	<form:form commandName="user" autocomplete="off">
		<div class="row">
			<div class="formLebel">
				<label for="userName"> <spring:message text=""
						code="addUser.form.userName.label" />
				</label>
			</div>
			<div class="formInput">
				<form:input path="userName" id="username" />
			</div>
			<div class="formError username">
				<form:errors path="userName" />
			</div>
		</div>

		<div class="row">
			<div class="formLebel">
				<label for="userEmail"> <spring:message text=""
						code="addUser.form.userEmail.label" />
				</label>
			</div>
			<div class="formInput">
				<form:input path="userEmail" />
			</div>
			<div class="formError">
				<form:errors path="userEmail" />
			</div>
		</div>

		<div class="row">
			<div class="formLebel">
				<label for="userPassword"> <spring:message text=""
						code="addUser.form.userPassword.label" />
				</label>
			</div>
			<div class="formInput">
				<form:input path="userPassword" type="password" />
			</div>
			<div class="formError">
				<form:errors path="userPassword" />
			</div>
		</div>

		<div class="row">
			<div class="formLebel">
				<label for="password"> <spring:message text=""
						code="adduser.form.userConfirmPassword.label" />
				</label>
			</div>
			<div class="formInput">
				<input type="password" id="password_again" name="password-again"
					>
			</div>
			<div class="formError"></div>
		</div>

		<div class="row">
			<div class="formLebel">
				<label for="userRole"> <spring:message text=""
						code="adduser.form.userRole.label" />
				</label>
			</div>
			<div class="formInput">
				<form:radiobutton path="userRole" value="ROLE_ADMIN"
					 />
				Admin
				<form:radiobutton path="userRole" value="ROLE_USER"
					/>
				User
			</div>
			<div class="formError">
				<form:errors path="userRole" />
			</div>
		</div>

		<div class="row">
			<div class="formLebel"></div>
			<div class="formInput">
				<input type="submit" value="Save"> <input type="reset"
					value="Clear">
			</div>
			<div class="formError"></div>
		</div>

	</form:form>
</div>