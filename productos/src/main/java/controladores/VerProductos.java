package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.Producto;
import clases.Seccion;
import modelos.modeloProducto;
import modelos.modeloSeccion;

/**
 * Servlet implementation class VerProductos
 */
@WebServlet("/VerProductos")
public class VerProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		modeloProducto mP = new modeloProducto();
	
		mP.Conectar();
		ArrayList<Producto> productos = mP.verProductos();
		mP.cerrar();
		
		HttpSession sesion = request.getSession();
		ArrayList<Producto> carrito = (ArrayList<Producto>) sesion.getAttribute("carrito");
		int cantidadCarrito = 0;
		if (carrito != null) {
			cantidadCarrito = carrito.size();
		}
		
		request.setAttribute("carrito", cantidadCarrito);
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
