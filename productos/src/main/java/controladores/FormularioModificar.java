package controladores;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Producto;
import clases.secciones;
import modelos.modeloProducto;
import modelos.modeloSeccion;

/**
 * Servlet implementation class FormularioModificar
 */
@WebServlet("/FormularioModificar")
public class FormularioModificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioModificar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modeloProducto mP = new modeloProducto();
		modeloSeccion mS = new modeloSeccion();
		
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		mP.Conectar();
		Producto producto = mP.getProducto(codigo);
		mP.cerrar();
		
		mS.Conectar();
		ArrayList<secciones> secciones = mS.getSecciones();
		mS.cerrar();
		
		
		request.setAttribute("secciones",secciones);
		request.setAttribute("producto", producto);
		request.getRequestDispatcher("VistaModificarProducto.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
