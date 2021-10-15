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
	<main class = "container-fluid">
		<div class = "row mt-5">
			<div class="col-lg-5 col-md-6 col12">
				<div class = "card">
					<div class = "card header bg-success text-light">
						<span class = "text-center">Datos del Cliente</span>
					</div>
					<div class = "card-body ">
					
						<form action="ControladorVentas" method = "POST">          <!-- Primer formulario CLIENTE-->
							<div class = "row">
								<label class = "col-form-label">Cedula</label>
								<div class = "col-sm-5">
									<div class="input-group col-sm-5">
  										<input class = "form-control" type="number" name ="txtCedula" value = "${cliente.getCedula_cliente()}"> <!-- Texto cedula del cliente -->
  										<input class="btn btn-outline-success" type="submit" id="Buscar" name = "Buscar1" value ="Buscar Cliente"> <!-- Boton buscar cliente -->
									</div>
								</div>
								<div class = "col-sm-6 mb-2">
									<input class = "form-control" type = "text" disabled="disabled" name = "salidaCleinte" value = "${cliente.getNombre_cliente()}"> <!-- Texto nombre del cliente -->
								</div>
							</div>	
						</form>
						
					</div>
					<div class = "card header bg-success text-light">
						<span class = "text-center">Datos del Producto</span>
					</div>
					<div class = "card-body">
					
						<form action="ControladorVentas" method = "POST">           <!-- Segundo Formulario PRODUCTO -->
						<div class = "row">
							<label class = "col-form-label">Codigo de producto</label>
								<div class = "col-sm-5">
									<div class="input-group col-sm-5">
  										<input class = "form-control" type="text" name ="txtCod" value = "${producto.getCodigoProducto()}"> <!-- Texto Buscar  producto -->
  										<input class="btn btn-outline-success" type="submit" id="Buscar" name = "Buscar2" value ="Buscar Producto"> <!-- Tboton para buscar el producto -->
									</div>
								</div>
								<div class = "col-sm-6 mb-2">
									<input class = "form-control" type = "text" disabled="disabled" name="nombre_prod" value = "${producto.getNombreProducto()}"> <!-- Texto nombre del producto -->
								</div>
						</div>
						<div class = "row mb-4">
							<label class = "col-form-label">Datos del producto</label>
							<div class = "col-sm-4">
								<div class="input-group col-sm-5 ">
  									<span class="input-group-text bg-success text-light">Valor</span>
  									<input class = "form-control" type = "text" disabled="disabled" name="valor" value = "${producto.getPrecioVenta()}"> <!-- Texto valor del producto -->
								</div>
							</div>
							<div class = "col-sm-4">
								<div class="input-group col-sm-5">
  									<span class="input-group-text bg-success text-light">IVA</span>
  									<input class = "form-control" type = "text" disabled="disabled" name="IVA" value = "${producto.getIvaCompra()}"> <!-- Texto IVA del producto -->
								</div>
							</div>
							<div class = "col-sm-3">
								<div class="input-group col-sm-5">
  									<span class="input-group-text bg-success text-light">Cantidad</span>
  									<input class = "form-control" type = "number" name="cantidad" > <!-- Texto cantidad del producto -->
								</div>
							</div>
						</div>
						<div class = "row justify-content-md-center">
							<div class="d-grid gap-2">
								<input class="btn btn-success" type = "submit" name = "Agregar" value ="Agr
								egar Producto"> <!-- Agregar producto al carro o lista de compras -->
							</div>
						</div>
						</form>
						
						
					</div>
				</div>
			</div>
			<div class="col-lg col-mg col-sm col">
				<div class = "card">
					<div class = "card header bg-transparent">
						<form action="">
							<div class = "d-flex justify-content-end">
								<div class ="col-6"></div>
								<div class ="col-3 p-3">
									<p class="fw-bold text-end text-danger">N° FACTURA</p>
								</div>
								<div class ="col-2 m-2">
									<input class = "form-control" type = "text" disabled="disabled" name="con_fac"> <!-- texto Consecutivo de la factura -->
								</div>
							</div>
						</form>
					</div>
					<div class = "card-body">
						<form action="">
							<table class="table bg-light table-bordered table-hover table-stripped">
								<thead>
									<tr>
										<th>Item</th>
										<th>COD</th>
										<th>Producto</th>
										<th>Cantidad</th>
										<th>Total</th>
										<th></th>
									</tr>
								</thead>
								<tbody>		
									<c:forEach var="usuarios" items="${lista}">
										<tr>
											<td>${usuarios.getCedula_usuario()}</td>
											<td>${usuarios.getEmail_usuario()}</td>
											<td>${usuarios.getNombre_usuario()}</td>
											<td>${usuarios.getPassword()} <input class="form-control" type ="number" name = "tabla_cantidad"> </td> <!-- texto para agregar cantidad adicional a la compra -->
											<td>Editar</td>
											<td> <input class="btn btn-sm-outline-success" type ="submit" name="agregar_tabla" value="OK"> <!-- Boton agregar cantidad a la comrpa -->
											<input class="btn btn-sm-outline-danger" type ="submit" name="eliminar_tabla" value ="Borrar">   <!-- Boton quitar producto a la comrpa -->
											</td>
										</tr>
									</c:forEach>					
								</tbody>
							</table>
						</form>
					</div>
					<div class= "card-footer">
						<form action="">
							<div class = row>
								<div class = "col-5">
									<input class = "btn btn-success" type="submit" name="Finalizar" value="Finalizar Compra"> <!-- Boton finalizar comrpa -->
									<input class = "btn btn-danger" type="submit" name="Cancelar" value="Cancelar Compra"> <!-- Boton cancelar comrpa -->
								</div>
								<div class = "col-7">
									<div class = "d-flex justify-content-end">
										<div class ="col-4 p-2">
											<p class="fw-bold text-end text-danger">TOTAL VENTA:</p>
										</div>
										<div class ="col-3 p-2">
											<input class = "form-control" type = "text" disabled="disabled" name="total_venta"> <!-- Texto para el valor de la venta sin IVA -->
										</div>
									</div>
									<div class = "d-flex justify-content-end">
										<div class ="col-4 p-2">
											<p class="fw-bold text-end text-danger">TOTAL IVA:</p>
										</div>
										<div class ="col-3 p-2">
											<input class = "form-control" type = "text" disabled="disabled" name="total_iva"> <!-- Texto para el valor total del IVA -->
										</div>
									</div>
									<div class = "d-flex justify-content-end">
										<div class ="col-4 p-2">
											<p class="fw-bold text-end text-danger">TOTAL CON IVA:</p>
										</div>
										<div class ="col-3 p-2">
											<input class = "form-control" type = "text" disabled="disabled" name="total_con_iva"> <!-- Texto para el valor total con IVA -->
										</div>
									</div>
								</div>
							</div>	
						</form>
					</div>
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