package clases;

public class Producto_Supermercado {

	private int id;
	private int id_producto;
	private int id_supermercado;
	
	public Producto_Supermercado() {
	}

	public Producto_Supermercado(int id, int id_producto, int id_supermercado) {
		this.id = id;
		this.id_producto = id_producto;
		this.id_supermercado = id_supermercado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_poducto) {
		this.id_producto = id_producto;
	}

	public int getId_supermercado() {
		return id_supermercado;
	}

	public void setId_supermercado(int id_supermercado) {
		this.id_supermercado = id_supermercado;
	}

	public String toString() {
		return "producto_supermercado [id=" + id + ", id_poducto=" + id_producto + ", id_supermercado=" + id_supermercado
				+ "]";
	}
	
	
	
}
