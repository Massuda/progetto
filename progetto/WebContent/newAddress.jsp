<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New Address</title>
</head>
<body>
	<f:view>
		<h:form>
			<div>
				Street:
				<h:inputText value="#{addressController.street}" required="true"
					requiredMessage="Street is mandatory" id="street" />
				<h:message for="street" />
			</div>
			<div>
				City:
				<h:inputText value="#{addressController.city}" required="true"
					requiredMessage="City is mandatory" id="city" />
				<h:message for="city" />
			</div>
			<div>
				State:
				<h:inputText value="#{addressController.state}" required="true"
					requiredMessage="State is mandatory" id="state" />
				<h:message for="state" />
			</div>
			<div>
				Zipcode:
				<h:inputText value="#{addressController.zipcode}" required="true"
					requiredMessage="Zipcode is mandatory"
					converterMessage="Zipcode must be a number" id="zipcode" />
				<h:message for="zipcode" />
			</div>
			<div>
				Country:
				<h:inputText value="#{addressController.country}" required="true"
					requiredMessage="Country is mandatory" id="country" />
				<h:message for="country" />
			</div>
			<div>
				<h:commandButton value="Submit"
					action="#{addressController.createAddress}" />
			</div>
		</h:form>
	</f:view>
</body>
</html>
