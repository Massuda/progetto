<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Progetto siw</title>
</head>
<body>
	<f:view>
		<h1>Benvenuti nel nostro sito di ECommerce</h1>
		<ul>
			<li><a href='<c:url value="/faces/loginCustomer.jsp" />'>Login Customer</a></li>
			<li><a href='<c:url value="/faces/newCustomer.jsp" />'>registrazione Customer</a></li>
			<li><a href='<c:url value="/faces/loginAdministrator.jsp" />'>Login	Administrator</a></li>
			<li><h:form>
					<h:commandLink action="#{productController.listProducts}" value="List all Products" />
				</h:form></li>
		</ul>
	</f:view>
</body>
</html>