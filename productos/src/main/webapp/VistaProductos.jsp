<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "java.util.ArrayList"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver Productos</title>
</head>


<body>

<a href="VistaCrearProducto.jsp">CREAR</a>

<table>
	<tbody>
 <c:forEach items="${productos}" var="producto">
	    <tr>
	      <th scope="row">${producto.id}</th>
	      <td>${producto.codigo}</td>
	      <td>${producto.nombre}</td>
	      <td>${producto.cantidad}</td>
	      <td>${producto.precio}</td>
	      <td>${producto.caducidad}</td>
	      <td>${producto.seccion.nombre}</td>
	      </tr>
	  </c:forEach>
	  </tbody>
</table>
</body>
</html>