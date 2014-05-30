<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Customer</title>
</head>
<body>
<f:view>
	<h:form>
	<div>FirstName:<h:inputText value="#{customerController.firstName}" required="true" requiredMessage="First Name is mandatory" id="firstName"/> <h:message for="firstName"/></div>
	<div>LastName:<h:inputText value="#{customerController.lastName}" required="true" requiredMessage="Last Name is mandatory" id="lastName"/> <h:message for="lastName"/></div>
	<div>Phone Number:<h:inputText value="#{customerController.phoneNumber}" required="false"/></div>
	<div>Email:<h:inputText value="#{customerController.email}" required="true" requiredMessage="Email is mandatory" id="email"/> <h:message for="email"/></div>
	<div>Password:<h:inputText value="#{customerController.password}" required="true" requiredMessage="Password is mandatory" validatorMessage="Password: min 6 characters" id="password"><f:validateLength minimum="6"/></h:inputText><h:message for="password"/></div>
	<div>Date Of Birth:<h:inputText value="#{customerController.dateOfBirth}" required="true" requiredMessage="Date of birth is mandatory" id="dateOfBirth"> <f:convertDateTime pattern= "dd-mm-yyyy"/> </h:inputText> <h:message for="dateOfBirth"/></div>
<!-- bla <div>Registration Date:<h:inputText value="#{customerController.registrationDate}" required="true" requiredMessage="Date of registration is mandatory" converterMessage="Data" id="registrationDate"/> <h:message for="registrationDate"/></div>-->	
	<div><h:commandButton value="Submit" action="#{customerController.createCustomer}"/></div>
	</h:form>
	</f:view>
</body>
</html>