package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Producto;
import modelos.modeloProducto;

/**
 * Servlet implementation class FiltrarPrecio
 */
@WebServlet("/FiltrarPrecio")
public class FiltrarPrecio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiltrarPrecio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modeloProducto mP = new modeloProducto();
        
        String maxPrecioStr = request.getParameter("maxPrecio");
        String minPrecioStr = request.getParameter("minPrecio");
        
        Double minPrecio = 0.0;
        Double maxPrecio = 0.0;
        
        if (maxPrecioStr != null && !maxPrecioStr.isEmpty()) {
            maxPrecio = Double.parseDouble(maxPrecioStr);
        }
        
        if (minPrecioStr != null && !minPrecioStr.isEmpty()) {
            minPrecio = Double.parseDouble(minPrecioStr);
        }
        
        mP.Conectar();
        ArrayList<Producto> productos = mP.verProductos();
        mP.cerrar();
        
        Iterator<Producto> iterator = productos.iterator();
        
        while (iterator.hasNext()) {
            Producto producto = iterator.next();
            Double precioActual = producto.getPrecio();
           
            if(minPrecio==0 && maxPrecio==0) {
            	request.setAttribute("productos", productos);
                request.getRequestDispatcher("VistaProductos.jsp").forward(request, response);
        	}else if ((maxPrecio == null || precioActual <= maxPrecio) && (minPrecio == null || precioActual >= minPrecio)) {
            	
            } else {
                iterator.remove();
            }
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
