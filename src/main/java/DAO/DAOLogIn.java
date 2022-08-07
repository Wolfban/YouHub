package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOLogIn {
    public boolean ingresarUsuario (String correo, String contrasenna) throws SQLException {
        Conexion conexion = Conexion.getInstance();

        boolean hayError = false;
        String buscarUsuario = "SELECT contrasennausuario FROM usuario WHERE correousuario=?";

        try(Connection conexionBase = conexion.openConnection()){
            PreparedStatement st = conexionBase.prepareStatement(buscarUsuario);
                st.setString(1, correo);
                ResultSet rs = st.executeQuery();

                if (!rs.isBeforeFirst()) {
                    hayError=true;
                }else{
                   while(rs.next()){
                      String contrasennaEncontrada = rs.getString("contrasennausuario");
                      if (!contrasennaEncontrada.equals(contrasenna)){
                        hayError=true;
                      }
                   }
                }
        }

        return hayError;
    }
}
