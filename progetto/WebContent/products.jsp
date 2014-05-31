<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Product</title>
</head>
<body>
<f:view>
	<h1>Products</h1>
	<h:form>
	<table>
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Action</th>
		</tr>
		<c:forEach var="product" items="#{productController.products}">
			<tr>
				<td><h:commandLink action="#{productController.findProduct}"
						value="#{product.name}">
						<f:param name="id" value="#{product.id}" />
					</h:commandLink></td>
				<td>${product.price}</td>
				<td><h:commandLink action="#{productController.deleteProduct}" value="delete">
				<f:param name="id" value="#{product.id}"/></h:commandLink></td>
			</tr>
		</c:forEach>
	</table>
	</h:form>
	</f:view>
</body>
</html>