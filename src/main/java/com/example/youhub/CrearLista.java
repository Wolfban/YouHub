package com.example.youhub;

/**
 * @author Esteban Barrera
 */

import Modelo.Videos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class CrearLista {

    @FXML
    private Label Date;

    @FXML
    private Label Video;

    @FXML
    private Button btnSubirLista;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private TextField txtNombre;

    @FXML
    void subirLista(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        apuntaFechas();
    }
    @FXML
    void subirVideo(ActionEvent event) throws SQLException {
        String nombre = this.txtNombre.getText();
        String categoria = this.txtCategoria.getText();
        String descripcion = this.txtDescripcion.getText();
        String fechaSubido = this.Date.getText();

        String errorVacio = "";

        if(nombre == ""){
            errorVacio += "Por favor introduzca un nombre para el video\n";
        }

        if(categoria == ""){
            errorVacio += "Por favor introduzca una categoria\n";
        }

        if(descripcion == ""){
            errorVacio += "Por favor introduzca una descripcion para el video\n";
        }

        if(fechaSubido == ""){
            errorVacio += "Por favor introduzca una fecha\n";
        }


        if(errorVacio.isEmpty()){
            Videos videoNuevo = new Videos(nombre, descripcion, fechaSubido);

            daoVideo.agregarVideo(videoNuevo);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Listo");
            alert.setContentText("Se ha registrado el Video");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(errorVacio);
            alert.showAndWait();
        }
    }

    /**Función que se encarga de resetear la fecha que viene for default y la cambia por la fecha actual de el sistema
     * @author Ignacio Josué Zelada Araya
     * @author Esteban Alonso Barrera Araya
     * @author Isaac Rodolfo Morales Badilla
     */
    public void apuntaFechas (){
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate fechaActual = LocalDate.now();
        Date.setText(formateador.format(fechaActual));
    }

    public void closeWindows() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Principal.fxml"));

        Parent root = loader.load();
        Object controlador = loader.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }

}


