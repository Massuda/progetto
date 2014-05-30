<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer</title>
</head>
<body>
	<f:view>
	<h:form>
		<h1>${customerController.customer.firstName}</h1>
		<h2>Details</h2>
		<div>LastName: ${customerController.customer.lastName}</div>
		<div>Phone Number: ${customerController.customer.phoneNumber}</div>
		<div>Email: ${customerController.customer.email}</div>
		<div>Date Of Birth: ${customerController.customer.dateOfBirth}</div>
		<div>Registration Date:
			${customerController.customer.registrationDate}</div>
	
	<div>
		<a href='<c:url value="/faces/index.jsp" />'>Home</a>
	</div>
	<div>
		<h:commandLink action="#{customerController.listOrders}" value="List of all your orders"/>
	</div>
	</h:form>
	</f:view>
</body>
</html>