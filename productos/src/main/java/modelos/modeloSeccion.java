package modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.secciones;

public class modeloSeccion extends Conexion{

	
	
	public secciones getSeccion(int id) {
		secciones seccion = new secciones();
		
		try {
			PreparedStatement pst = conexion.prepareStatement("SELECT * FROM secciones WHERE id=?");
		
			pst.setInt(1, id);
		
			ResultSet resultado = pst.executeQuery();
		
			resultado.next();
		
			seccion.setId(resultado.getInt("id"));
			seccion.setNombre(resultado.getString("nombre"));
		
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return seccion;
	}
	
	public ArrayList<secciones> getSecciones(){
		ArrayList<secciones> secciones = new ArrayList<secciones>();
		
		try {
			PreparedStatement pst = conexion.prepareStatement("SELECT * FROM secciones");
		
		ResultSet resultado = pst.executeQuery();
		
		while(resultado.next()) {
			secciones seccion = new secciones();
			
			seccion.setId(resultado.getInt("id"));
			seccion.setNombre(resultado.getString("nombre"));
			
			secciones.add(seccion);
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return secciones;
		
	}
	
}
