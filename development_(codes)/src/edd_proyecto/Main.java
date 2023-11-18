package edd_proyecto;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca_obj = new Biblioteca();
       //  biblioteca_obj.crear_df()
        MenuUsuario menu_obj = new MenuUsuario(biblioteca_obj);
        JOptionPane.showMessageDialog(null,"Bienvenido a \"Bukku \" su biblioteca favorita.");
        if (menu_obj._menu_inicial(menu_obj._validar_usuario) == 0) {
        	 JOptionPane.showMessageDialog(null,"Hasta la proxima");
             
        }
    }

}