package com.example.youhub;

import DAO.DAOVideo;
import Modelo.Videos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    private Button btnRegistrarVid;

    @FXML
    private Button btnReproducirVid;

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

    @FXML
    void Click(ActionEvent event) throws IOException {
        ObservableList<Videos> Seleccion;
        Seleccion = tablaVideos.getSelectionModel().getSelectedItems();
        String Lugar = Seleccion.get(0).getUbicacionLocal();
        Reproductor.setLugar(Lugar);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Reproductor.fxml"));

        Parent root = loader.load();
        Object controlador = loader.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void click(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CrearVideo.fxml"));


        Parent root3 = loader.load();


        CrearVideo controlador = loader.getController();


        Scene scene1 = new Scene(root3);
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


        Stage myStage = (Stage) this.btnRegistrarVid.getScene().getWindow();
        myStage.close();
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