package edd_proyecto;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args){
        Biblioteca biblioteca_obj = new Biblioteca();
        AdminArchivo admin = new AdminArchivo();
       //  biblioteca_obj.crear_df()
        MenuUsuario menu_obj = new MenuUsuario(biblioteca_obj, admin);
        admin.crear_listas(menu_obj);
        admin.crear_listas(biblioteca_obj);
        JOptionPane.showMessageDialog(null,"Bienvenido a \"Bukku \" su biblioteca favorita.");
        menu_obj.inicioDeSesion();
        }
    }