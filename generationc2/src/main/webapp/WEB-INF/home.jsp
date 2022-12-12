<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">

<link href="Assets/css/styles.css" rel="stylesheet">
<style>
</style>
</head>

<body>
	<div class="container">
		<!--Navegación-->
		<nav class="navbar navbar-expand-lg bg-nav">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Navbar</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Dropdown </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Action</a></li>
								<li><a class="dropdown-item" href="#">Another action</a></li>
								<li>
									<hr class="dropdown-divider">
								</li>
								<li><a class="dropdown-item" href="#">Something else
										here</a></li>
							</ul></li>
						<li class="nav-item"><a class="nav-link disabled">Disabled</a>
						</li>
					</ul>
					<form class="d-flex" role="search" action="home/nav" method="post">
						<input class="form-control me-2" type="search" name= "marca" placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>
		</nav>


		<div>
			<h1>Hello World!</h1>

		<form action="/home" method="post">
			<label for="autoSeleccionado" class="form-label">Autos</label> <select
				class="form-select" aria-label="Lista de autos"
				name="autoSeleccionado" id="autoSeleccionado">
				<option value="0" selected>Seleccione su auto</option>
				<c:forEach items="${listaSelectAutos}" var="auto"> <!--Con este item solo se muestra la lista al seleccionar un valor-->
					<!-- agregamos de manera dinamica los elementos del select -->
					<option value="${auto.id}">${auto.marca} - ${auto.color}</option>
				</c:forEach>
			</select>
			<!-- 
			0.- JSP agregar el formulario con el select y el boton submit.
			1.- capturar en el controlador el id del auto
			2.- llamar al service pasando el id capturado
			3.- llamar al repository con el id capturado
			4.- repository retorna el auto filtrado
			5.- service retorna al controlador el auto filtrado
			6.- controlador retorna al JSP el auto 
			7.- JSP muestra en la table solo el auto filtrado
			-->
			<br>
			 <button type="submit" class="btn btn-outline-secondary">Buscar Auto</button>
			</form>
			<br> <br>
			<h2>Lista de autos</h2>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Marca</th>
						<th scope="col">Color</th>
						<th scope="col">USUARIO</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="auto" items="${autos}">
						<!-- agregamos de manera dinamica los elementos del select -->
						<tr>
							<td>${auto.id}</td>
							<td>${auto.marca}</td>
							<td>${auto.color}<!--Al estar dentro de un forEach, no es necesario agregar el (c:out)--></td>
							<td>${auto.usuario.nombre} ${auto.usuario.apellido}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>

		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>

</html>