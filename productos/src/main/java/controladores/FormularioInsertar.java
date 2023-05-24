package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Seccion;
import clases.Supermercado;
import modelos.modeloSeccion;
import modelos.modeloSupermercado;

/**
 * Servlet implementation class FormularioInsertar
 */
@WebServlet("/FormularioInsertar")
public class FormularioInsertar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioInsertar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modeloSeccion mS = new modeloSeccion();
		modeloSupermercado mSu = new modeloSupermercado();
		
		mS.Conectar();
		ArrayList<Seccion> secciones = mS.getSecciones();
		mS.cerrar();
		
		mSu.Conectar();
		ArrayList<Supermercado> supermercados = mSu.getSupermercados();
		mSu.cerrar();
		
		request.setAttribute("supermercados", supermercados);
		request.setAttribute("secciones",secciones);
		request.getRequestDispatcher("VistaCrearProducto.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
