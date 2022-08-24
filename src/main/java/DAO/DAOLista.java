package DAO;

import Modelo.ListaDeReproduccion;
import Modelo.Videos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Esteban Barrera
 */
public class DAOLista {
    public int agregarLista(ListaDeReproduccion l) throws SQLException {
        Conexion conexion = Conexion.getInstance();

        String insertLista = "INSERT INTO listareproduccion(nombre, descripcion) VALUES (?, ?)";

        try(Connection conexionBase = conexion.openConnection()){
            try(PreparedStatement st = conexionBase.prepareStatement(insertLista)){
                st.setString(1, l.getNombre());
                st.setString(2, l.getDescripcion());
                return st.executeUpdate();
            }
        }
    }
    public List<ListaDeReproduccion> listarListas() throws SQLException{
        /**La función realiza una conexión a la base de datos para generar la lista de vídeos disponibles en la base de datos en sí
         * @author Ignacio Josué Zelada Araya
         * @author Esteban Alonso Barrera Araya
         * @author Isaac Rodolfo Morales Badilla
         */

        Conexion conexion = Conexion.getInstance();
        List<ListaDeReproduccion> lista = null;
        String traerListas = "SELECT * FROM listareproduccion";
        try(Connection conexionBase = conexion.openConnection()){
            PreparedStatement st = conexionBase.prepareStatement(traerListas);
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                ListaDeReproduccion play = new ListaDeReproduccion();
                play.setNombre(rs.getString("nombre"));
                play.setDescripcion(rs.getString("descripcion"));
                lista.add(play);
            }
            return lista;
        }
    }
}
