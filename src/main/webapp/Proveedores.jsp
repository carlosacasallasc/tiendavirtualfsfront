<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROVEEDORES</title>
</head>
<body>
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

</head>
<body>
	<header>
		<!-- Navbar -->
		<nav class="navbar navbar-expand-lg navbar-light bg-success">
			<div class="collapse navbar-collapse" id="navbar">
				<ul class="navbar-nav">
					<li class="nav-item active"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light" href="ControladorLogin?accion=Menu&menu=Principal">Inicio</a></li>
					<!-- Boton Navbar Inicio  -->
					<li class="nav-item"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light" href="ControladorLogin?accion=Menu&menu=Usuario">Usuarios</a></li>
					<!-- Boton Navbar Usuario  -->
					<li class="nav-item"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light" href="ControladorLogin?accion=Menu&menu=Cliente">Clientes</a></li>
					<!-- Boton Navbar Cliente  -->
					<li class="nav-item"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light" href="ControladorLogin?accion=Menu&menu=Proveedor">Proveedores</a></li>
					<!-- Boton Navbar Proveedor  -->
					<li class="nav-item"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light" href="ControladorLogin?accion=Menu&menu=Productos">Productos</a></li>
					<!-- Boton Navbar Productos  -->
					<li class="nav-item"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light" href="ControladorLogin?accion=Menu&menu=Ventas">Ventas</a></li>
					<!-- Boton Navbar Ventas  -->
					<li class="nav-item"><a
						style="margin-left: 10px; border: none"
						class="btn btn-outline-light" href="ControladorLogin?accion=Menu&menu=Reportes">Reportes</a></li>
					<!-- Boton Navbar Reportes  -->
				</ul>
			</div>
			<!-- Boton salir -->
				<a class="btn btn-outline-light" href="ControladorLogin?accion=Menu&menu=Salir"> Salir</a>
		</nav>
		<!-- Fin Navbar -->
	</header>

	<main class="container-fluid">
		<div class="row mt-5">
			<div class="col-lg-5 col-md-6 col12">
				<div class="card">
					<div class="card-header bg-success text-light">
						<span>Sistema de registro de Proveedores</span>
					</div>
					<div class="card-body">
						<form action="ControladorProveedores" method="GET">
						
							<!-- VALIDACIIONES -->
							<c:if test="${validacion == 0}">
							<div class = "card">
								<div class="card-body bg-danger rounded">
									<h5 class = text-center>Por favor digite el campo NIT</h5>
								</div>
							</div>
							</c:if>	
							<c:if test="${validacion == 1}">
							<div class = "card">
								<div class="card-body bg-danger rounded">
									<h5 class = text-center>Por favor digite todos los campos para agregar el proveedor</h5>
								</div>
							</div>
							</c:if>	
							<c:if test="${validacion == 2}">
							<div class = "card">
								<div class="card-body bg-success rounded">
									<h5 class = text-center>Proveedor creado</h5>
								</div>
							</div>
							</c:if>	
							<c:if test="${validacion == 3}">
							<div class = "card">
								<div class="card-body bg-danger rounded">
									<h5 class = text-center>Ha habido un error :(</h5>
								</div>
							</div>
							</c:if>	
							<c:if test="${validacion == 4}">
							<div class = "card">
								<div class="card-body bg-danger rounded">
									<h5 class = text-center>El proveedor ya existe</h5>
								</div>
							</div>
							</c:if>	
							<c:if test="${validacion == 5}">
							<div class = "card">
								<div class="card-body bg-warning rounded">
									<h5 class = text-center>Proveedor eliminado</h5>
								</div>
							</div>
							</c:if>	
							<c:if test="${validacion == 6}">
							<div class = "card">
								<div class="card-body bg-success rounded">
									<h5 class = text-center>Proveedor Modificado</h5>
								</div>
							</div>
							</c:if>	
							<c:if test="${validacion == 7}">
							<div class = "card">
								<div class="card-body bg-danger rounded">
									<h5 class = text-center>El proveedor no existe no se puede modificar</h5>
								</div>
							</div>
							</c:if>	
							<c:if test="${validacion == 8}">
							<div class = "card">
								<div class="card-body bg-danger rounded">
									<h5 class = text-center>El proveedor no existe</h5>
								</div>
							</div>
							</c:if>	
							<c:if test="${validacion == 9}">
							<div class = "card">
								<div class="card-body bg-danger rounded">
									<h5 class = text-center>Por favor digite todos los campos para actualizar el proveedor</h5>
								</div>
							</div>
							</c:if>	
							
						<!--FIN VALIDACIONES  -->
							<p>
								NIT: <input class="form-control" placeholder="Digite NIT" type="number" name="NIT" value = "${proveedor.getNitproveedor()}">
							</p>
							<p>
								Nombre Proveedor:<input class="form-control" placeholder="Digite Nombre del proveedor" type="text" name="nombreproveedor" id="idNombreProveedor" value = "${proveedor.getNombre_proveedor()}">
							</p>
							<p>
								Ciudad:<input class="form-control" placeholder="Digite ciudad" type="text" name="ciudad" id="idciudad" value = "${proveedor.getCiudad_proveedor()}">
							</p>
							<p>
								Direccion : <input class="form-control" type="address" placeholder="Digite su Direccion "
									name="Direcion" value = "${proveedor.getDireccion_proveedor()}">
							</p>
							<p>
								Telefono: <input class="form-control" type="tel"
									placeholder="Digite su Telefono" name="Tel" value = "${proveedor.getTelefono_proveedor()}">
							</p>
							<div class="d-flex justify-content-between align-items-center"">
								<input type="submit" name="Agregar" value="Agregar" class="btn btn-success btn-sm"> 
								<input type="submit"name="Consultar" value="Consultar" class="btn btn-success btn-sm">
								<input type="submit" name="Eliminar" value="Eliminar" class="btn btn-success btn-sm"> 
								<input type="submit" name="Actualizar" value="Actualizar" class="btn btn-success btn-sm">
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-lg col-mg col-sm col">
				<div class="card-header bg-success text-light d-flex justify-content-between align-items-center">
					<span>Presione para Listar los Proveedores</span>
					<form action="ControladorProveedores" method ="GET">
						<input type="submit" name="Listar_Proveedores" value="Listar_Proveedores" class="btn btn-primary btn-sm">
					</form>
				</div>
				<div class="card-body">
					<table
						class="table bg-light table-bordered table-hover table-stripped">
						<thead>
							<tr>
								<th>NIT</th>
								<th>Nombre_Proveedores</th>
								<th>Ciudad</th>
								<th>Direccion</th>
								<th>Telefono</th>
								<th>Accion</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="provedor" items="${lista}">
								<tr>
									<td>${provedor.getNitproveedor()}</td>
									<td>${provedor.getNombre_proveedor()}</td>
									<td>${provedor.getCiudad_proveedor()}</td>
									<td>${provedor.getDireccion_proveedor()}</td>
									<td>${provedor.getTelefono_proveedor()}</td>
									<td><a class="btn btn-warning" href="ControladorProveedores?editar=editar&id=${provedor.getNitproveedor()}">Editar</a>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
	<!-- Script de bootstrap5  -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous">
		
	</script>
</body>
</html>