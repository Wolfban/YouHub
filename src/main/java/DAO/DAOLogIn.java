package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAOLogIn {
    /**
     *Esta función intenta conectarse con la base de datos y realiza un query hecho de antemano con dos datos ingresados por el usuario en la aplicación
     *con el propósito de garantizar acceso al servicio.
     * @author Ignacio Josué Zelada Araya
     * @author Esteban Alonso Barrera Araya
     * @author Isaac Rodolfo Morales Badilla
     * @param correo Corresponde al correo ingresado por el usuario
     * @param contrasenna Corresponde a la contrasenña ingresada por el usuario
     * @return Retorna un booleano normalmente False, que vuelve True en dos casos: Si  o si la supuesta contraseña relacionada con el correo insertado no concuerda de acuerdo a la base de datos.
     * @throws SQLException Error de SQL
     */
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
