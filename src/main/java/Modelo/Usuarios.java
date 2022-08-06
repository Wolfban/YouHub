package Modelo;

import java.util.Objects;

/**
 * @author Esteban Barrera
 */
public class Usuarios {
    private String Nombre;
    private String correo;
    private String contrasenna;

    public Usuarios(String nombre, String correo, String contrasenna) {
        Nombre = nombre;
        this.correo = correo;
        this.contrasenna = contrasenna;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "Nombre='" + Nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasenna='" + contrasenna + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuarios)) return false;
        Usuarios usuarios = (Usuarios) o;
        return Nombre.equals(usuarios.Nombre) && correo.equals(usuarios.correo) && contrasenna.equals(usuarios.contrasenna);
    }
    
}
