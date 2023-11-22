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
			if(this.libros_biblioteca.get(i).getIsbn().equals(isbn)) {
				return i;
			}
		}
		JOptionPane.showMessageDialog(null, "El isbn ingresado no existe.");
		return -1;
	}
	
	public void mostrarLibros() {
	    JOptionPane.showMessageDialog(null, "La lista de libros es:");
	    for (Libro libro : this.libros_biblioteca) {
	        StringBuilder librostr = new StringBuilder();
	        librostr.append("Título: ").append(libro.getTitulo()).append("\n")
	                .append("Autor: ").append(libro.getAutor()).append("\n")
	                .append("Género: ").append(libro.getGenero()).append("\n")
	                .append("Cantidad de Copias: ").append(libro.getCantidad_copias()).append("\n")
	                .append("Estado: ").append(libro.getEstado()).append("\n")
	                .append("ISBN: ").append(libro.getIsbn()).append("\n");
	        JOptionPane.showMessageDialog(null, librostr.toString());
	    }
	}
	
	public void buscarAutor(String autor) {
		for(Integer i=0; i<this.libros_biblioteca.size(); i++) {
			if(this.libros_biblioteca.get(i).getAutor().equals(autor)) {
				mostrarLibro(this.libros_biblioteca.get(i));
			}
		}
	}
	
	public void mostrarLibro(Libro libro) {
		StringBuilder librostr = new StringBuilder();
        librostr.append("Título: ").append(libro.getTitulo()).append("\n")
                .append("Autor: ").append(libro.getAutor()).append("\n")
                .append("Género: ").append(libro.getGenero()).append("\n")
                .append("Cantidad de Copias: ").append(libro.getCantidad_copias()).append("\n")
                .append("Estado: ").append(libro.getEstado()).append("\n")
                .append("ISBN: ").append(libro.getIsbn()).append("\n");
        JOptionPane.showMessageDialog(null, librostr.toString());
	}
	
	public void ordenarLibros() {
        int n = this.libros_biblioteca.size();
        boolean intercambio;
        do {
            intercambio = false;
            for (int i = 0; i < n - 1; i++) {
                if (this.libros_biblioteca.get(i).getTitulo().compareTo(this.libros_biblioteca.get(i + 1).getTitulo()) > 0) {
                    // Si el título en la posición i es mayor que el título en la posición i+1, intercambiar
                    Libro temp = this.libros_biblioteca.get(i);
                    this.libros_biblioteca.set(i, this.libros_biblioteca.get(i + 1));
                    this.libros_biblioteca.set(i + 1, temp);
                    intercambio = true;
                }
            }
        } while (intercambio);
	}
}