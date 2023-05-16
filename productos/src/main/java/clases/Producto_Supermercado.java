package clases;

public class Producto_Supermercado {

	private int id;
	private int id_poducto;
	private int id_supermercado;
	
	public Producto_Supermercado() {
		super();
	}

	public Producto_Supermercado(int id, int id_poducto, int id_supermercado) {
		super();
		this.id = id;
		this.id_poducto = id_poducto;
		this.id_supermercado = id_supermercado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_poducto() {
		return id_poducto;
	}

	public void setId_poducto(int id_poducto) {
		this.id_poducto = id_poducto;
	}

	public int getId_supermercado() {
		return id_supermercado;
	}

	public void setId_supermercado(int id_supermercado) {
		this.id_supermercado = id_supermercado;
	}

	public String toString() {
		return "producto_supermercado [id=" + id + ", id_poducto=" + id_poducto + ", id_supermercado=" + id_supermercado
				+ "]";
	}
	
	
	
}
