package com.example.youhub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
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

    }

    @FXML
    private Button btnElegirVid;


    @FXML
    void click(ActionEvent event) throws  IOException{
        buscarVideo();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Reproductor .fxml"));
        Parent root = loader.load();
        BusquedadeVideo controlador = loader.getController();
        Scene scene1 = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.show();


        stage.setOnCloseRequest(e -> {
            try {
                controlador.closeWindows();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        Stage myStage = (Stage) this.btnElegirVid.getScene().getWindow();
        myStage.close();
    }
    private String lgar;
    public void buscarVideo(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Video");
        File File = fileChooser.showOpenDialog(null);
        lgar = File.toURI().toString();
        if(lgar != null){
            Media vid = new Media(lgar);
            Reproductor.Video = new MediaPlayer(vid);

            Reproductor.Video.play();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void closeWindows() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BusquedadeVideo.fxml"));

        Parent root = loader.load();
        Object controlador = loader.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();


    }

}


