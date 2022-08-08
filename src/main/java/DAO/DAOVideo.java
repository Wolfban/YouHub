package DAO;

import Modelo.Videos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Videos> listarVideos() throws SQLException{
        Conexion conexion = Conexion.getInstance();
        List<Videos> lista = null;
        String traerVideos = "SELECT * FROM video";

        try(Connection conexionBase = conexion.openConnection()){
            PreparedStatement st = conexionBase.prepareStatement(traerVideos);
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Videos vid = new Videos();
                vid.setNombre();
            }
        }
    }
}
