package modelos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.Producto;
import clases.Producto_Supermercado;

public class modeloProducto_Supermercado extends Conexion{

	public void InsertarProductos_supers(int id_producto, int[]idsSupermercados) {
		try {
			PreparedStatement pst = conexion.prepareStatement("INSERT INTO productos_supermercados(id_producto, id_supermercado) VALUES (?,?)");
		
			Producto_Supermercado pro_super = new Producto_Supermercado();
			
			pst.setInt(1, pro_super.getId_producto());
			pst.setInt(2, pro_super.getId_supermercado());
			
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
