package DAO;

import java.sql.*;

public class Conexion {

    private Connection conexion;

    private static Conexion instance;

    private Conexion(){

    }

    /** Esta función genera una instancia que debe de preparar una conexión entre la aplicación y la base de datos
     * @author Ignacio Josué Zelada Araya
     * @return devuelve una nueva conexión. En el caso de que instance sea nulo, crea una nueva oportunidad de conexión.
     */
    public static Conexion getInstance(){
        if(instance==null){
            instance = new Conexion();
        }

        return instance;
    }

    /**Esta función aprovecha la instancia generada por la función anterior para abrir una conexión entre la aplicación y la base de datos
     * Se deben cambiar los parámetros url, user y password de acuerdo a los datos correspondientes del usuario para que la aplicación funcione
     *@author Ignacio Josue Zelada Araya

     * @return La conexión creada para enviar y recibir datos entre la aplicación y la base de datos
     * @throws SQLException
     */
    public Connection openConnection() throws SQLException {
        closeConnection();
        this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/YouHub","root","Pokemon.2012");

        return this.conexion;
    }

    public void closeConnection() throws SQLException{
        if(this.conexion!=null && !this.conexion.isClosed()){
            this.conexion.close();
        }
    }
}
