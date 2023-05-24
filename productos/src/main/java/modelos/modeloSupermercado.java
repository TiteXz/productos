package modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Supermercado;

public class modeloSupermercado extends Conexion{

	public ArrayList<Supermercado> getSupermercados(){
		ArrayList<Supermercado> supermercados = new ArrayList<Supermercado>();
		PreparedStatement pst;
		
		try {
			pst = conexion.prepareStatement("SELECT * FROM supermercados");
			
			ResultSet resultado = pst.executeQuery();
			
			while(resultado.next()) {
				Supermercado supermercado = new Supermercado();
				
				supermercado.setId(resultado.getInt("id"));
				supermercado.setNombre(resultado.getString("nombre"));
				
				supermercados.add(supermercado);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return supermercados;
	}
	
}
