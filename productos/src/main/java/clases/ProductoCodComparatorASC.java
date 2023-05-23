package clases;

import java.util.Comparator;

public class ProductoCodComparatorASC implements Comparator<Producto> {
	 public int compare(Producto p1, Producto p2) {
	        // Devuelve un valor negativo si p1 es menor que p2
	        // Devuelve un valor positivo si p1 es mayor que p2
	        // Devuelve 0 si p1 es igual a p2
		 
	        
	        // comparar por codigo de forma ascendente
	        return p1.getCodigo().toLowerCase().compareTo(p2.getCodigo().toLowerCase());
	    }
}




