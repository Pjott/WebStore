<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<form:form method="POST" modelAttribute="newProduct" class="form-horizontal">
			<fieldset>
				<legend>Add new product</legend>
				<div class="form-group">
					
					<div class="row">
						<lable class="control-label col-lg-2" for="productId">Product Id</lable>
						<div class="col-lg-10">
							<form:input id="productId" path="productId" type="text" class="form:input-large"/>
						</div>
					</div>
					
					<div class="row">
						<lable class="control-label col-lg-2" for="name">name</lable>
						<div class="col-lg-10">
							<form:input id="name" path="name" type="text" class="form:input-large"/>
						</div>
					</div>
					
					<div class="row">
						<lable class="control-label col-lg-2" for="unitPrice">unit price</lable>
						<div class="col-lg-10">
							<form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
						</div>
					</div>
					
					<div class="row">
						<lable class="control-label col-lg-2" for="manufacturer">manufacturer</lable>
						<div class="col-lg-10">
							<form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
						</div>
					</div>
					
					<div class="row">
						<lable class="control-label col-lg-2" for="category">category</lable>
						<div class="col-lg-10">
							<form:input id="category" path="category" type="text" class="form:input-large"/>
						</div>
					</div>
					
					<div class="row">
						<lable class="control-label col-lg-2" for="unitsInStock">units in stock</lable>
						<div class="col-lg-10">
							<form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
						</div>
					</div>

				
				<div class="form-group">
					<lable class="control-label col-lg-2" for="description">description</lable>
					<div class="col-lg-10">
						<form:textarea id="description" path="description" rows="2" style="margin-left: -10px"/>
					</div>
				</div>

				
				<div class="form-group">
					<lable class="control-label col-lg-2" for="condition">condition</lable>
					<div class="col-lg-10" >
						<form:radiobutton value="New" path="condition" />New	
						<form:radiobutton value="Old" path="condition"/>Old		
						<form:radiobutton value="Refurbished" path="condition"/>Refurbished
							
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