package modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Seccion;

public class modeloSeccion extends Conexion{

	
	
	public Seccion getSeccion(int id) {
		Seccion seccion = new Seccion();
		
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
	
	public Seccion getSeccionId(String nombre) {
		Seccion seccion = new Seccion();
		
		try {
			PreparedStatement pst = conexion.prepareStatement("SELECT id FROM secciones WHERE nombre=?");
		
			pst.setString(1, nombre);
		
			ResultSet resultado = pst.executeQuery();
		
			resultado.next();
		
			seccion.setId(resultado.getInt("id"));
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return seccion;
	}
	
	
	
	public ArrayList<Seccion> getSecciones(){
		ArrayList<Seccion> secciones = new ArrayList<Seccion>();
		
		try {
			PreparedStatement pst = conexion.prepareStatement("SELECT * FROM secciones");
		
		ResultSet resultado = pst.executeQuery();
		
		while(resultado.next()) {
			Seccion seccion = new Seccion();
			
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
