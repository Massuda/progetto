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
<title>Address</title>
</head>
<body>
	<f:view>
	<h:form>
		<h1>Nuovo Indirizzo</h1>
		<h1>${addressController.address.street}</h1>
		<h2>Details</h2>
		<div>City: ${addressController.address.city}</div>
		<div>State: ${addressController.address.state}</div>
		<div>Zipcode: ${addressController.address.zipcode}</div>
		<div>Country: ${addressController.address.country}</div>
	<div>
		<a href='<c:url value="/faces/newAddress.jsp" />'>Insert a new product</a>
	</div>
	<div>
		<h:commandLink action="#{addressController.listAddresses}" value="List all Addresses" />
	</div>
	</h:form>
	</f:view>
</body>
</html>