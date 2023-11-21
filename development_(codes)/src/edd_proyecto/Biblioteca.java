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
	
	public void mostrarLibros() {
	    JOptionPane.showMessageDialog(null, "La lista de libros es:");
	    for (Libro libro : this.libros_biblioteca) {
	        StringBuilder mensaje = new StringBuilder();
	        mensaje.append("Título: ").append(libro.getTitulo()).append("\n")
	                .append("Autor: ").append(libro.getAutor()).append("\n")
	                .append("Género: ").append(libro.getGenero()).append("\n")
	                .append("Cantidad de Copias: ").append(libro.getCantidad_copias()).append("\n")
	                .append("Estado: ").append(libro.getEstado()).append("\n")
	                .append("ISBN: ").append(libro.getIsbn()).append("\n");
	        JOptionPane.showMessageDialog(null, mensaje.toString());
	    }
	}
	
}