<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registro</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<div class="card">
		<div class="card-body">
			<!--action= ruta donde se envian los parametros-->
			<!--Dos tipos de metodos: get y post-->
			<!--get muestra los parametros-->
			<!--post envia los parametros ocultos-->
			<form action="/registro/formulario" method="post">
			<label for="nombre" class="form-label"> Nombre: </label>
			<input type="text" id="nombre" name="nombre" class="form-control">
			<!--Las etiquetas de tipo input se le debe agregar un identificador unico (id)-->
			<!--el (name) sirve para capturar y traspasar la informacion hacia el backend, también debe ser único-->
			<br>
			<label for="apellido" class="form-label">Apellido:</label> 
			<input type="text" id="apellido" name="apellido" class="form-control">
			<br>
			<label for="nick" class="form-label">Nick:</label> 
			<input type="text" id="nick" name="nick" class="form-control">
			<br> 
			<label for="correo" class="form-label"> Email:</label>
			<input type="email" id="correo" name="correo" class="form-control">
			<!--Existe un tipo email que reconoce el formato del correo-->
			<br>
			<label for="pass" class="form-label"> Password</label>
			<input type="password" id="pass" name="pass" class="form-control" placeholder="Ingrese password">
			<label for="pass2" class="form-label">Confirme Password</label>
			<input type="password" id="pass" name="pass2" class="form-control" placeholder="Ingrese password">
			<br> 
			<input type="submit" class="btn btn-primary" value="Enviar">
			</form>
		</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>