<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Product</title>
</head>
<body>
	<f:view>
	<h:form>
		<h1>Nuovo Prodotto</h1>
		<h1>${productController.product.name}</h1>
		<h2>Details</h2>
		<div>Code: ${productController.product.code}</div>
		<div>Price: ${productController.product.price}</div>
		<div>Description: ${productController.product.description}</div>
	<div>
		<a href='<c:url value="/faces/newProduct.jsp" />'>Insert a new
			product</a>
	</div>
	<div>
		<h:commandLink action="#{productController.listProducts}" value="List all Products" />
	</div>
	</h:form>
	</f:view>
</body>
</html>