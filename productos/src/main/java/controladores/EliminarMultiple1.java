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
 * Servlet implementation class EliminarMultiple1
 */
@WebServlet("/EliminarMultiple1")
public class EliminarMultiple1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarMultiple1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		modeloProducto mP = new modeloProducto();
		
		String [] codes = request.getParameter("codes").split(",");
		//comprobacion de que todos los codigos estan bien
		boolean codigoValido = true;
		for (String code : codes) {
			if(codigoValido) {
				mP.Conectar();
				
				codigoValido = mP.getCodigo(code.trim());
				mP.cerrar();
			}
		}
		
		//si todo esta bien eliminar
		if(codigoValido == true) {
			for (String code : codes) {
				mP.Conectar();
				mP.eliminarProductoConCode(code.trim());
				mP.cerrar();
			}
			
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
