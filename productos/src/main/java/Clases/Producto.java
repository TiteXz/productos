package Clases;

import java.util.Date;

public class Producto {

	private int id;
	private int codigo;
	private String nombre;
	private int cantidad;
	private double precio;
	private Date caducidad;
	private int id_seccion;
	
	public Producto() {
		super();
	}

	public Producto(int id, int codigo, String nombre, int cantidad, double precio, Date caducidad, int id_seccion) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.caducidad = caducidad;
		this.id_seccion = id_seccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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

	public int getId_seccion() {
		return id_seccion;
	}

	public void setId_seccion(int id_seccion) {
		this.id_seccion = id_seccion;
	}

	
	public String toString() {
		return "producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", cantidad=" + cantidad
				+ ", precio=" + precio + ", caducidad=" + caducidad + ", id_seccion=" + id_seccion + "]";
	}
	
	
}
