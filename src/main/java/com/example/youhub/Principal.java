package com.example.youhub;

import DAO.DAOLista;
import Modelo.Videos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author Esteban Barrera
 */

public class Principal implements Initializable {

    DAOLista daoLista = new DAOLista();

    @FXML
    private Button btnBuscarVid;

    @FXML
    private Button btnHost;

    @FXML
    private Button btnCrearLista;

    @FXML
    private TableView<?> tblListasReproduccion;

    ObservableList<Videos> listaPlays = FXCollections.observableArrayList();



    @FXML
    void CLick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CrearLista.fxml"));


        Parent root = loader.load();


        CrearLista controlador = loader.getController();


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


        Stage myStage = (Stage) this.btnCrearLista.getScene().getWindow();
        myStage.close();
    }
    @FXML
    void Click(ActionEvent event) {

    }
    @FXML
    /**Función encargada de redirigir al usuario al buscador de videos
     * @author Esteban Alonso Barrera Araya
     * @throws IOException error de excepción
     */
    void click(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BuscadorVideos.fxml"));


        Parent root1 = loader.load();


        BuscadorVideos controlador = loader.getController();


        Scene scene1 = new Scene(root1);
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


        Stage myStage = (Stage) this.btnBuscarVid.getScene().getWindow();
        myStage.close();
    }


    /**Función que se encarga de redigir el usuario a la página de login al cerrar la ventana
     *
     * @author Esteban Alonso Barrera Araya
     *
     * @throws IOException Error de exepción
     */
    public void closeWindows() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));

        Parent root = loader.load();
        Object controlador = loader.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();

        Stage myStage = (Stage) this.btnBuscarVid.getScene().getWindow();
        myStage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}