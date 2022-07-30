package com.example.youhub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Esteban Barrera
 */
public class Reproductor implements Initializable {

    public static MediaPlayer Video;
    @FXML
    private HBox Hbox;

    @FXML
    private Label PantallaCompleta;

    @FXML
    private Label TiempoTotal;

    @FXML
    private Label TiempoVid;

    @FXML
    private Label Velocidad;
    @FXML
    private MediaView Vid;

    private Media mediaVid;


    @FXML
    private Slider VidDuracion;

    @FXML
    private HBox Volumen;

    @FXML
    private Slider Volumenn;

    @FXML
    private Button btnPlayStop;

    @FXML
    private Button btonAgregarALista;

    @FXML
    private Label lblVolumen;

    @FXML
    private AnchorPane scr;

    @FXML
    private VBox vbox;

    private boolean FindelVid = false;
    private boolean reproduciendose = true;
    private boolean Silenciado = true;

    private ImageView Play;
    private ImageView Parar;
    private ImageView Silenciar;
    private ImageView Salir;
    private ImageView FullScreen;
    private ImageView imgVolumen;
    private ImageView Reiniciar;


    @FXML
    void Click(ActionEvent event) {
    buscarVideo();
    }

    @FXML
    void click(ActionEvent event) {

    }
    private String lgar;
    public void buscarVideo(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Video");
        File File = fileChooser.showOpenDialog(null);
        lgar = File.toURI().toString();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}


