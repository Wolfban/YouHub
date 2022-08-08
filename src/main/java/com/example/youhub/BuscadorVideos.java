package com.example.youhub;

import DAO.DAOVideo;
import Modelo.Videos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.PropertyPermission;
import java.util.ResourceBundle;

public class BuscadorVideos implements Initializable {

    DAOVideo daoVideo= new DAOVideo();

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

    ObservableList<Videos> listaVideos = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            listaVideos.addAll(daoVideo.listarVideos());

            nombreVideo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            categoriaVideo.setCellValueFactory(new PropertyValueFactory<>("categoria"));
            descripcionVideo.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
            fechaSubidoVideo.setCellValueFactory(new PropertyValueFactory<>("fechaSubido"));
            ubicacionVideo.setCellValueFactory(new PropertyValueFactory<>("ubicacionLocal"));

            tablaVideos.setItems(listaVideos);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
