package edd_proyecto;
import java.util.*;
import javax.swing.*;

	public class MenuUsuario {
	    private Biblioteca biblioteca;
	    public ArrayList<UsuarioCliente> usuarios_clientes=new ArrayList<>();
	    public ArrayList<UsuarioAdmi> usuarios_admin = new ArrayList<>();
	    private AdminArchivo admin;
	    public MenuUsuario(Biblioteca biblioteca, AdminArchivo admin) {
	        this.biblioteca = biblioteca;
	        this.admin = admin;
	    }
	    
	    public Biblioteca getBiblioteca() {
	        return this.biblioteca;
	    }
	    
	    
	    public void setBiblioteca(Biblioteca biblioteca) {
			this.biblioteca = biblioteca;
		}

		public AdminArchivo getAdmin() {
			return admin;
		}

		public void setAdmin(AdminArchivo admin) {
			this.admin = admin;
		}
		
	    public Integer inicioDeSesion() {
	    	Integer verificar = null;
	    	String usuario = null, password = null;
	    	while(true) {
	    		usuario = JOptionPane.showInputDialog("Ingrese su usuario:");
	    		password = JOptionPane.showInputDialog("Ingrese su contraseña:");
	    		verificar = this.verificarUsuario(usuario, password);
	    		if( verificar != -1) {
	    			break;
	    		}
	    		JOptionPane.showMessageDialog(null, " Error. Nombre de usuario y/o contraseña incorrectos.");
	    	}
	    	JOptionPane.showMessageDialog(null, "Sesión iniciada correctamente.");
	    	if(this.usuarios_clientes.get(verificar).getNombreUsuario().equals(usuario)){
	    		if(this.usuarios_clientes.get(verificar).getPassword().equals(password)) {
	    			this.menuOpciones(verificar);
	    		}
	    	}else {
	    		this.menuAdmin(verificar);
	    	}
	    	return verificar;
	    }
	    
	    public Integer menuOpciones(Integer codigo_usuario) {
	    	Integer eleccion = null, isbn_ubicacion = -1, eleccion_mostrar = null;
	    	String isbn_prestamo = null, buscar_autor = null, buscar_libro = null;
	    	Libro libro_aux = null;
	    	Date fecha_accion = null;
	    	Calendar calendario = Calendar.getInstance();
	    	while(true) {
		    	JOptionPane.showMessageDialog(null, "Bienvenido a la lista de opciones " + this.usuarios_clientes.get(codigo_usuario).getNombreUsuario());
		    	while(true) {
		    		JOptionPane.showMessageDialog(null,"1) Mostrar libros.\n2) Pedir préstamo.\n3) Devolver libro.\n4) Salir.\n5) Cambiar fecha.");
		    		eleccion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opción disponible."));
		    		if(eleccion>0 && eleccion<6) {
		    			break;
		    		}
		    		JOptionPane.showMessageDialog(null, "Error en el dato ingresado.");
		    	}
		    	isbn_prestamo = null;
		    	isbn_ubicacion = -1;
		    	switch(eleccion) {
		    		case 1:
		    			eleccion_mostrar = Integer.parseInt(JOptionPane.showInputDialog("Opciones:\n1) Mostrar todos los libros.\n2)Buscar libros por autores.\n3)Buscar libro especifico.\nIngrese una opcion:"));
		    			switch(eleccion_mostrar) {
		    			case 1:
		    				this.biblioteca.ordenarLibros();
		    				this.biblioteca.mostrarLibros();
		    				break;
		    			case 2:
		    				buscar_autor = null;
		    				buscar_autor = JOptionPane.showInputDialog("Ingrese el autor a buscar:");
		    				this.biblioteca.buscarAutor(buscar_autor);
		    				break;
		    			case 3:
		    				buscar_libro = null;
		    				buscar_libro = JOptionPane.showInputDialog("Ingrese el titulo del libro:");
		    				for(Integer j = 0; j<this.biblioteca.libros_biblioteca.size(); j++) {
		    					if(this.biblioteca.libros_biblioteca.get(j).getTitulo().equals(buscar_libro)) {
		    						this.biblioteca.mostrarLibro(this.biblioteca.libros_biblioteca.get(j));
		    					}
		    				}
		    				break;
		    			}		    			
		    			break;
		    		case 2:
		    				isbn_prestamo = null;
		    				if(this.usuarios_clientes.get(codigo_usuario).getLibroPrestado() == null) {
				    				isbn_prestamo = JOptionPane.showInputDialog(null,"Ingrese el isbn del libro que desea, deje en blanco si desea regresar al menu:");
				    				isbn_ubicacion = this.biblioteca.buscar_isbn(isbn_prestamo);
				    				if(isbn_ubicacion != -1) {
				    					libro_aux = this.biblioteca.libros_biblioteca.get(isbn_ubicacion);
				    				}
		
				    			if(isbn_ubicacion != -1) {
				    				fecha_accion = new Date();
				    				this.usuarios_clientes.get(codigo_usuario).prestarLibro(libro_aux, fecha_accion);
			    				}	
		    				}else {
		    					fecha_accion = new Date();
		    					this.usuarios_clientes.get(codigo_usuario).prestarLibro(this.usuarios_clientes.get(codigo_usuario).getLibroPrestado(), fecha_accion);
		    				}
		    			break;
		    		case 3:
		    			fecha_accion = new Date();
		    			this.usuarios_clientes.get(codigo_usuario).devolverLibro(fecha_accion);
		    			break;
		    		case 4:
		    			JOptionPane.showMessageDialog(null,"Hasta luego, buen día.");
		    			return -1;
		    		case 5:
		    			if(this.usuarios_clientes.get(codigo_usuario).getFechaPrestacion()!=null) {
		    				calendario.setTime(this.usuarios_clientes.get(codigo_usuario).getFechaPrestacion());
		    				 calendario.add(Calendar.WEEK_OF_YEAR, -1);
		    				this.usuarios_clientes.get(codigo_usuario).setFechaPrestacion(calendario.getTime());
		    			}else {
		    				JOptionPane.showMessageDialog(null, "No tienes libros prestados");
		    			}
		    			break;
				}
		    	this.admin.actualizarCsv(this.biblioteca, this);
	    	}
    	}
	    
	    public Integer menuAdmin(Integer codigo_usuario) {
	    	Integer eleccion = null;
	    	while(true) {
		    	JOptionPane.showMessageDialog(null, "Bienvenido " + this.usuarios_admin.get(codigo_usuario).getNombreUsuario());
		    	while(true) {
		    		eleccion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una de las opciones:\n1) Ingresar libro. \n2) Eliminar libro.\n3) Modificar libro.\n4) Salir.\n:"));
		    		if(eleccion>0 && eleccion<5) {
		    			break;
		    		}
		    		JOptionPane.showMessageDialog(null,"Error. Ingrese un dato válido");
		    	}
		    	switch(eleccion) {
		    	case 1:
		    		this.usuarios_admin.get(codigo_usuario).agregarLibros();
	    			break;
	    		case 2:
	    			this.usuarios_admin.get(codigo_usuario).eliminarLibros();	    			
	    			break;
	    		case 3:
	    			this.usuarios_admin.get(codigo_usuario).modificarLibros();
	    			break;
	    		case 4:
	    			JOptionPane.showMessageDialog(null,"Hasta luego, buen día.");
	    			return -1;
		    	}
		    	this.admin.actualizarCsv(this.biblioteca, this);
	    	}
	    }
	    private Integer verificarUsuario(String nombre_usuario, String password) {
	    	Integer i = null;
	    	for(i = 0; i<this.usuarios_clientes.size(); i++) {
	    		if(this.usuarios_clientes.get(i).getNombreUsuario().equals(nombre_usuario)) {
	    			if(this.usuarios_clientes.get(i).getPassword().equals(password)) {
	    				return i;
	    			}
	    		}
	    	}

	    	for(i = 0; i<this.usuarios_admin.size(); i++) {
	    		if(this.usuarios_admin.get(i).getNombreUsuario().equals(nombre_usuario)) {
	    			if(this.usuarios_admin.get(i).getPassword().equals(password)) {
	    				return i;
	    			}
	    		}
	    	}
	    	return -1;
	    }

	}