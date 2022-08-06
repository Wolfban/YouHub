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

    public ResultSet loginUsuario(Usuarios u) throws SQLException{
        Conexion conexion = Conexion.getInstance();

        String traerUsuario = "SELECT * FROM usuario WHERE correousuario =? AND  contrasennausuario =?";

        try(Connection conexionBase = conexion.openConnection()){
            try(PreparedStatement st = conexionBase.prepareStatement(traerUsuario)){
                st.setString(1, u.getCorreo());
                st.setString(2, u.getContrasenna());

                return st.executeQuery();
            }
        }
    }
}
