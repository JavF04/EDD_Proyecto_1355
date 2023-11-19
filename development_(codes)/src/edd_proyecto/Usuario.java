package edd_proyecto;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombreUsuario;
    private String password;
    private int codigoUsuario;
    private int tipoUsuario;
  

    public Usuario(String nombreUsuario, String password, int codigoUsuario, int tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.codigoUsuario = codigoUsuario;
        this.tipoUsuario=tipoUsuario;
      
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


    public void setNombreUsuario(String nombre) {
        this.nombreUsuario = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCodigoUsuario(int codigo) {
        this.codigoUsuario = codigo;
    }

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

   
}





