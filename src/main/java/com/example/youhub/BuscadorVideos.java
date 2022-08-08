package com.example.youhub;

import Modelo.Videos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BuscadorVideos implements Initializable {

    @FXML
    private TextField searchBar;

    @FXML
    private TableView<Videos> tablaVideos;

    @FXML
    private TableColumn<Videos, String> nombreVideo;

    @FXML
    private TableColumn<Videos, String> categoriaVideo;

    @FXML
    private TableColumn<Videos, String> descripcionVideo;

    @FXML
    private TableColumn<Videos, String> fechaSubidoVideo;

    @FXML
    private TableColumn<Videos, String> ubicacionVideo;

    ObservableList<Videos> ListaVideos = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
