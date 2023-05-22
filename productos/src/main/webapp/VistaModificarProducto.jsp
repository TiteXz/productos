<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Modificar</title>
<style>
form{
	margin: 50px 0 0 50px;
}

select{
	width:100px;
}
</style>
</head>
<body>


	<form method="GET" action="modificarProducto">
							<label><input  type="number" id="codigo" name="codigo"
								value="${producto.codigo}" /></label> <br> <br> 
								<label><input type="text" id="nombre" name="nombre" 
								value="${producto.nombre}" /></label>
							<br> <br> <label><input type="number"
								id="cantidad" name="cantidad" value="${producto.cantidad}" /></label> <br>
							<br> <label><input type="number" id="precio"
								name="precio" value="${producto.precio}" /></label> <br> <br>
							<label><input type="date" id="caducidad"
								name="caducidad" value="${producto.caducidad}" /></label> <br> <br>
								<label for="inputState">nombre_secciones</label>
                    <select id="inputState" class="form-control" id="nombre_seccion" name="nombre_seccion">
                      <option>${producto.seccion.nombre}</option>
                       <c:forEach items="${secciones}" var="seccion">
                        <option>${seccion.nombre}</option>
                        </c:forEach>
                    </select>
							<input id="Modificar" type="submit" value="Modificar" />
							

	</form>

</body>
</html>