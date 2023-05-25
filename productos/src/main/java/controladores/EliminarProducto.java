package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Producto;
import modelos.modeloProducto;
import modelos.modeloProducto_Supermercado;

/**
 * Servlet implementation class EliminarProducto
 */
@WebServlet("/EliminarProducto")
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modeloProducto mP = new modeloProducto();
		modeloProducto_Supermercado mPS = new modeloProducto_Supermercado();
		
		String codigo = request.getParameter("codigo");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		
		mP.Conectar();
		int id_producto = mP.getIdProducto(codigo).getId();
		boolean relacionConSupermercado = mP.relacionConSupermercado(id_producto);
		
		mP.cerrar();
		
		System.out.println(relacionConSupermercado);
		if(cantidad > 0) {
			mP.Conectar();
			mP.restar1(id_producto);
			mP.cerrar();
		}else if (relacionConSupermercado == true && cantidad == 0) {
			mPS.Conectar();
			mPS.eliminarProduDeSupers(id_producto);
			mPS.cerrar();
		}else if(relacionConSupermercado == false && cantidad == 0){
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
