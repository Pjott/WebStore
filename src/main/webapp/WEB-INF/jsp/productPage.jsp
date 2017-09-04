<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Product</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p><strong>Item Code: </strong><span class="label label warning">${product.productId}</span></p>
				<p><strong>manufacturer</strong>: ${product.manufacturer}</p>
				<p><strong>category</strong>: ${product.category}</p>
				<p><strong>Availble units in stock </strong>: ${product.unitsInStock}</p>
				<h4>${product.unitPrice} EUR</h4>
				<p>
					<a href="#" class="btn btn-warning btn-large">
						<span class="glyphicon-shopping-cart glyphicon"></span> Order Now
					</a>
				</p>
			</div>
		</div>
	</section>
</body>
</html>