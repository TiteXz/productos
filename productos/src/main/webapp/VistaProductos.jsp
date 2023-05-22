<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "java.util.ArrayList"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Ver Productos</title>
<style>
body{
	margin: 50px 0 0 50px;
}
</style>
</head>


<body>
<c:if test="${error eq true}" var="error">
	<div class= "alert alert-danger" role="alert"> <h2> Has introducido algun dato erroneo</h2>
	<ul>
	<a>Podría ser:</a>
	<li>El codigo ya existe</li>
	<li>El precio es negativo</li>
	<li>La cantidad es es negativa</li>
	<li>La caducidad es anterior al día de hoy</li>
	</ul>
	</div>
	</c:if>
<a href="FormularioInsertar">CREAR</a>

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
	      <td><a href="FormularioModificar?codigo=${producto.codigo}">Modificar</a></td>
	      </tr>
	  </c:forEach>
	  </tbody>
</table>
</body>
</html>