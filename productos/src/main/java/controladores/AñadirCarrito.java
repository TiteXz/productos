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
import modelos.modeloProducto;

/**
 * Servlet implementation class AñadirCarrito
 */
@WebServlet("/AñadirCarrito")
public class AñadirCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AñadirCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modeloProducto mP = new modeloProducto();
		
		String codigo = request.getParameter("codigo");
		
		mP.Conectar();
		Producto producto = mP.getProducto(codigo);
		mP.cerrar();
		
		HttpSession sesion = request.getSession();
		ArrayList<Producto> carrito = new ArrayList<Producto>();
		if((ArrayList<Producto>) sesion.getAttribute("carrito") !=null) {
		carrito = (ArrayList<Producto>) sesion.getAttribute("carrito");
		}
		carrito.add(producto);
		
		
		sesion.setAttribute("carrito",carrito);
		response.sendRedirect("VerProductos");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
