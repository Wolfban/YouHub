package DAO;

import Modelo.Usuarios;

import java.sql.SQLException;

public class DAOUsuario {
    public int agregarUsuario(Usuarios u) throws SQLException{
        Conexion conexion = Conexion.getInstance();

        String insertUsuario = "INSERT INTO usuario(nombreusuario, correousuario, contrasennausuario) VALUES (?, ?, ?)";

        try(Connection )
    }
}
