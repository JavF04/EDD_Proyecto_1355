package edd_proyecto;
import java.util.*;
import javax.swing.*;
public class Biblioteca {
	ArrayList<Libro> libros_biblioteca = new ArrayList<Libro>();

	public Biblioteca() {
	}
	
	public Integer buscar_isbn(String isbn) {
		Integer i = null;
		for(i=0; i<this.libros_biblioteca.size(); i++) {
			if(this.libros_biblioteca.get(i).getIsbn() == isbn) {
				break;
			}
			if( i == this.libros_biblioteca.size()-1) {
				JOptionPane.showMessageDialog(null, "El isbn ingresado no existe.");
				return -1;
			}
		}
		return i;
	}
	
	
	
}