package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Producto;
import modelos.modeloProducto;

/**
 * Servlet implementation class EliminarCheck
 */
@WebServlet("/EliminarCheck")
public class EliminarCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modeloProducto mP = new modeloProducto();
		
		String [] ids_productosStr = request.getParameterValues("idsproductos");
		int[] id_productos =  Arrays.stream(ids_productosStr).mapToInt(Integer::parseInt).toArray();
		
		for (int id_producto : id_productos) {
			mP.Conectar();
			mP.eliminarProducto(id_producto);
			mP.cerrar();
		}
	
		
		mP.Conectar();
		ArrayList<Producto> productos = mP.verProductos();
		mP.cerrar();
		
		request.setAttribute("productos", productos);
		request.getRequestDispatcher("VistaProductos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
