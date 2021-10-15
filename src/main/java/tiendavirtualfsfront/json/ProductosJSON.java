package tiendavirtualfsfront.json;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tiendavirtualfsfront.modelo.Productos;

public class ProductosJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	
	public static ArrayList<Productos> parsingUsuarios(String json) throws ParseException {//devulve un arraylist
		JSONParser jsonParser = new JSONParser();
		ArrayList<Productos> lista = new ArrayList<Productos>();
		JSONArray producto = (JSONArray) jsonParser.parse(json);
		Iterator i = producto.iterator(); //recorrer la tabla proveedor
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Productos productos = new Productos();
			productos.setCodigoProducto(Long.parseLong(innerObj.get("codigoProducto").toString())); //convertir de String a Long
			productos.setIvaCompra(Double.parseDouble(innerObj.get("ivaCompra").toString()));
			productos.setNitProveedor(Long.parseLong(innerObj.get("nitProveedor").toString()));
			productos.setNombreProducto(innerObj.get("nombreProducto").toString());
			productos.setPrecioCompra(Double.parseDouble(innerObj.get("precioCompra").toString()));
			productos.setPrecioVenta(Double.parseDouble(innerObj.get("precioVenta").toString()));
			lista.add(productos);
		}
		return lista;
	}
	
	/**
	 * Conecta con el back-end segun los atributos definidos esn la clase y llama al metodo parsingUsuarios para 
	 * crear una lista de objetos de tipo Usuarios
	 * @return Un ArrayList de tipo Usuario
	 * @throws IOException
	 * @throws ParseException
	 */
	public static ArrayList<Productos> getJSON() throws IOException, ParseException { //devolver un listado JSON

		url = new URL(sitio + "productos/listar"); //trae el metodo de Usuarios.API 
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");

		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";

		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}
		System.out.println(json);
		ArrayList<Productos> lista = new ArrayList<Productos>();
		lista = parsingUsuarios(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<Productos> getforIdJSON(String id) throws IOException, ParseException { //devolver un listado JSON

		url = new URL(sitio + "productos/listarid/"+id); //trae el metodo de Usuarios.API 
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");

		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		
		String json = "[";

		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}
		json = json + "]";
		ArrayList<Productos> lista = new ArrayList<Productos>();
		lista = parsingUsuarios(json);
		http.disconnect();
		return lista;
	}
	
	/**
	 * Conecta con el Back-end y crea en la base de datos segun un objeto de tipo Usuarios
	 * @param usuario
	 * @return
	 * @throws IOException
	 */
	public static int postJSON(Productos productos) throws IOException {

		url = new URL(sitio + "productos/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();

		try {
			http.setRequestMethod("POST");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		String data = "{" + "\"codigo_producto\":\"" + String.valueOf(productos.getCodigoProducto())
				+ "\",\"ivacompra\": \"" + String.valueOf(productos.getIvaCompra()) + "\",\"nitproveedor\": \""
				+ String.valueOf(productos.getNitProveedor()) + "\",\"nombre_producto\":\"" + productos.getNombreProducto() + "\",\"precio_compra\":\""
				+ String.valueOf(productos.getPrecioCompra()) + "\",\"precio_venta\":\""+ String.valueOf(productos.getPrecioVenta()) +"\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	public static int deleteJSON(String id) throws IOException {

		url = new URL(sitio + "productos/eliminar/"+id); //trae el metodo de Usuarios.API 
		HttpURLConnection http = (HttpURLConnection) url.openConnection();


		try {
			http.setRequestMethod("DELETE");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	public static boolean validarCSV(String nombreArchivo) {
		int contador = 0;
        char valdador;
        for (int i = 0; i < nombreArchivo.length(); i++) {
        	valdador = nombreArchivo.charAt(i);
            if (valdador == '.')
            	contador++;
        }
        
        if (contador<2) {
        	if(nombreArchivo.contains(".csv")) {
    			return true;
    		}else {
    			return false;
    		}
        }else{
        	return false;
        }
	}
	
	public static void main(String[] args) {
				
		/*ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		UsuariosJSON prueba = new UsuariosJSON();
		try {
			lista = prueba.getforIdJSON("1022420439");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error metodo");
			// TODO: handle exception
		}
		for (Usuarios user: lista) {
			System.out.println(user.getCedula_usuario());
			System.out.println(user.getNombre_usuario());
		}
		try {
			ArrayList<Productos> lista = new ArrayList<Productos>();
			lista = ProductosJSON.getJSON();
			for (Productos items: lista)
			{
				System.out.println(items.getCodigo_producto());
				System.out.println(items.getIvacompra());
				System.out.println(items.getNitproveedor());
				System.out.println(items.getNombre_producto());
				System.out.println(items.getPrecio_compra());
				System.out.println(items.getPrecio_venta());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
			// TODO: handle exception
		}

}
