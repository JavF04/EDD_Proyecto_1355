package edd_proyecto;

import java.io.*;
import java.text.*;
import java.util.*;

public class AdminArchivo {
    String nombre_archivo_libros = null;
    String nombre_archivo_usuarios = null;

    public AdminArchivo() {
        this.nombre_archivo_libros = "src/edd_proyecto/Archives/list_of_books.csv";
        this.nombre_archivo_usuarios = "src/edd_proyecto/Archives/list_of_users.csv";
    }

    public void crear_listas(Biblioteca biblioteca) {
        ArrayList<String[]> datos_separados = new ArrayList<>();
        String titulo = null, autor = null, genero = null, isbn = null;
        Integer copias = null;
        try (BufferedReader br = new BufferedReader(new FileReader(nombre_archivo_libros))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); // Separa los datos por coma
                datos_separados.add(datos); // Agrega los datos a la lista
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Integer i = 0; i < datos_separados.size(); i++) {
            for (Integer j = 0; j < 5; j++) {
                switch (j) {
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

    public void crear_listas(MenuUsuario menu_usuario){

        ArrayList<String[]> datos_separados = new ArrayList<>();
        String nombreUsuario = null, password = null, libroPrestado = null, fecha = null;
        Libro libro_aux = null;
        Biblioteca biblioteca_aux = null;
        Integer codigo = null, tipo = null;
        float multa = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombre_archivo_usuarios))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); // Separa los datos por coma
                datos_separados.add(datos); // Agrega los datos a la lista
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Integer i = 0; i < datos_separados.size(); i++) {
            if (Integer.parseInt(datos_separados.get(i)[3]) == 0) {
                for (Integer j = 0; j < 7; j++) {

                    switch (j) {
                        case 0:
                            nombreUsuario = datos_separados.get(i)[j];
                            break;
                        case 1:
                            password = datos_separados.get(i)[j];
                            break;
                        case 2:
                        	if(datos_separados.get(i)[j] != " ") {
                        		codigo = Integer.parseInt(datos_separados.get(i)[j]);
                        	}
                    		break;
                        case 3:
                        	if(datos_separados.get(i)[j] != " ") {
                        		tipo = Integer.parseInt(datos_separados.get(i)[j]);
                        	}
                            break;
                        case 4:
                        	if(datos_separados.get(i)[j] != " ") {
                        		libroPrestado = datos_separados.get(i)[j];
                        	}
                    		break;
                        case 5:
                        	if(datos_separados.get(i)[j] != " ") {
                        		multa = Float.parseFloat(datos_separados.get(i)[j]);
                        	}
                    		break;
                        case 6:
                        	if(datos_separados.get(i)[j] != " ") {
                        		fecha = datos_separados.get(i)[j];
                        	}
                            break;
                    }//cierra switch
                }//cierra for
                for (int k = 0; k < menu_usuario.getBiblioteca().libros_biblioteca.size(); k++) {
                    if (menu_usuario.getBiblioteca().libros_biblioteca.get(k).getIsbn().equals(libroPrestado)) {
                        libro_aux = menu_usuario.getBiblioteca().libros_biblioteca.get(k);
                        break;
                    }
                }

                String fechaPatron = "yyyy-MM-dd";
                SimpleDateFormat dateFormat = new SimpleDateFormat(fechaPatron);
                Date fecha_aux = null;
				try {
					fecha_aux = dateFormat.parse(fecha);
				} catch (ParseException e) {
					e.printStackTrace();
				}
                UsuarioCliente usuarioCliente_obj_aux = new UsuarioCliente(nombreUsuario, password, codigo, tipo, libro_aux, multa, fecha_aux);
                menu_usuario.usuarios_clientes.add(usuarioCliente_obj_aux);
            } else {

                for (Integer j = 0; j < 6; j++) {

                    switch (j) {
                        case 0:
                            nombreUsuario = datos_separados.get(i)[j];
                            break;
                        case 1:
                            password = datos_separados.get(i)[j];
                            break;
                        case 2:
                            codigo = Integer.parseInt(datos_separados.get(i)[j]);
                            break;
                        case 3:
                            tipo = Integer.parseInt(datos_separados.get(i)[j]);
                            break;
                        case 4:
                            biblioteca_aux = menu_usuario.getBiblioteca();
                            break;

                    }//cierra switch

                }

                UsuarioAdmi usuarioAdmi_obj_aux = new UsuarioAdmi(nombreUsuario, password, codigo, tipo, biblioteca_aux);

                menu_usuario.usuarios_admin.add(usuarioAdmi_obj_aux);
            }//cierra else
        }
        //cierra for principal

    }//cierra funcion crear_lista
    
    public void actualizarCsv(Biblioteca biblioteca, MenuUsuario menu) {
    	String fechaPatron = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(fechaPatron);
        try (BufferedWriter csv_users = new BufferedWriter(new FileWriter(this.nombre_archivo_usuarios, false));
                BufferedWriter csv_books = new BufferedWriter(new FileWriter(this.nombre_archivo_libros, false))) {

            // Actualizar archivo de usuarios
            for (UsuarioCliente usuario : menu.usuarios_clientes) {
            	if(usuario.getFechaPrestacion() == null) {
            		try {
						usuario.setFechaPrestacion(dateFormat.parse("0001-01-01"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
            	}
                String[] userData = {
                        usuario.getNombreUsuario(),
                        usuario.getPassword(),
                        String.valueOf(usuario.getCodigoUsuario()),
                        String.valueOf(usuario.getTipoUsuario()),
                        getNonNullISBN(usuario.getLibroPrestado()),
                        String.valueOf(usuario.getMulta()),
                        new SimpleDateFormat("yyyy-MM-dd").format(usuario.getFechaPrestacion())
                };
                csv_users.write(this.joinStrings(",", userData));
                csv_users.newLine();
            }
            for (UsuarioAdmi usuarioA : menu.usuarios_admin) {
            	String[] userDataA = {
                        usuarioA.getNombreUsuario(),
                        usuarioA.getPassword(),
                        String.valueOf(usuarioA.getCodigoUsuario()),
                        String.valueOf(usuarioA.getTipoUsuario()),
                        ""
            	};
            	csv_users.write(this.joinStrings(",", userDataA));
                csv_users.newLine();
            }

            // Actualizar archivo de libros
            for (Libro libro : biblioteca.libros_biblioteca) {
                String[] bookData = {
                        getNonNull(libro.getTitulo()),
                        getNonNull(libro.getAutor()),
                        getNonNull(libro.getGenero()),
                        String.valueOf(libro.getCantidad_copias()),
                        getNonNull(libro.getIsbn())
                };
                csv_books.write(this.joinStrings(",", bookData));
                csv_books.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private String getNonNull(String value) {
        return value != null ? value : ""; // Si el valor es nulo, retorna una cadena vacía
    }

    private String getNonNullISBN(Libro libro) {
        return libro != null ? libro.getIsbn() : ""; // Si el libro es nulo, retorna una cadena vacía
    }
    
    public String joinStrings(String coma, String[] strings) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
        	string.append(strings[i]);
            if (i < strings.length - 1) {
            	string.append(coma);
            }
        }
        return string.toString();
    }
}
