package clases;

import java.util.Date;

public class Producto {

	private int id;
	private String codigo;
	private String nombre;
	private int cantidad;
	private double precio;
	private Date caducidad;
	private secciones seccion;
	
	public Producto() {
	}

	public Producto(int id, String codigo, String nombre, int cantidad, double precio, Date caducidad, secciones seccion) {
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.caducidad = caducidad;
		this.seccion = seccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}

	public secciones getSeccion() {
		return seccion;
	}

	public void setSeccion(secciones seccion) {
		this.seccion = seccion;
	}


	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", cantidad=" + cantidad
				+ ", precio=" + precio + ", caducidad=" + caducidad + ", seccion=" + seccion + "]";
	}
	
	
}
