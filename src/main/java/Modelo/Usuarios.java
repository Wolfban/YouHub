package Modelo;

/**
 * @author Esteban Barrera
 */
public class Usuarios {
    private String Nombre;
    private String Apellido1;
    private String Apellido2;
    private String Direccion;
    private int ID;

    private String Email;


    public Usuarios(String nombre, String apellido1, String apellido2, String direccion, int ID, String Email) {
        Nombre = nombre;
        Apellido1 = apellido1;
        Apellido2 = apellido2;
        Direccion = direccion;
        this.Email = Email;
        this.ID = ID;
    }

    public Usuarios(String nombre, String primerApellido, String segundoApellido, String direccion, String correo, int id) {
        Nombre = nombre;
        Apellido1 = primerApellido;
        Apellido2 = segundoApellido;
        Direccion = direccion;
        Email = correo;
        ID = id;

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String apellido1) {
        Apellido1 = apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String apellido2) {
        Apellido2 = apellido2;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuarios)) return false;
        Usuarios usuarios = (Usuarios) o;
        return getID() == usuarios.getID();

    }



    @Override
    public String toString() {
        return "Usuarios{" +
                "Nombre='" + Nombre + '\'' +
                ", Apellido1='" + Apellido1 + '\'' +
                ", Apellido2='" + Apellido2 + '\'' +
                ", Direccion='" + Direccion + '\'' +
                ", ID=" + ID +
                ", Email='" + Email + '\'' +
                '}';
    }
}
