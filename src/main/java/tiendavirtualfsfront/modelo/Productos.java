package tiendavirtualfsfront.modelo;

public class Productos {
	
	private Long codigo_producto;
	private double iva_compra;
	private Long nit_proveedor;
	private String nombre_producto;
	private double precio_compra;
	private double precio_venta;
	
	public Productos(Long codigo_producto,String nombre_producto, Long nit_proveedor, double precio_compra, double iva_compra,   
			double precio_venta) {
		super();
		this.iva_compra = iva_compra;
		this.nit_proveedor = nit_proveedor;
		this.nombre_producto = nombre_producto;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
		this.codigo_producto = codigo_producto;
		
	}
	
	public Productos() {
		super();
	}
	
	public Long getCodigoProducto() {
		return codigo_producto;
	}
	public void setCodigoProducto(Long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public double getIvaCompra() {
		return iva_compra;
	}
	public void setIvaCompra(double iva_compra) {
		this.iva_compra = iva_compra;
	}
	public Long getNitProveedor() {
		return nit_proveedor;
	}
	public void setNitProveedor(Long nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}
	public String getNombreProducto() {
		return nombre_producto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombre_producto = nombreProducto;
	}
	public double getPrecioCompra() {
		return precio_compra;
	}
	public void setPrecioCompra(double precio_compra) {
		this.precio_compra = precio_compra;
	}
	public double getPrecioVenta() {
		return precio_venta;
	}
	public void setPrecioVenta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

}
