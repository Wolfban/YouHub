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

    public boolean traerUsuario (String correo) throws SQLException{
        Conexion conexion = Conexion.getInstance();

        String buscarUsuario = "SELECT * FROM usuario WHERE correousuario=?";

        try(Connection conexionBase = conexion.openConnection()){
            PreparedStatement st = conexionBase.prepareStatement(buscarUsuario);
            st.setString(1,correo);
            ResultSet rs = st.executeQuery();

            if (rs.isBeforeFirst()){
                return true;
            }
        }

        return false;
    }

    public Usuarios ingresarUsuario(Usuarios u) throws SQLException{
        Conexion conexion = Conexion.getInstance();

        Usuarios usuarioIngresado= null;
        String buscarUsuario = "SELECT * FROM usuario WHERE correousuario=? AND contrasennausuario=?";

        try(Connection conexionBase = conexion.openConnection()){
            PreparedStatement st = conexionBase.prepareStatement(buscarUsuario);
            st.setString(1, u.getCorreo());
            st.setString(2, u.getContrasenna());
            ResultSet rs=st.executeQuery();

            while(rs.next()){
                usuarioIngresado = new Usuarios()
            }
        }
    }

}
