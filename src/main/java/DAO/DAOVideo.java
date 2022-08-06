package DAO;

import Modelo.Videos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOVideo {
    public int agregarVideo(Videos v) throws SQLException {
        Conexion conexion = Conexion.getInstance();

        String insertVideo = "INSERT INTO video(nombre, categoria, descripcion, fechasubido, ubicacionlocal) VALUES (?, ?, ?, ?, ?)";

        try(Connection conexionBase = conexion.openConnection()){
            try(PreparedStatement st = conexionBase.prepareStatement(insertVideo)){
                st.setString(1, v.getNombre());
                st.setString(2, v.getCategoria());
                st.setString(3, v.getDescripcion());
                st.setString(4, v.getFechaSubido());
                st.setString(5, v.getUbicacionLocal());

                return st.executeUpdate();
            }
        }
    }
}
