<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Adding new product</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
				<p>Add new product</p>
			</div>
		</div>
	</section>
	
	<section class="container">
		<form:form method="POST" modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
			<fieldset>
				<legend>Add new product</legend>
				<div class="form-group">
					
					<div class="row">
						<lable class="control-label col-lg-2" for="productId"> <spring:message code="addProductPage.form.productId.label" /> </lable>
						<div class="col-lg-10">
							<form:input id="productId" path="productId" type="text" class="form:input-large"/>
						</div>
					</div>
					
					<div class="row">
						<lable class="control-label col-lg-2" for="name"> <spring:message code="addProductPage.form.name.label" /> </lable>
						<div class="col-lg-10">
							<form:input id="name" path="name" type="text" class="form:input-large"/>
						</div>
					</div>
					
					<div class="row">
						<lable class="control-label col-lg-2" for="unitPrice"> <spring:message code="addProductPage.form.unitPrice.label" /> </lable>
						<div class="col-lg-10">
							<form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
						</div>
					</div>
					
					<div class="row">
						<lable class="control-label col-lg-2" for="manufacturer"> <spring:message code="addProductPage.form.manufacturer.label" /> </lable>
						<div class="col-lg-10">
							<form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
						</div>
					</div>
					
					<div class="row">
						<lable class="control-label col-lg-2" for="category"> <spring:message code="addProductPage.form.category.label" /> </lable>
						<div class="col-lg-10">
							<form:input id="category" path="category" type="text" class="form:input-large"/>
						</div>
					</div>
					
					<div class="row">
						<lable class="control-label col-lg-2" for="unitsInStock"> <spring:message code="addProductPage.form.unitsInStock.label" /> </lable>
						<div class="col-lg-10">
							<form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
						</div>
					</div>

				
				<div class="form-group">
					<lable class="control-label col-lg-2" for="description"> <spring:message code="addProductPage.form.description.label" /> </lable>
					<div class="col-lg-10">
						<form:textarea id="description" path="description" rows="2" style="margin-left: -10px"/>
					</div>
				</div>

				
				<div class="form-group">
					<lable class="control-label col-lg-2" for="condition"> <spring:message code="addProductPage.form.condition.label" /> </lable>
					<div class="col-lg-10" >
						<form:radiobutton value="New" path="condition" /> <spring:message code="addProductPage.form.New.div" /> 	
						<form:radiobutton value="Old" path="condition"/> <spring:message code="addProductPage.form.Old.div" /> 		
						<form:radiobutton value="Refurbished" path="condition"/> <spring:message code="addProductPage.form.Refurbished.div" /> 
							
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="productImage"> <spring:message code="addProduct.form.productImage.label" /> </label>
					<div class="col-lg-10">
						<form:input id="productImage" path="productImage" type="file" class="form:input-large" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value="Add" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>