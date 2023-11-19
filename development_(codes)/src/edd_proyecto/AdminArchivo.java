package edd_proyecto;

import java.io.*;
import java.util.*;

public class AdminArchivo {
    String nombre_archivo_libros = null;
    String nombre_archivo_usuarios = null;

    public AdminArchivo() {
             this.nombre_archivo_libros = "src/edd_proyecto/Archives/list_of_books.csv";
             this.nombre_archivo_usuarios= "src/edd_proyecto/Archives/list_of_users.csv";
         
    }

    public void crear_listas(Biblioteca biblioteca) {
        ArrayList<String[]> datos_separados = new ArrayList<>();
        String titulo=null, autor=null, genero=null, isbn=null;
        Integer copias=null;
        try (BufferedReader br = new BufferedReader(new FileReader(nombre_archivo_libros))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); // Separa los datos por coma
                datos_separados.add(datos); // Agrega los datos a la lista
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Integer i=0; i<datos_separados.size(); i++) {
            	for(Integer j=0; j<5; j++){
            		switch(j) {
            		case 0:
            			titulo = datos_separados.get(i)[j];
            			break;
            		case 1:
            			autor = datos_separados.get(i)[j];
            			break;
            		case 2:
            			genero = datos_separados.get(i)[j];
            			break;
            		case 3:
            			copias = Integer.parseInt(datos_separados.get(i)[j]);
            			break;
            		case 4:
            			isbn = datos_separados.get(i)[j];
            			break;
            		}
            	}
				Libro libro_obj_aux = new Libro(titulo, autor, genero, copias, isbn);	
				biblioteca.libros_biblioteca.add(libro_obj_aux);
        }
        }
    public void crear_listas(MenuUsuario menu_usuario) {
    
            ArrayList<String[]> datos_separados = new ArrayList<>();
            String nombreUsuario=null, password=null;
      
            try (BufferedReader br = new BufferedReader(new FileReader(nombre_archivo_usuarios))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] datos = linea.split(","); // Separa los datos por coma
                    datos_separados.add(datos); // Agrega los datos a la lista
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (Integer i=0; i<datos_separados.size(); i++) {
                	for(Integer j=0; j<5; j++){
                		switch(j) {
                		case 0:
                			nombreUsuario = datos_separados.get(i)[j];
                			break;
                		case 1:
                			password = datos_separados.get(i)[j];
                			break;
                		
                		}
                	}
    				Usuario usuario_obj_aux = new Usuario(nombreUsuario, password,menu_usuario.usuarios.size() );	
    				menu_usuario.usuarios.add(usuario_obj_aux);
            }
            
    }
}