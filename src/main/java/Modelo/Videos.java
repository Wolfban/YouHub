package Modelo;

import java.util.Objects;

/**
 * @author Esteban Barrera
 */
public class Videos {

    private String nombre;

    private String categoria;

    private String descripcion;


    private String fechaSubido;

    private String ubicacionLocal;

    public Videos(String nombre, String categoria, String descripcion, String fechaSubido, String ubicacionLocal) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.fechaSubido = fechaSubido;
        this.ubicacionLocal = ubicacionLocal;
    }

    public Videos(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaSubido() {
        return fechaSubido;
    }

    public void setFechaSubido(String fechaSubido) {
        this.fechaSubido = fechaSubido;
    }

    public String getUbicacionLocal() {
        return ubicacionLocal;
    }

    public void setUbicacionLocal(String ubicacionLocal) {
        this.ubicacionLocal = ubicacionLocal;
    }

    @Override
    public String toString() {
        return "Videos{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaSubido='" + fechaSubido + '\'' +
                ", ubicacionLocal='" + ubicacionLocal + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Videos)) return false;
        Videos videos = (Videos) o;
        return nombre.equals(videos.nombre) && categoria.equals(videos.categoria) && descripcion.equals(videos.descripcion) && fechaSubido.equals(videos.fechaSubido) && ubicacionLocal.equals(videos.ubicacionLocal);
    }

}
