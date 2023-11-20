package edd_proyecto;

import javax.swing.JOptionPane;

public class UsuarioAdmi extends Usuario{
	private Biblioteca bibliotecaInf;

	public UsuarioAdmi(String nombreUsuario, String password, int codigoUsuario, int tipoUsuario, Biblioteca bibliotecaInf) {
		super(nombreUsuario, password, codigoUsuario, tipoUsuario);
		this.setBibliotecaInf(bibliotecaInf);
<<<<<<< HEAD
		
=======
		// TODO Auto-generated constructor stub
>>>>>>> 683ebda5f27103037320a958f0db260034c1aecb
	}
	
	public void agregarLibros() {
	    String titulo = JOptionPane.showInputDialog("Ingresa el titulo: ");
	    String autor = JOptionPane.showInputDialog("Ingresa el autor: ");
	    String genero = JOptionPane.showInputDialog("Ingresa el genero: ");
	    Integer cantidad_copias = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de cantidad copias: "));
	    String isbn = JOptionPane.showInputDialog("Ingresa el ISBN: ");
	    Libro libro1 = new Libro(titulo, autor, genero, cantidad_copias, isbn);

	    this.bibliotecaInf.libros_biblioteca.add(libro1);
	    JOptionPane.showMessageDialog(null, "Su libro se agregó con exito!");
	}

	


	public Boolean modificarLibros() {
		Libro libroOriginal=null;
		String isbn = JOptionPane.showInputDialog("Ingresa el ISBN del libro a modificar: ");
		for(int i=0; i<this.bibliotecaInf.libros_biblioteca.size(); i++) {
			if (this.bibliotecaInf.libros_biblioteca.get(i).getIsbn()==isbn) {
				libroOriginal = new Libro(this.bibliotecaInf.libros_biblioteca.get(i).getTitulo(),
						
						this.bibliotecaInf.libros_biblioteca.get(i).getAutor(),
						this.bibliotecaInf.libros_biblioteca.get(i).getGenero(),
						this.bibliotecaInf.libros_biblioteca.get(i).getCantidad_copias(),
						this.bibliotecaInf.libros_biblioteca.get(i).getIsbn());
				
				this.bibliotecaInf.libros_biblioteca.remove(i);
				this.bibliotecaInf.libros_biblioteca.add(libroOriginal);
				break;
			}
			if( i == this.bibliotecaInf.libros_biblioteca.size()-1) {
				JOptionPane.showMessageDialog(null, "El isbn ingresado no existe.");
				return false;
			}
		}
		
		Libro libroRespaldo = null;

        // Mostrar los datos originales del libro
        JOptionPane.showMessageDialog(null, "Datos originales del libro:\n" + libroOriginal.toString());

        String respuesta = JOptionPane.showInputDialog("¿Deseas cambiar algo del libro? (si/no)");

        if (respuesta.trim().equalsIgnoreCase("si")) {
            libroRespaldo = new Libro(libroOriginal.getTitulo(), 
            		libroOriginal.getAutor(),
            		libroOriginal.getGenero(),
            		libroOriginal.getCantidad_copias(),
            		libroOriginal.getIsbn()); // Crear un respaldo del libro original

            // Lógica para modificar el libro
            String nuevoTitulo = JOptionPane.showInputDialog("Ingresa el nuevo título o deja en blanco");
            if (!nuevoTitulo.isEmpty()) {
                libroOriginal.setTitulo(nuevoTitulo);
               
            }

            String nuevoAutor = JOptionPane.showInputDialog("Ingresa el nuevo autor o deja en blanco");
            if (!nuevoAutor.isEmpty()) {
                libroOriginal.setAutor(nuevoAutor);
             
            }

            String nuevoGenero = JOptionPane.showInputDialog("Ingresa el nuevo género o deja en blanco");
            if (!nuevoGenero.isEmpty()) {
                libroOriginal.setGenero(nuevoGenero);
               
            }

            String nuevaCantidadCopiasStr = JOptionPane.showInputDialog("Ingresa la nueva cantidad de copias o deja en blanco");
            if (!nuevaCantidadCopiasStr.isEmpty()) {
                try {
                    int nuevaCantidadCopias = Integer.parseInt(nuevaCantidadCopiasStr);
                    libroOriginal.setCantidad_copias(nuevaCantidadCopias);
                   
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Cantidad de copias ingresada no válida");
                }
            }

            String nuevoIsbn = JOptionPane.showInputDialog("Ingresa el nuevo ISBN o deja en blanco");
            if (!nuevoIsbn.isEmpty()) {
                libroOriginal.setIsbn(nuevoIsbn);
               
            }
            

             JOptionPane.showMessageDialog(null, "Libro Actualizado" );
        }
        return true;
	}
	
	public boolean eliminarLibros() {
		String isbn = JOptionPane.showInputDialog("Ingresa el ISBN del libro a eliminar: ");
		for(int i=0; i<this.bibliotecaInf.libros_biblioteca.size(); i++) {
			if (this.bibliotecaInf.libros_biblioteca.get(i).getIsbn()==isbn) {
				this.bibliotecaInf.libros_biblioteca.remove(i);
				break;
			}
			if( i == this.bibliotecaInf.libros_biblioteca.size()-1) {
				JOptionPane.showMessageDialog(null, "El isbn ingresado no existe.");
				return false;
			}
		}
		 JOptionPane.showMessageDialog(null, "Libro Eliminado" );
		 return true;
	}

	public Biblioteca getBibliotecaInf() {
		return bibliotecaInf;
	}

	public void setBibliotecaInf(Biblioteca bibliotecaInf) {
		this.bibliotecaInf = bibliotecaInf;
	}
	
	

}
