package Controlador;

import Modelo.Usuarios;

import java.util.Objects;

/**
 * @author Esteban Barrera
 */
public class Almacenamiento {
    private Usuarios usuarioActual;

    public Almacenamiento(Usuarios usuarioActual) {
        this.usuarioActual = new Usuarios();
    }

    public Usuarios getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuarios usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    @Override
    public String toString() {
        return "Almacenamiento{" +
                "usuarioActual=" + usuarioActual +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Almacenamiento)) return false;
        Almacenamiento that = (Almacenamiento) o;
        return usuarioActual.equals(that.usuarioActual);
    }
}
