package com.example.youhub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * @author Esteban Barrera
 */

public class BusquedadeVideo {

    @FXML
    private Button btnBuscarVid;

    @FXML
    private Button btnHost;

    @FXML
    private Button btnJoin;

    @FXML
    private TableView<?> tblListaReciente;

    @FXML
    private TableView<?> tblVistosRecientes;

    @FXML
    void CLick(ActionEvent event) {

    }
    @FXML
    void Click(ActionEvent event) {

    }

    @FXML
    void click(ActionEvent event) {
    buscarVideo();
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


}