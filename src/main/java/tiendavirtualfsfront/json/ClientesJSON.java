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

import tiendavirtualfsfront.modelo.Clientes;

public class ClientesJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	/**
	 * Agruega informacion al objeto Usuario de la carpeta modelo
	 * @param json
	 * @return Un ArrayList de tipo Clientes
	 * @throws ParseException
	 */
	public static ArrayList<Clientes> parsingClientes(String json) throws ParseException {//devulve un arraylist
		JSONParser jsonParser = new JSONParser();
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		JSONArray clientes = (JSONArray) jsonParser.parse(json);
		Iterator i = clientes.iterator(); //recorrer la tabla usuario
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Clientes cliente = new Clientes();
			cliente.setCedula_cliente(Long.parseLong(innerObj.get("cedula_cliente").toString())); //convertir de String a Long
			cliente.setDireccion_cliente(innerObj.get("direccion_cliente").toString());
			cliente.setEmail_cliente(innerObj.get("email_cliente").toString());
			cliente.setNombre_cliente(innerObj.get("nombre_cliente").toString());
			cliente.setTelefono_cliente(innerObj.get("telefono_cliente").toString());
			lista.add(cliente);
		}
		return lista;
	}
	
	/**
	 * Conecta con el back-end segun los atributos definidos esn la clase y llama al metodo parsingUsuarios para 
	 * crear una lista de objetos de tipo Clientes
	 * @return Un ArrayList de tipo Clientes
	 * @throws IOException
	 * @throws ParseException
	 */
	public static ArrayList<Clientes> getJSON() throws IOException, ParseException { //devolver un listado JSON

		url = new URL(sitio + "clientes/listar"); //trae el metodo de Usuarios.API 
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
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		lista = parsingClientes(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<Clientes> getforIdJSON(String id) throws IOException, ParseException { //devolver un listado JSON

		url = new URL(sitio + "clientes/listarid/"+id); //trae el metodo de Usuarios.API 
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
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		lista = parsingClientes(json);
		http.disconnect();
		return lista;
	}
	
	/**
	 * Conecta con el Back-end y crea en la base de datos segun un objeto de tipo Clientes
	 * @param cliente
	 * @return
	 * @throws IOException
	 */
	public static int postJSON(Clientes cliente) throws IOException {

		url = new URL(sitio + "clientes/guardar");
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

		String data = "{" + "\"cedula_cliente\":\"" + String.valueOf(cliente.getCedula_cliente())
				+ "\",\"direccion_cliente\": \"" + cliente.getDireccion_cliente() + "\",\"email_cliente\": \""
				+ cliente.getEmail_cliente() + "\",\"nombre_cliente\":\"" + cliente.getNombre_cliente() + "\",\"telefono_cliente\":\""
				+ cliente.getTelefono_cliente() + "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	public static int deleteJSON(String id) throws IOException {

		url = new URL(sitio + "clientes/eliminar/"+id); //trae el metodo de Clientes.API 
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
	
	public static void main(String[] args) {
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		ClientesJSON prueba = new ClientesJSON();
		/*try {
			lista = prueba.getforIdJSON("456");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error metodo");
			// TODO: handle exception
		}
		for (Clientes cl: lista) {
			System.out.println(cl.getCedula_cliente());
			System.out.println(cl.getNombre_cliente());
		}
		try {
			int borado = ClientesJSON.deleteJSON("123456789");
			System.out.println(borado);
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		
		
		
	}

}
