package DAO;

import java.sql.*;

public class Conexion {

    private Connection conexion;

    private static Conexion instance;

    private Conexion(){

    }

    public static Conexion getInstance(){
        if(instance==null){
            instance = new Conexion();
        }

        return instance;
    }

    public Connection openConnection() throws SQLException {
        closeConnection();
        this.conexion = DriverManager.getConnection("","root","Pokemon.2012");

        return this.conexion;
    }

    public void closeConnection() throws SQLException{
        if(this.conexion!=null && !this.conexion.isClosed()){
            this.conexion.close();
        }
    }
}
