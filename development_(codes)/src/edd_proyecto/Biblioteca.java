package edd_proyecto;
import java.util.*;
import javax.swing.*;
public class Biblioteca {
	public class Usuario{
		public ArrayList<Libro> libros_prestados = new ArrayList<Libro>();
		public Libro libros_reservados = null;
		public boolean reserva = true;
		public String isbn = "0";
	}
	ArrayList<Libro> libros_biblioteca = new ArrayList<Libro>();

	public Biblioteca() {
	}
	/*public crear_df() {
		this.df_lista_libros = pd.read_csv("list_of_books.csv");
	}
	*/
	public Integer prestar_libro(Usuario usuario /*, admin_df*/ ) {
		Libro libro_obj;
		if(usuario.libros_prestados.size()>=3) {
			JOptionPane.showMessageDialog(null,"No se pueden pedir mas libros puesto que ya tiene 3 en posesion.");
		}else {
			while(true) {
				JOptionPane.showMessageDialog(null,"Bienvenido a la interfaz para pedir prestamos.\nSe le recuerda que solo puede pedir 3 libros simultaneamente");
				String libro = JOptionPane.showInputDialog(null, "Ingrese el titulo del libro tal cual esta escrito en mostrar libros (si desea salir ingrese 1):");
				if(libro == "1") {
					return 1;
				}else {
					/*if (admin_df.iterar_valores_filas(libro,0) == False) {
	                    print("Libro no encontrado, vuelva a intentarlo.")
					}else{*/
					break;
				}
			}
			while(true) {
				JOptionPane.showMessageDialog(null, "El libro seleccionado es:" /*+ admin_df.dataframe.iloc[admin_df._index,0]*/);
				String confirmar = JOptionPane.showInputDialog(null,"Si quiere este libro ingrese \"1\" sino ingrese \"2\":");
				if (confirmar == "1") {
					/*if (admin_df.dataframe.iloc[admin_df._index,3] == 0) {
                        print("No hay copias disponibles.")
					}else{}*/
					/*libro_obj = Libro(
                            admin_df.dataframe.iloc[admin_df._index,0],
                            admin_df.dataframe.iloc[admin_df._index,1],
                            admin_df.dataframe.iloc[admin_df._index,2],
                            admin_df.dataframe.iloc[admin_df._index,3],
                            admin_df.dataframe.iloc[admin_df._index,4]
                        );*/
					libro_obj = null;
					usuario.libros_prestados.add(libro_obj);
					/*libro_obj.mostrar_libro()
                    libro_obj._cambiar_estado(admin_df.dataframe,
                                              admin_df.index)*/
                   JOptionPane.showMessageDialog(null,"Libro prestado con exito. Recuerda guardar el ISBN");
                   break;
				}else if(confirmar == "2") {
					JOptionPane.showMessageDialog(null,"Lastima");
					break;
				}else {
					JOptionPane.showMessageDialog(null,"Ingrese una opcion valida");
				}
			}
		}
		return 0;
	}
	
	public Integer reservar_libro(Usuario usuario /*, admin_df*/) {
		Libro libro_obj = null;
		if (usuario.libros_prestados.size() >= 3 || usuario.reserva == true) {
            if (usuario.reserva == true && usuario.libros_prestados.size()<3){
                while (true) {
                	JOptionPane.showMessageDialog(null,"Ya tiene un libro reservado y es:");
                    //usuario.libros_reservados.mostrar_libro();
                    String eleccion = JOptionPane.showInputDialog(null,"Si desea pedirlo ingrese 1 sino 2:");
                    if (eleccion == "1") {
                        /*admin_df.iterar_valores_filas(usuario.libros_reservados.isbn,4)
                        usuario.libros_reservados._cambiar_estado(admin_df.dataframe,
                                                                admin_df.index)
                        */
                        usuario.libros_prestados.add(usuario.libros_reservados);
                        usuario.libros_reservados = null;
                        usuario.reserva = false;
                        JOptionPane.showMessageDialog(null,"Libro pedido con exito.");
                        return 0;
                    }else if (eleccion == "2") {
                    	JOptionPane.showMessageDialog(null,"Esta bien.");
                        return 0;
                    }else {
                    	JOptionPane.showMessageDialog(null,"Ingrese una opcion valida.");
                    }
                }
            }else if(usuario.reserva == true && usuario.libros_prestados.size()>=3) {
            	JOptionPane.showMessageDialog(null,"No se pueden reservar libros puesto que ya tiene 3 libros.");
            }else {
            	while (true) {
            		JOptionPane.showMessageDialog(null,"Bienvenido a la interfaz para pedir reservas.");
            		String libro = JOptionPane.showInputDialog(null,"Ingrese el titulo del libro tal cual esta escrito en mostrar libros (si desea salir ingrese 1):");
            		if (libro == "1") {
            			return 0;
            		/*if admin_df.iterar_valores_filas(libro,0) == False:
            			print("Libro no encontrado, vuelva a intentarlo.")
            		}else {
            			break;
            		}*/
            		}else {
            			while (true) {
            				JOptionPane.showMessageDialog(null,"El libro seleccionado es:"/*{admin_df.dataframe.iloc[admin_df._index,0]}*/ + libro);
            				String confirmar = JOptionPane.showInputDialog(null,"Si quiere reservar este libro ingrese \"1\" sino ingrese \"2\":");
            				if (confirmar == "1") {
            					/*if (admin_df.dataframe.iloc[admin_df._index,3] == 0) {
            						print("No hay copias disponibles.")}*/
            					//}else {
            					/*libro_obj = Libro(
            							admin_df.dataframe.iloc[admin_df._index,0],
			                            admin_df.dataframe.iloc[admin_df._index,1],
			                            admin_df.dataframe.iloc[admin_df._index,2],
			                            admin_df.dataframe.iloc[admin_df._index,3],
			                            admin_df.dataframe.iloc[admin_df._index,4]
			                        )*/
            					libro_obj = null;          
            					JOptionPane.showMessageDialog(null,"Los datos del libro son:");
            					//libro_obj.mostrar_libro()
            					usuario.libros_reservados = libro_obj;
            					usuario.reserva = true;
            					JOptionPane.showMessageDialog(null,"Libro reservado con exito. Recuerda guardar el ISBN");
            					break;
            				}else if (confirmar == "2") {
            					JOptionPane.showMessageDialog(null,"Que lastima :(");
            					break;
            				}else {
            					JOptionPane.showMessageDialog(null,"Ingrese un numero valido");
            				}
            			}
            		}
            	}
            }
		}
		return 0;
	}
	
	public Integer devolver_libro(Usuario usuario /*, admin_df*/) {
		if (usuario.libros_prestados.size() == 0){
			JOptionPane.showMessageDialog(null,"No tiene libros por devolver.");
		}else {
            while (true) {
            	JOptionPane.showMessageDialog(null,"Los libros que tiene por devolver son:");
                for (Integer i=0; i<usuario.libros_prestados.size(); i++) {
                    //usuario.libros_prestados[i].mostrar_libro();
                	JOptionPane.showMessageDialog(null,"\n\n");
                }
                String seleccion = JOptionPane.showInputDialog(null,"\n\nSi desea devolver alguno, por favor ingrese 1 sino ingrese 2:");
                if (seleccion == "1") {
                    while (true) {
                        String isbn = JOptionPane.showInputDialog(null,"Ingrese el isbn del libro a devolver, ingrese Salir para salir:");
                        for(Integer i=0 ;i<usuario.libros_prestados.size(); i++) {
                            if (usuario.libros_prestados.get(i).toString() == isbn) {
                                while (true) {
                                	JOptionPane.showMessageDialog(null,"Libro encontrado.");
                                    String confirmar = JOptionPane.showInputDialog(null,"Si desea regresarlo ingrese 1 sino ingrese 2:");
                                    if(confirmar == "1") {
                                         /*admin_df.iterar_valores_filas(usuario.libros_prestados[i].titulo,0)
                                         usuario.libros_prestados[i]._devolver_libro(admin_df.dataframe,
                                                                                    admin_df.index)
                                         */
                                         usuario.libros_prestados.remove(i);
                                         JOptionPane.showMessageDialog(null,"Libro regresado con exito.");
                                         return 0;
                                    }else if (confirmar == "2") {
                                    	JOptionPane.showMessageDialog(null,"Adios.");
                                        return 0;
                                    }else {
                                    	JOptionPane.showMessageDialog(null,"Ingrese un dato valido.");
                                    }
                                }
                            }
                        }
                        if (isbn == "Salir"){
                            return 0;
                        }else {
                        	JOptionPane.showMessageDialog(null,"Isbn erroneo, ingreselo correctamente");   
                        }
                    }
                }
               if (seleccion == "2"){
            	   JOptionPane.showMessageDialog(null,"Esta bien");
                    return 0;
               }else {
            	   JOptionPane.showMessageDialog(null,"Ingrese una opcion valida.");
               }
            }
		}
		return 0;
	}
	
}