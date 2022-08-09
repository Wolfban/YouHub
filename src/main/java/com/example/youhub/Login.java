package com.example.youhub;

/**
 * @author Esteban Barrera
 */

import Controlador.Almacenamiento;
import DAO.*;
import Modelo.Usuarios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.youhub.Principal;
import java.io.IOException;
import java.sql.SQLException;

public class Login {

    DAOLogIn daoLogIn = new DAOLogIn();

    @FXML
    private TextField txtContrasenna;

    @FXML
    private Button btnIniciar;

    @FXML
    private Button btnRegistrarse;

    @FXML
    private TextField txtEmail;

    @FXML
    /**Esta función se encarga de ayudar al usuario ingresar al sistema con su cuenta registrada en la base de datos
     *
     * @author Ignacio Josue Zelada Araya
     *
     */
    void loginUsuario(ActionEvent event) throws SQLException, IOException {
        Parent root = null;
        String correo = this.txtEmail.getText();
        String contrasenna = this.txtContrasenna.getText();

        String errorVacio = "";

        if(correo == ""){
            errorVacio += "Por favor ingrese su correo\n";
        }

        if(contrasenna == ""){
            errorVacio += "Por favor ingrese su contrasenna\n";
        }

        if(errorVacio.isEmpty()){
            if(!daoLogIn.ingresarUsuario(correo, contrasenna)) {
                Usuarios usuarioIngresado = new Usuarios(correo);
                Almacenamiento usuarioActual = new Almacenamiento();
                usuarioActual.setUsuarioActual(usuarioIngresado);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Listo");
                alert.setContentText("Se ha ingresado correctamente");

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Principal.fxml"));
                Parent root1 = loader.load();
                Principal controlador = loader.getController();
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


                Stage myStage = (Stage) this.btnIniciar.getScene().getWindow();
                myStage.close();


                alert.showAndWait();

                System.out.println(usuarioActual);
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Este usuario no existe");
                alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(errorVacio);
            alert.showAndWait();
        }
    }

    @FXML
    /** Esta función brinda al usuario a la página de registrarse para tener datos para utilizar en la sección de login
     * @author Esteban Alonso Barrera Araya
     */
    void click(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));


        Parent root = loader.load();


        Register controlador = loader.getController();


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


        Stage myStage = (Stage) this.btnRegistrarse.getScene().getWindow();
        myStage.close();
    }

    /**Esta función se encarga de volver a la página de login
     *
     * @author Esteban Alonso Barrera Araya
     * @throws IOException Error de excepción
     */
    public void closeWindows() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));

        Parent root = loader.load();
        Object controlador = loader.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();


    }
}