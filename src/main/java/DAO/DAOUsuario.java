package DAO;

import Modelo.Usuarios;

import java.sql.*;

public class DAOUsuario {
    /**Esta función intenta conectarse con la base de datos, además de registrar nuevos datos en la tabla usuarios encontrada en la bases de datos
     * @author Ignacio Josueé Zelada Araya
     * @param u Utiliza el modelo disponible en Usuarios.java para registrar un nuevo usuario a la base de datos
     * @return Actualizar la base de datos con el usuario nuevo
     * @throws SQLException Error de SQL
     */
    public int agregarUsuario(Usuarios u) throws SQLException{
        Conexion conexion = Conexion.getInstance();

        String insertUsuario = "INSERT INTO usuario(nombreusuario, correousuario, contrasennausuario) VALUES (?, ?, ?)";

        try(Connection conexionBase = conexion.openConnection()){
            try(PreparedStatement st = conexionBase.prepareStatement(insertUsuario)){
                st.setString(1, u.getNombre());
                st.setString(2, u.getCorreo());
                st.setString(3, u.getContrasenna());

                return st.executeUpdate();
            }
        }
    }

    /** Esta función intenta entrar a la base de datos, además de intentar extraer el correo relacionado con el usuario.
     *@author Ignacio Josueé Zelada Araya
     * @param correo dato STRING que contiene el correo ingresado por el usuario.
     * @return Determinar si el correo existe en la base de datos. True si existe, False si no se encuentra presente.
     * @throws SQLException Error de SQL
     */
    public boolean traerCorreo (String correo) throws SQLException{

        Conexion conexion = Conexion.getInstance();

        String buscarCorreo = "SELECT * FROM usuario WHERE correousuario=?";

        try(Connection conexionBase = conexion.openConnection()){
            try(PreparedStatement st = conexionBase.prepareStatement(buscarCorreo)){
                st.setString(1, correo);
                ResultSet rs = st.executeQuery();

                if (rs.isBeforeFirst()){
                    return true;
                }
            }
        }

        return false;
    }

    /**Funcion que intenta accesar a la base de datos para encontrar si la contrasenña existe en la base de datos.
     * @author Ignacio Josueé Zelada Araya
     * @param contrasenna Contraseña ingresada por el usuario
     * @return Boolean que determina si la contraseña está presente. True para que si existe, False para demostrar que no está.
     * @throws SQLException Error de SQL
     */
    public boolean traerContrasenna (String contrasenna) throws SQLException{
        Conexion conexion = Conexion.getInstance();

        String buscarContrasenna = "SELECT * FROM usuario WHERE contrasennausuario=?";

        try(Connection conexionBase = conexion.openConnection()){
            PreparedStatement st = conexionBase.prepareStatement(buscarContrasenna);
            st.setString(1, contrasenna);
            ResultSet rs = st.executeQuery();

            if (rs.isBeforeFirst()){
                return true;
            }
        }

        return false;
    }

}
