<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="GET" action="InsertarProducto">
							<label><input  type="number" id="codigo" name="codigo"
								placeholder="codigo" /></label> <br> <br> 
								<label><input type="text" id="nombre" name="nombre" 
								placeholder="nombre" /></label>
							<br> <br> <label><input type="number"
								id="cantidad" name="cantidad" placeholder="cantidad" /></label> <br>
							<br> <label><input type="number" id="precio"
								name="precio" placeholder="precio" /></label> <br> <br>
							<label><input type="date" id="caducidad"
								name="caducidad" placeholder="caducidad" /></label> <br> <br>
							<input id="Crear" type="submit" value="CREAR" />

	</form>
</body>
</html>