<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style>
/* body { */
/* 	background-image: */
/* 		url('https://image.freepik.com/vector-gratis/asistencia-sanitaria-medica-color-azul_1017-26800.jpg'); */
/* } */

h3, p {
	color: #;
}
</style>
	<script type="text/javascript" src="./Codigos.js"></script>
</head>
<body>
	<header>
		<!-- Navbar -->
		<nav class="navbar navbar-expand-lg navbar-light bg-success">
			<div class="collapse navbar-collapse" id="navbar">
				<ul class="navbar-nav">
					<li class="nav-item active"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light"
						href="ControladorLogin?accion=Menu&menu=Principal">Inicio</a></li>
					<!-- Boton Navbar Inicio  -->
					<li class="nav-item"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light"
						href="ControladorLogin?accion=Menu&menu=Usuario">Usuarios</a></li>
					<!-- Boton Navbar Usuario  -->
					<li class="nav-item"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light"
						href="ControladorLogin?accion=Menu&menu=Cliente">Clientes</a></li>
					<!-- Boton Navbar Cliente  -->
					<li class="nav-item"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light"
						href="ControladorLogin?accion=Menu&menu=Proveedor">Proveedores</a></li>
					<!-- Boton Navbar Proveedor  -->
					<li class="nav-item"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light"
						href="ControladorLogin?accion=Menu&menu=Productos">Productos</a></li>
					<!-- Boton Navbar Productos  -->
					<li class="nav-item"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light"
						href="ControladorLogin?accion=Menu&menu=Ventas">Ventas</a></li>
					<!-- Boton Navbar Ventas  -->
					<li class="nav-item"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light"
						href="ControladorLogin?accion=Menu&menu=Reportes">Reportes</a></li>
					<!-- Boton Navbar Reportes  -->
				</ul>
			</div>
			<!-- Boton salir -->
			<a class="btn btn-outline-light"
				href="ControladorLogin?accion=Menu&menu=Salir"> Salir</a>
		</nav>
		<!-- Fin Navbar -->
	</header>
	<div class="container-fluid">
		<div class="row mt-5">
			<div class="col">
				<div class="card bg-transparent col-12 border-0">
					<div class="mb-3">
						<!-- Cargar archivo -->
						<form method="post" name="formulario"
							enctype="multipart/form-data">
							<div class="row">
								<div class="col-11">
									<input type="file"
										name="archivo" accept=".csv" class="form-control" id="archivo">
								</div>
								<div class="col-1">
									<input type="submit" value="Procesar" name="Procesar" onclick="cargarArchivo(archivo)" class="btn btn-success aling-center">
								</div>
							</div>
							<input type="hidden" name="nombre" value="">
							<input type="hidden" name="nombre2" value="">
						</form>
					</div>
				</div>
				<div class="container-fluid">
					<div class="row mt-5">
						<div class="col-12">
					<!-- VALIDACIONES -->
						<div class="card bg-transparent border-0">
							<c:choose>
								<c:when test="${error == 0}">
									<div class="card-body bg-danger rounded" >
									<h5 class=text-center>Error: datos inválidos, Revise archivo plano</h5>
								</div>
								</c:when>
								<c:when test="${error == 1}">
									<div class="card-body bg-danger rounded">
									<h5 class=text-center>Error: no se seleccionó archivo para cargar</h5>
								</div>
								</c:when>
								<c:when test="${error == 2}">
									<div class="card-body bg-success rounded">
									<h5 class=text-center>Archivo Cargado Exitosamente</h5>
								</div>
								</c:when>
								<c:when test="${error == 3}">
								<div class="card-body bg-danger rounded">
									<h5 class=text-center>Error: formato de archivo inválido</h5>
								</div>
								</c:when>
								<c:when test="${error == 4}">
								<div class="card-body bg-danger rounded">
									<h5 class=text-center>Algunos registros no se cargaron: por favor revise si añadio el nit en modulo proveedores</h5>
								</div>
								</c:when>
								<c:when test="${error == 5}">
								<div class="card-body bg-danger rounded">
									<h5 class=text-center>Algunos registros no se han cargado</h5>
									<h5 class=text-center>Los productos se han cargado</h5>
									<c:if test="${registros2 != '' }">
										<h5 class=text-center>,los medicamentos con los codigos: "${registros2}" ya existen en la base de datos</h5>
									</c:if>
									<c:if test="${registros == ''}">
										<h5 class=text-center>,los demas registros se cargaron correctamente</h5>
									</c:if>
									<c:if test="${registros != ''}">
										<h5 class=text-center>,hay registros donde el proveedor no existe en base de datos porfavor verifique el modulo proveedores</h5>
										<h5 class=text-center>el proveedor ${registros} no existe</h5>
									</c:if>
								</div>
								</c:when>
							</c:choose>
						</div>
							<iframe name="null" style="display: none;"></iframe>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		<div class="container">
			<div class="row mt-5">
				<div class="col-12"></div>
			</div>
		</div>
	<div class="card">
		<div
			class="card-header bg-success text-light d-flex justify-content-end">
			<form action="ControladorProductos" method = "GET">
				<input type="submit" name="Listar" value="Listar"
					class="btn btn-primary" />
			</form>
		</div>
		<div class="card-body">
			<table
				class="table bg-light table-bordered table-hover table-stripped">
				<thead>
					<tr>
						<th>Codigo producto</th>
						<th>IVA compra</th>
						<th>NIT proveedor</th>
						<th>Nombre producto</th>
						<th>Precio compra</th>
						<th>Precio venta</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="productos" items="${lista}">
						<tr>
							<td>${productos.getCodigoProducto()}</td>
							<td>${productos.getIvaCompra()}</td>
							<td>${productos.getNitProveedor()}</td>
							<td>${productos.getNombreProducto()}</td>
							<td>${productos.getPrecioCompra()}</td>
							<td>${productos.getPrecioVenta()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
	<!-- Script de bootstrap5  -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous">

	</script>
</body>
</html>