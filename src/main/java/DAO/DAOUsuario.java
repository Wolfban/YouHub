package DAO;

import Modelo.Usuarios;

import java.sql.*;

public class DAOUsuario {
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
