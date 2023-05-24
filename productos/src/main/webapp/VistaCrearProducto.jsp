<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Crear</title>
<style>
form {
	margin: 50px 0 0 50px;
}

option {
	width: 100px;
}
</style>
</head>


<body>

	<c:if test="${error eq true}" var="error">
		<div class="alert alert-danger" role="alert">Has introducido
			algun dato erroneo</div>
	</c:if>
	<form method="GET" action="InsertarProducto">
		<label><input type="number" id="codigo" name="codigo"
			placeholder="codigo" /></label> <br> <br> <label><input
			type="text" id="nombre" name="nombre" placeholder="nombre" /></label> <br>
		<br> <label><input type="number" id="cantidad"
			name="cantidad" placeholder="cantidad" /></label> <br> <br> <label><input
			type="text" id="precio" name="precio" placeholder="precio" /></label> <br>
		<br> <label><input type="date" id="caducidad"
			name="caducidad" placeholder="caducidad" /></label> <br> <br> <label
			for="inputState">nombre_secciones</label> <select id="inputState"
			class="form-control" id="nombre_seccion" name="nombre_seccion">
			<option></option>
			<c:forEach items="${secciones}" var="seccion">
				<option>${seccion.nombre}</option>
			</c:forEach>
		</select>

		<c:forEach items="${supermercados}" var="supermercado">
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="${supermercado.id}"
					id="flexCheckDefault" name="supers"> <label class="form-check-label"
					for="flexCheckDefault">${supermercado.nombre} </label>
			</div>
		</c:forEach>
		<input id="Crear" type="submit" value="CREAR" />


	</form>

</body>
</html>