package edd_proyecto;

import java.util.Date;

import javax.swing.JOptionPane;

public class UsuarioCliente extends Usuario {
    private Libro libroPrestado;
    private float multa;
    private Date fechaPrestacion;

    public UsuarioCliente(String nombreUsuario, String password, int codigoUsuario, int tipoUsuario, Libro libroPrestado, float multa, Date fechaPres) {
        super(nombreUsuario, password, codigoUsuario, tipoUsuario);
        this.libroPrestado = libroPrestado;
        this.multa = multa;
        this.fechaPrestacion = fechaPres;
    }

    public Libro getLibroPrestado() {
        return libroPrestado;
    }

    public void setLibroPrestado(Libro libroPrestado) {
        this.libroPrestado = libroPrestado;
    }

    public void prestarLibro(Libro libro, Date fechaPrestamo) {
        if (libroPrestado == null) {
        	if(libroPrestado.getCantidad_copias() > 0) {
        		libro.setCantidad_copias(libro.getCantidad_copias()-1);
                libroPrestado = libro;
                fechaPrestacion = fechaPrestamo;
                JOptionPane.showMessageDialog(null, "Libro prestado");
        	}else {
        		JOptionPane.showMessageDialog(null, "No hay copias disponbiles del libro.");
        	}
        	
        } else {
        	JOptionPane.showMessageDialog(null,"Ya tienes un libro prestado. Devuelve el libro actual antes de pedir otro.");
        }
    }

    public boolean devolverLibro(Date fechaDevolucion) {
        String confirmar = null;
    	if (libroPrestado != null) {
        	multa=calcularMulta(fechaDevolucion);
        	confirmar = JOptionPane.showInputDialog(null,"Deje vacio si desea devolver el libro: " + this.libroPrestado.getTitulo());
            if(!confirmar.isEmpty()) {
            	return false;
            }
        	if(multa==0) {
                JOptionPane.showMessageDialog(null,"Libro devuelto correctamente.");
            }else {
                JOptionPane.showMessageDialog(null,"Deuda: "+multa+ "\n PAGAR");
            }
            libroPrestado.setCantidad_copias(libroPrestado.getCantidad_copias()+1);
            libroPrestado = null;
            fechaPrestacion = null;
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"No tienes ningún libro prestado actualmente.");
            return false;
        }
    }

    public float calcularMulta(Date fechaDevolucion) {
        if (libroPrestado != null && fechaPrestacion != null) {
            long tiempoPrestamo = fechaDevolucion.getTime() - fechaPrestacion.getTime();
            int diasPrestamo = (int) (tiempoPrestamo / (1000 * 60 * 60 * 24));
            if (diasPrestamo >5) {
                multa = diasPrestamo * libroPrestado.getCOSTODIA();
                JOptionPane.showMessageDialog(null,"Multa calculada: $" + multa);
            } else {
                JOptionPane.showMessageDialog(null,"No hay multa, el libro fue devuelto a tiempo.");
            }
        } else {
            JOptionPane.showMessageDialog(null,"No tienes ningún libro prestado actualmente.");
        }
        return multa;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }

    public Date getFechaPrestacion() {
        return fechaPrestacion;
    }

    public void setFechaPrestacion(Date fechaPrestacion) {
        this.fechaPrestacion = fechaPrestacion;
    }
}
