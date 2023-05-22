package modelos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Producto;


public class modeloProducto extends Conexion{

	public ArrayList<Producto> verProductos (){
		ArrayList<Producto> productos = new ArrayList<Producto>();
		modeloSeccion mS = new modeloSeccion();
		mS.Conectar();
		
		try {
			PreparedStatement pst = conexion.prepareStatement("SELECT * FROM productos");
			
			ResultSet resultado =pst.executeQuery();
			
			while(resultado.next()) {
				Producto producto = new Producto();
				
				producto.setId(resultado.getInt("id"));
				producto.setCodigo(resultado.getInt("codigo"));
				producto.setNombre(resultado.getString("nombre"));
				producto.setCantidad(resultado.getInt("cantidad"));
				producto.setPrecio(resultado.getDouble("precio"));
				producto.setCaducidad(resultado.getDate("caducidad"));
				producto.setSeccion(mS.getSeccion(resultado.getInt("id_seccion")));
				
				productos.add(producto);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		mS.cerrar();
		return productos;
		
		
		
	}
	
	public void InsertarProductos(Producto producto) {
		try {
			
			modeloSeccion mS = new modeloSeccion();
			PreparedStatement pst = conexion.prepareStatement("INSERT INTO productos( codigo, nombre, cantidad, precio, caducidad, id_seccion) VALUES (?,?,?,?,?,?)");
				
				
				pst.setInt(1, producto.getCodigo());
				pst.setString(2, producto.getNombre());
				pst.setInt(3, producto.getCantidad());
				pst.setDouble(4, producto.getPrecio());
				pst.setDate(5, new Date(producto.getCaducidad().getTime()));
				pst.setInt(6, producto.getSeccion().getId());
				
				pst.execute();
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean getCodigo(int codigo) {
		boolean encontrado = false;
		
		PreparedStatement pst;
		try {
			pst = conexion.prepareStatement("SELECT codigo FROM productos WHERE codigo = ?");
			pst.setInt(1, codigo);
			
			ResultSet resultado = pst.executeQuery();
			
			if(resultado.next()) {
				 encontrado = true;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return encontrado;
			
		}
	
	public Producto getProducto(int codigo) {
		Producto producto = new Producto();
		modeloSeccion mS = new modeloSeccion();
		
		PreparedStatement pst;
		try {
			pst = conexion.prepareStatement("SELECT * FROM productos WHERE codigo = ?");
		
			pst.setInt(1, codigo);
			
			ResultSet resultado = pst.executeQuery();
			
			resultado.next();
			
			producto.setCodigo(codigo);
			producto.setNombre(resultado.getString("nombre"));
			producto.setCantidad(resultado.getInt("cantidad"));
			producto.setPrecio(resultado.getDouble("precio"));
			producto.setCaducidad(resultado.getDate("caducidad"));
			mS.Conectar();
			producto.setSeccion(mS.getSeccion(resultado.getInt("id_seccion")));
			mS.cerrar();
			
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return producto;
	}
	
	public void modificarProducto(Producto producto) {
		
		
		PreparedStatement pst;
		
		try {
			pst = conexion.prepareStatement("UPDATE productos SET nombre=?, cantidad=?, precio=?, caducidad=?, id_seccion=? WHERE codigo = ?");
			
			pst.setInt(6, producto.getCodigo());
			pst.setString(1, producto.getNombre());
			pst.setInt(2, producto.getCantidad());
			pst.setDouble(3, producto.getPrecio());
			pst.setDate(4, new Date(producto.getCaducidad().getTime()));
			pst.setInt(5, producto.getSeccion().getId());
			
			pst.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
		
	}

