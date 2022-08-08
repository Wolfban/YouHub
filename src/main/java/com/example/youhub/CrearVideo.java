package com.example.youhub;

import DAO.*;
import Modelo.Videos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class CrearVideo implements Initializable {

        DAOVideo daoVideo = new DAOVideo();

        @FXML
        private Label Date;

        @FXML
        private Label Video;

        @FXML
        private Button btnAgregar;

        @FXML
        private Button btnSubirVid;


        @FXML
        private TextField txtNombre;

        @FXML
        private TextField txtCategoria;

        @FXML
        private TextArea txtDescripcion;


        private String videoUbicacion = "";


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

                if(videoUbicacion == ""){
                        errorVacio += "Por favor suba un video\n";
                }

                if(errorVacio.isEmpty()){
                        Videos videoNuevo = new Videos(nombre, categoria, descripcion, fechaSubido, videoUbicacion);

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

        /**Función que abre una ventana de explorar archivos, que permite al Usuario subir un video de su elección
         * @author Ignacio Josué Zelada Araya
         * @author Esteban Alonso Barrera Araya
         * @author Isaac Rodolfo Morales Badilla
         */

        public void buscarVideo(){
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Buscar Video");

                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("*All Videos*", "*.*"),
                        new FileChooser.ExtensionFilter("*MP4*", "*.mp4*"),
                        new FileChooser.ExtensionFilter("*MOV*", "*.mov*")
                );

                File videoFile = fileChooser.showOpenDialog(null);
                if (videoFile != null){
                        Video.setText(videoFile.toString());
                        videoUbicacion = videoFile.toString();
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


}
