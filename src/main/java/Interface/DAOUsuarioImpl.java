package Interface;

import DAO.Conexion;
import Modelo.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DAOUsuarioImpl extends Conexion implements DAOUsuario {

    @Override
    public void registrar(Usuarios u) throws Exception {
        try {
            this.openConnection();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO usuario(nombreusuario, correousuario, contrasennausuario) VALUES(?)");
            st.setString(1, u.getNombre());
            st.setString(1, u.getCorreo());
            st.setString(1, u.getContrasenna());
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        } finally {
            this.closeConnection();
        }
    }
}
