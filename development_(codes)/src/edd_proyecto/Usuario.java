package edd_proyecto;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombreUsuario;
    private String password;
    private int codigoUsuario;
    private List<Libro> librosPrestados;
    private Libro librosReservados;
    private boolean reserva;

    public Usuario(String nombreUsuario, String password, int codigoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.codigoUsuario = codigoUsuario;
        this.librosPrestados = new ArrayList<>();
        this.librosReservados = null;
        this.reserva = false;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public Libro getLibrosReservados() {
        return librosReservados;
    }

    public boolean getReserva() {
        return reserva;
    }

    public void setNombreUsuario(String nombre) {
        this.nombreUsuario = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCodigoUsuario(int codigo) {
        this.codigoUsuario = codigo;
    }

    public void setLibrosReservados(Libro libro) {
        this.librosReservados = libro;
    }

	public void setReserva(boolean reserva) {
		this.reserva = reserva;
	}
}