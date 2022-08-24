package Modelo;

/**
 * @author Esteban Barrera
 */
public class ListaDeReproduccion {
    private String Nombre;
    private String Descripcion;

    public ListaDeReproduccion(String nombre, String descripcion) {
        Nombre = nombre;
        Descripcion = descripcion;
    }
    public  ListaDeReproduccion(){}

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ListaDeReproduccion{" +
                "Nombre='" + Nombre + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListaDeReproduccion)) return false;
        ListaDeReproduccion that = (ListaDeReproduccion) o;
        return getNombre().equals(that.getNombre()) && getDescripcion().equals(that.getDescripcion());
    }


}
