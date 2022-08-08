package DAO;

import Modelo.Videos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOVideo {
    /** Esta función intenta accesar a la base de datos, y realiza un try el cuál trabajo es agregar un vídeo con diferentes parámetros a la base de datos ingresados por el Usuario.
     * @author Ignacio Josué Zelada Araya
     * @author Esteban Alonso Barrera Araya
     * @author Isaac Rodolfo Morales Badilla
     * @param v Toma el modelo de Videos para ordenar las características del vídeo que se desea subir.
     * @return Actualiza la base de datos con el video nuevo
     * @throws SQLException Error de SQL
     */
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
        /**La función realiza una conexión a la base de datos para generar la lista de vídeos disponibles en la base de datos en sí
         * @author Ignacio Josué Zelada Araya
         * @author Esteban Alonso Barrera Araya
         * @author Isaac Rodolfo Morales Badilla
         */

        Conexion conexion = Conexion.getInstance();
        List<Videos> lista = null;
        String traerVideos = "SELECT * FROM video";

        try(Connection conexionBase = conexion.openConnection()){
            PreparedStatement st = conexionBase.prepareStatement(traerVideos);
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Videos vid = new Videos();
                vid.setNombre(rs.getString("nombre"));
                vid.setCategoria(rs.getString("categoria"));
                vid.setDescripcion(rs.getString("descripcion"));
                vid.setFechaSubido(rs.getString("fechasubido"));
                vid.setUbicacionLocal(rs.getString("ubicacionlocal"));
                lista.add(vid);
            }
            return lista;
        }
    }

}
