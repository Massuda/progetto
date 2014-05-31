<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer's orders</title>
</head>
<body>
	<f:view>
		<h1>${customerController.customer.firstName}'s orders</h1>
		<h:form>
			<table>
				<tr>
					<th>Id</th>
					<th>CreationTime</th>
					<th>CloseTime</th>
					<th>SpedictionTime</th>
					<th>Action</th>
				</tr>
				<c:forEach var="order" items="#{customerController.orders}">
					<tr>
						<td><h:commandLink action="#{orderController.findOrder}"
								value="#{order.id}">
								<f:param name="id" value="#{order.id}" />
							</h:commandLink></td>
						<td><h:commandLink action="#{orderController.findOrder}"
								value="#{order.creationTime}">
								<f:param name="id" value="#{order.id}" />
							</h:commandLink></td>
						<td><h:commandLink action="#{orderController.findOrder}"
								value="#{order.closeTime}">
								<f:param name="id" value="#{order.id}" />
							</h:commandLink></td>
						<td><h:commandLink action="#{orderController.findOrder}"
								value="#{order.spedictionTime}">
								<f:param name="id" value="#{order.id}" />
							</h:commandLink></td>
						<td><h:commandLink
								action="#{orderController.closeOrder}" value="close order">
								<f:param name="id" value="#{order.id}" />
							</h:commandLink></td>
					</tr>
				</c:forEach>
			</table>
		</h:form>
	</f:view>
</body>
</html>