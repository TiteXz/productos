package clases;

import java.util.Comparator;

public class ProductoCodComparatorDESC implements Comparator<Producto> {
	 public int compare(Producto p1, Producto p2) {
	        // Devuelve un valor negativo si p2 es menor que p1
	        // Devuelve un valor positivo si p2 es mayor que p1
	        // Devuelve 0 si p2 es igual a p1
	     
	        // comparar por codigo de forma descendente
	        return p2.getCodigo().toLowerCase().compareTo(p1.getCodigo().toLowerCase());
	    }
}
