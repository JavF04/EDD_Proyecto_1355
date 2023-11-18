package edd_proyecto;

import java.io.*;
import java.util.*;

public class AdminArchivo {
    String nombre_archivo = null;

    public AdminArchivo(boolean eleccion) {
        if (eleccion) {
            this.nombre_archivo = "src/edd_proyecto/Archives/list_of_books.csv";
        } else {
            this.nombre_archivo = "src/edd_proyecto/Archives/list_of_users.csv";
        }
    }

    public void leerArchivo() {
        ArrayList<String[]> datos_separados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombre_archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); // Separa los datos por coma
                datos_separados.add(datos); // Agrega los datos a la lista
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ahora los datos separados están almacenados en la lista 'datos_separados'
        // Puedes acceder a cada conjunto de datos individualmente
        for (String[] datos : datos_separados) {
            for (String dato : datos) {
                System.out.print(dato + " "); // Imprime cada dato separado por espacio
            }
            System.out.println(); // Salto de línea para la siguiente línea de datos
        }
    }
}
