package modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Clases.Producto;

public class modeloProducto extends Conexion{

	public ArrayList<Producto> verProductos (){
		ArrayList<Producto> productos = new ArrayList<Producto>();
		try {
			PreparedStatement pst = conexion.prepareStatement("SELECT * FROM productos");
			
			ResultSet resultado =pst.executeQuery();
			Producto producto = new Producto();
			
			while(resultado.next()) {
				producto.setId(resultado.getInt("id"));
				producto.setCodigo(resultado.getInt("codigo"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}
