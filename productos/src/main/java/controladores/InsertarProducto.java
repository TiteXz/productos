package controladores;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Producto;
import clases.Seccion;
import modelos.modeloProducto;
import modelos.modeloProducto_Supermercado;
import modelos.modeloSeccion;

/**
 * Servlet implementation class InsertarProducto
 */
@WebServlet("/InsertarProducto")
public class InsertarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modeloSeccion mS = new modeloSeccion();
		modeloProducto mP = new modeloProducto();
		modeloProducto_Supermercado mPS = new modeloProducto_Supermercado();
		boolean error = false;
		
		
		
		
		

		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		Double precio = Double.parseDouble(request.getParameter("precio"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nombre_seccion = request.getParameter("nombre_seccion");
		mS.Conectar();
		Seccion id_seccion = mS.getSeccionId(nombre_seccion);
		mS.cerrar();
		
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
		producto.setSeccion(id_seccion);
		
		mP.Conectar();
		ArrayList<Producto> productos = mP.verProductos();
		boolean codigoValidar = mP.getCodigo(codigo);
		mP.cerrar();
		
		
		
			if((codigoValidar!= true) && (precio>= 0) && (cantidad>= 0) && (producto.getCaducidad().after(new Date())) && (!nombre_seccion.equals(""))){
				mP.Conectar();
				mP.InsertarProductos(producto);
				mP.cerrar();
				mPS.Conectar();
				if(request.getParameterValues("supers") != null){
					String[] supers_ids = request.getParameterValues("supers");
					int[] idsSupermercados = Arrays.stream(supers_ids).mapToInt(Integer::parseInt).toArray();
					mPS.InsertarProductos_supers(mPS.getMaxId(), idsSupermercados);
				}
				mPS.cerrar();
				}else {
					error = true;
					request.setAttribute("error", error);
				}
		

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
