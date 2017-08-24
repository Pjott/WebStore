<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AwsomeWebStore - Products</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
				<p>All the available products in AwsomeWebStore</p>
			</div>
		</div>
	</section>
	
	<section class="container">
		<div class="row">
			<div class="col-sm-6 col-md-3" style="padding-bottom:15px">
				<div class="thumbnail">
					<div class="caption"> 
						<h3>${product.name}</h3>
						<p>${product.description}</p>
						<p>${product.unitPrice} EUR</p>
						<p>There are ${product.unitsInStock} units in stock</p>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>