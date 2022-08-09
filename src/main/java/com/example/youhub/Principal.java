package com.example.youhub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Esteban Barrera
 */

public class Principal {

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
    /**Función encargada de redirigir al usuario al buscador de videos
     * @author Esteban Alonso Barrera Araya
     * @throws IOException error de excepción
     */
    void click(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BuscadorVideos.fxml"));


        Parent root = loader.load();


        BuscadorVideos controlador = loader.getController();


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


}