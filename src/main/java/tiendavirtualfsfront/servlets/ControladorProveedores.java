package tiendavirtualfsfront.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tiendavirtualfsfront.modelo.Proveedores;
import tiendavirtualfsfront.json.ProveedoresJSON;

/**
 * Servlet implementation class ControladorProveedores
 */
@WebServlet("/ControladorProveedores")
public class ControladorProveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

    public ControladorProveedores() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String nit = request.getParameter("NIT");
		String nombre = request.getParameter("nombreproveedor");
		String ciudad = request.getParameter("ciudad");
		String direccion = request.getParameter("Direcion");
		String telefono = request.getParameter("Tel");
		String consultar = request.getParameter("Consultar");
		String Agregar = request.getParameter("Agregar");
		String Listar = request.getParameter("Listar_Proveedores");
		String eliminar = request.getParameter("Eliminar");
		String modificar = request.getParameter("Actualizar");
		
		if (Listar != null) {
			try {
				ArrayList<Proveedores> lista = ProveedoresJSON.getJSON();
				request.setAttribute("lista", lista);
				request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
			} catch (Exception e) {
				out.println("Catch :(");
				out.println(e.getMessage());
				out.println(e.getLocalizedMessage());
				out.println(e.getStackTrace());
				e.printStackTrace();
			}
		}
		if (consultar != null) {
			if (nit != "" && nit != null) {
				boolean existe = false;					
				try {
					ArrayList<Proveedores> lista = ProveedoresJSON.getJSON();
					for (Proveedores proveedores_prueba: lista) {
						if(proveedores_prueba.getNitproveedor() == Long.parseLong(nit)) {
							existe = true;
						}
					}
					if(!existe) {
						request.setAttribute("validacion", 8);//El usuario no existe
						request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
					}else {
						ArrayList<Proveedores> listaid = ProveedoresJSON.getforIdJSON(nit);
						request.setAttribute("lista", listaid );
						request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
					out.println("Catch :(");
					out.println(nit);
					// TODO: handle exception
				}
			}else {
				request.setAttribute("validacion", 0);//Ingrese el campo cedula
				request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
			}
		}
		if (Agregar != null) {
			if (nit != "" && nombre != "" && ciudad != "" && direccion != "" && telefono != "" && nit != null && nombre != null && ciudad != null && direccion != null && telefono != null) {
				boolean existe = false;
				try {
					ArrayList<Proveedores> listaid = ProveedoresJSON.getforIdJSON(nit);
					for (Proveedores proveedor_prueba: listaid) {
						if(proveedor_prueba.getNitproveedor() == Long.parseLong(nit)) {
							existe = true;
						}
					}
				} catch (Exception e) {
					out.println("Catch :(");
					out.println(nit);
					// TODO: handle exception
				}
				if (!existe) {
					Proveedores supplier = new Proveedores();
					supplier.setNitproveedor(Long.parseLong(nit));
					supplier.setCiudad_proveedor(ciudad);
					supplier.setDireccion_proveedor(direccion);
					supplier.setNombre_proveedor(nombre);
					supplier.setTelefono_proveedor(telefono);
					int creado = ProveedoresJSON.postJSON(supplier);
					System.out.println(creado);
					if(creado == 200) {
						request.setAttribute("validacion", 2);//Usuario Creado
						request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
					}else {
						request.setAttribute("validacion", 3);//Ha habido un error
						request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
					}
				}else {
					request.setAttribute("validacion", 4);//El usuario ya existe
					request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
				}	
			} else {
				request.setAttribute("validacion", 1);//Ingrese todos los campos
				request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
			}
		}
		
		if (eliminar != null) {
			if (nit != "" && nit != null) {
				boolean existe = false;					
				try {
					ArrayList<Proveedores> lista = ProveedoresJSON.getJSON();
					for (Proveedores proveedores_prueba: lista) {
						if(proveedores_prueba.getNitproveedor() == Long.parseLong(nit)) {
							existe = true;
						}
					}
					if(!existe) {
						request.setAttribute("validacion", 8);//El usuario no existe
						request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
					}else {
						int borrado = ProveedoresJSON.deleteJSON(nit);
						if(borrado == 200) {
							request.setAttribute("validacion", 5);//Usuario Borrado
							request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
						}else {
							request.setAttribute("validacion", 3);//Ha habido un error
							request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					out.println("Catch :(");
					out.println(nit);
					// TODO: handle exception
				}
			} else {
				request.setAttribute("validacion", 0);//Ingrese el campo cedula
				request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
			}
		}
		
		if (modificar != null) {
			if (nit != "" && nombre != "" && ciudad != "" && direccion != "" && telefono != "" && nit != null && nombre != null && ciudad != null && direccion != null && telefono != null) {
				boolean existe = false;
				try {
					ArrayList<Proveedores> listaid = ProveedoresJSON.getforIdJSON(nit);
					for (Proveedores proveedor_prueba: listaid) {
						if(proveedor_prueba.getNitproveedor() == Long.parseLong(nit)) {
							existe = true;
						}
					}
				} catch (Exception e) {
					out.println("Catch :(");
					out.println(nit);
					// TODO: handle exception
				}
				if (existe) {
					Proveedores supplier = new Proveedores();
					supplier.setNitproveedor(Long.parseLong(nit));
					supplier.setCiudad_proveedor(ciudad);
					supplier.setDireccion_proveedor(direccion);
					supplier.setNombre_proveedor(nombre);
					supplier.setTelefono_proveedor(telefono);
					int creado = ProveedoresJSON.postJSON(supplier);
					System.out.println(creado);
					if(creado == 200) {
						request.setAttribute("validacion", 6);//Usuario Modificado
						request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
					}else {
						request.setAttribute("validacion", 3);//Ha habido un error
						request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
					}
				}else {
					request.setAttribute("validacion", 7);//El usuario no existe no se puede modificar
					request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
				}	
			} else {
				request.setAttribute("validacion", 9);//Ingrese todos los campos
				request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
			}
		}
		String editar = request.getParameter("editar");
		if(editar != null) {
			Long id = Long.parseLong(request.getParameter("id"));
			try {
				ArrayList<Proveedores> listaid = ProveedoresJSON.getforIdJSON(String.valueOf(id));
				Proveedores supplier = new Proveedores();
				for (int i = 0;i<listaid.size();i++) {
					supplier = listaid.get(i);
				}
				request.setAttribute("proveedor", supplier);
				request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
			} catch (Exception e) {
				out.println("Catch editar aquiiiiii");
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
