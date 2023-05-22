package controladores;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Producto;
import modelos.modeloProducto;
import modelos.modeloSeccion;

/**
 * Servlet implementation class modificarProducto
 */
@WebServlet("/modificarProducto")
public class modificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modificarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		modeloSeccion mS = new modeloSeccion();
		modeloProducto mP = new modeloProducto();
		
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		double precio = Double.parseDouble(request.getParameter("precio"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nombre_seccion = request.getParameter("nombre_seccion");
		
		
		Producto producto = new Producto();
		
		producto.setCodigo(codigo);
		producto.setNombre(nombre);
		producto.setCantidad(cantidad);
		producto.setPrecio(precio);
		try {
			producto.setCaducidad(sdf.parse(request.getParameter("caducidad")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mS.Conectar();
		producto.setSeccion(mS.getSeccionId(nombre_seccion));
		mS.cerrar();
		
		mP.Conectar();
		mP.modificarProducto(producto);
		mP.cerrar();
		
		request.getRequestDispatcher("VerProductos").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
