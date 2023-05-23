package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Producto;
import clases.ProductoCodComparatorASC;
import clases.ProductoCodComparatorDESC;
import modelos.modeloProducto;

/**
 * Servlet implementation class OrdenarPorCod
 */
@WebServlet("/OrdenarPorCod")
public class OrdenarPorCod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdenarPorCod() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codOrder = request.getParameter("codOrder");
		
		modeloProducto mP = new modeloProducto();
		
		mP.Conectar();
		ArrayList<Producto> productos = mP.verProductos();
		mP.cerrar();
		
		if(codOrder.equals("ASC")) {
				ProductoCodComparatorASC comparadorASC = new ProductoCodComparatorASC();
				productos.sort(comparadorASC);
			
		}else if(codOrder.equals("DESC")) {
				ProductoCodComparatorDESC comparadorDESC = new ProductoCodComparatorDESC();
				productos.sort(comparadorDESC);
			
		}
		
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
