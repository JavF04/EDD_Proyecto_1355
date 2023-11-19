package edd_proyecto;
import java.util.*;
//import javax.swing.JOptionPane;

	public class MenuUsuario {
	    private Biblioteca biblioteca;
	    ArrayList<Usuario> usuarios=new ArrayList<>();
	    public MenuUsuario(Biblioteca biblioteca) {
	        this.biblioteca = biblioteca;

	    }
	    
	    public Biblioteca getBiblioteca() {
	        return this.biblioteca;
	    }
	    
	    
	    public void setBiblioteca(Biblioteca biblioteca) {
			this.biblioteca = biblioteca;
		}

	    
	    }


