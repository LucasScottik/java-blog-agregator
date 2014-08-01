<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form commandName="user" cssClass="form-horizontal">
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name:</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Email:</label>
		<div class="col-sm-10">
			<form:input path="email" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Password:</label>
		<div class="col-sm-10">
			<form:input path="password" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Password:</label>
		<div class="col-sm-10">
			<input type="submit" value="Save" class="btn btn-lrg btn-primary"/>
		</div>
	</div>
</form:form>
