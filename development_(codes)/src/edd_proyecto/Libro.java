package edd_proyecto;

import javax.swing.JOptionPane;
//import joinery.DataFrame;
public class Libro {
	private String titulo;
	private String autor;
	private String genero;
	private Integer cantidad_copias;
	private String isbn;
	private String estado;
	
	
	
	public Libro(String titulo, String autor, String genero, Integer cantidad_copias, String isbn) {
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.cantidad_copias = cantidad_copias;
		this.isbn = isbn;
		  if (cantidad_copias != 0) {
	            this.setEstado("Disponible");
		  } else {
	            this.setEstado("Ocupado");
		  }
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Integer getCantidad_copias() {
		return cantidad_copias;
	}
	public void setCantidad_copias(Integer cantidad_copias) {
		this.cantidad_copias = cantidad_copias;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void _cambiar_estado(/*dataframe: pd.DataFrame*/int index ) {
		if(estado=="Disponible") {
			cantidad_copias-=1;
			//dataframe.iloc[index, 3] = cantidad_copias;
			//dataframe.to_csv("list_of_books.csv", index=False);
			
			if(cantidad_copias==0) {
				estado = "Ocupado";
				
			}
			
		}
	}
	
	public void _devolver_libro(/*self, dataframe: pd.DataFrame*/ int index) {
		cantidad_copias += 1;
		 //dataframe.iloc[index, 3] = self._cantidad_copias
		 //dataframe.to_csv("list_of_books.csv", index=False)
		
		if(estado=="Ocupado") {
			estado = "Disponible";
		}
		
	}
	
	public void mostrar_libro() {
		JOptionPane.showMessageDialog(null, "\n Titulo: "+titulo);
		JOptionPane.showMessageDialog(null, "\n Autor: "+autor);
		JOptionPane.showMessageDialog(null, "\n Género: "+genero);
		JOptionPane.showMessageDialog(null, "\n ISBN: "+isbn);

	}
	
}
