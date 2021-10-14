package tiendavirtualfsfront.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tiendavirtualfsfront.modelo.Clientes;
import tiendavirtualfsfront.json.ClientesJSON;

/**
 * Servlet implementation class ControladorClientes
 */
@WebServlet("/ControladorClientes")
public class ControladorClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorClientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String cedula = request.getParameter("cedula");
		String direccion = request.getParameter("direccion");
		String email = request.getParameter("email");
		String nombre = request.getParameter("nombre");
		String telefono = request.getParameter("telefono");
		String consultar = request.getParameter("Consultar");
		String Agregar = request.getParameter("Agregar");
		String Listar = request.getParameter("Listar_Clientes");
		String eliminar = request.getParameter("Eliminar");
		String modificar = request.getParameter("Actualizar");
		
		if (Listar != null) {
			try {
				ArrayList<Clientes> lista = ClientesJSON.getJSON();
				request.setAttribute("lista", lista);
				request.getRequestDispatcher("Clientes.jsp").forward(request, response);
			} catch (Exception e) {
				out.println("Catch :(");
				// TODO: handle exception
			}
		}
		if (consultar != null) {
			if (cedula != "" && cedula != null) {
				boolean existe = false;					
				try {
					ArrayList<Clientes> lista = ClientesJSON.getJSON();
					for (Clientes cliente_prueba: lista) {
						if(cliente_prueba.getCedula_cliente() == Long.parseLong(cedula)) {
							existe = true;
						}
					}
					if(!existe) {
						request.setAttribute("validacion", 8);//El usuario no existe
						request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
					}else {
						ArrayList<Clientes> listaid = ClientesJSON.getforIdJSON(cedula);
						request.setAttribute("lista", listaid );
						request.getRequestDispatcher("Clientes.jsp").forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
					out.println("Catch :(");
					out.println(cedula);
					// TODO: handle exception
				}
			}else {
				request.setAttribute("validacion", 0);//Ingrese el campo cedula
				request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
			}
		}
		if (Agregar != null) {
			if (cedula != "" && direccion != "" && email != "" && nombre != "" && telefono != "" && cedula != null && direccion != null && email != null && nombre != null && telefono != null) {
				System.out.println("Entro If");
				boolean existe = false;
				try {
					ArrayList<Clientes> listaid = ClientesJSON.getforIdJSON(cedula);
					for (Clientes cliente_prueba: listaid) {
						if(cliente_prueba.getCedula_cliente() == Long.parseLong(cedula)) {
							existe = true;
						}
					}
				} catch (Exception e) {
					out.println("Catch :(");
					out.println(cedula);
					// TODO: handle exception
				}
				if (!existe) {
					Clientes cliente = new Clientes();
					cliente.setCedula_cliente(Long.parseLong(cedula));
					cliente.setDireccion_cliente(direccion);
					cliente.setEmail_cliente(email);
					cliente.setNombre_cliente(nombre);
					cliente.setTelefono_cliente(telefono);
					int creado = ClientesJSON.postJSON(cliente);
					System.out.println(creado);
					if(creado == 200) {
						request.setAttribute("validacion", 2);//Usuario Creado
						request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
					}else {
						request.setAttribute("validacion", 3);//Ha habido un error
						request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
					}
				}else {
					request.setAttribute("validacion", 4);//El usuario ya existe
					request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
				}	
			} else {
				request.setAttribute("validacion", 1);//Ingrese todos los campos
				request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
			}
		}
		if (eliminar != null) {
			if (cedula != "" && cedula != null) {
				boolean existe = false;					
				try {
					ArrayList<Clientes> lista = ClientesJSON.getJSON();
					for (Clientes cliente_prueba: lista) {
						if(cliente_prueba.getCedula_cliente() == Long.parseLong(cedula)) {
							existe = true;
						}
					}
					if(!existe) {
						request.setAttribute("validacion", 8);//El usuario no existe
						request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
					}else {
						int borrado = ClientesJSON.deleteJSON(cedula);
						if(borrado == 200) {
							request.setAttribute("validacion", 5);//Usuario Borrado
							request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
						}else {
							request.setAttribute("validacion", 3);//Ha habido un error
							request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					out.println("Catch :(");
					out.println(cedula);
					// TODO: handle exception
				}
			} else {
				request.setAttribute("validacion", 0);//Ingrese el campo cedula
				request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
			}
		}
		if (modificar != null) {
			if (cedula != "" && direccion != "" && email != "" && nombre != "" && telefono != "" && cedula != null && direccion != null && email != null && nombre != null && telefono != null) {
				System.out.println("Entro If");
				boolean existe = false;
				try {
					ArrayList<Clientes> listaid = ClientesJSON.getforIdJSON(cedula);
					for (Clientes cliente_prueba: listaid) {
						if(cliente_prueba.getCedula_cliente() == Long.parseLong(cedula)) {
							existe = true;
						}
					}
				} catch (Exception e) {
					out.println("Catch :(");
					out.println(cedula);
					// TODO: handle exception
				}
				if (existe) {
					Clientes cliente = new Clientes();
					cliente.setCedula_cliente(Long.parseLong(cedula));
					cliente.setDireccion_cliente(direccion);
					cliente.setEmail_cliente(email);
					cliente.setNombre_cliente(nombre);
					cliente.setTelefono_cliente(telefono);
					int creado = ClientesJSON.postJSON(cliente);
					System.out.println(creado);
					if(creado == 200) {
						request.setAttribute("validacion", 6);//Usuario Modificado
						request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
					}else {
						request.setAttribute("validacion", 3);//Ha habido un error
						request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
					}
				}else {
					request.setAttribute("validacion", 7);//El usuario no existe no se puede modificar
					request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
				}	
			} else {
				request.setAttribute("validacion", 1);//Ingrese todos los campos
				request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
			}
		}
		String editar = request.getParameter("editar");
		if(editar != null) {
			Long id = Long.parseLong(request.getParameter("id"));
			try {
				ArrayList<Clientes> listaid = ClientesJSON.getforIdJSON(String.valueOf(id));
				Clientes cliente = new Clientes();
				for (int i = 0;i<listaid.size();i++) {
					cliente = listaid.get(i);
				}
				request.setAttribute("clientes", cliente);
				request.getRequestDispatcher("Clientes.jsp").forward(request, response);
			} catch (Exception e) {
				out.println("Catch editar aquiiiiii");
				out.println(cedula);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
