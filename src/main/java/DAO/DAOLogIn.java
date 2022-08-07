package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOLogIn {
    public boolean traerCorreo (String correo) throws SQLException {
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
