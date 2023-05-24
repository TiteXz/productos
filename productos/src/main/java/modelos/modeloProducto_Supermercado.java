package modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.Producto_Supermercado;

public class modeloProducto_Supermercado extends Conexion {

	public void InsertarProductos_supers(int id_producto, int[] idsSupermercados) {
		try {
			PreparedStatement pst = conexion
					.prepareStatement("INSERT INTO productos_supermercados(id_producto, id_supermercado) VALUES (?,?)");

			pst.setInt(1, id_producto);
			for (int i = 0; i < idsSupermercados.length; i++) {
				pst.setInt(2, idsSupermercados[i]);
				pst.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int getMaxId() {
		int maxId = 0;

		try {
			PreparedStatement pst = conexion.prepareStatement("SELECT MAX(id) FROM productos");

			ResultSet resultado = pst.executeQuery();

			resultado.next();

			maxId = resultado.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return maxId;
	}

	public void eliminarProduDeSupers(int id_producto) {

		try {
			PreparedStatement pst = super.getConexion().prepareStatement("DELETE FROM productos_supermercados WHERE id_producto = ?");

			pst.setInt(1, id_producto);

			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
