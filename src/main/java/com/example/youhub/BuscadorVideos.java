package com.example.youhub;

import DAO.DAOVideo;
import Modelo.Videos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
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

            FilteredList<Videos> filtroData = new FilteredList<>(listaVideos, b -> true);

            searchBar.textProperty().addListener((observable, oldValue, newvalue)->{
                filtroData.setPredicate(Videos ->{
                    if(newvalue.isEmpty() || newvalue.isBlank() || newvalue == null){
                        return true;
                    }

                    String palabraClave = newvalue.toLowerCase();

                    if(Videos.getNombre().toLowerCase().indexOf(palabraClave) > -1){
                        return true;
                    }else if (Videos.getCategoria().toLowerCase().indexOf(palabraClave) > -1){
                        return true;
                    }else if(Videos.getFechaSubido().toLowerCase().indexOf(palabraClave) > -1){
                        return true;
                    } else
                        return false;

                });
            });

            SortedList<Videos> listaModificada = new SortedList<>(filtroData);

            listaModificada.comparatorProperty().bind(tablaVideos.comparatorProperty());

            tablaVideos.setItems(listaModificada);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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