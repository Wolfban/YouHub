package com.example.youhub;

/**
 * @author Esteban Barrera
 */
import DAO.*;
import Modelo.Usuarios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Register implements Initializable {

    DAOUsuario daoUsuario =  new DAOUsuario();

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField txtConfirContrasenna;

    @FXML
    private TextField txtContrasenna;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombre;



    @FXML
    void registrarUsuario(ActionEvent event) throws SQLException {
        String nombreUsuario = this.txtNombre.getText();
        String correoUsuario = this.txtEmail.getText();
        String contrasennaUsuario = this.txtContrasenna.getText();
        String contrasennaConfir = this.txtConfirContrasenna.getText();

        String errorVacio = "";

        if(nombreUsuario == ""){
            errorVacio += "Por favor ingrese su nombre\n";
        }

        if(correoUsuario == ""){
            errorVacio += "Por favor ingrese su correo\n";
        }

        if(contrasennaUsuario == ""){
            errorVacio += "Por favor ingrese una contrasenna\n";
        }

        if(contrasennaConfir == ""){
            errorVacio += "Por favor ingrese una contrasenna poara comparar\n";
        }

        if (errorVacio.isEmpty()){
            if (contrasennaUsuario.equals(contrasennaConfir)){
                if(daoUsuario.traerCorreo(correoUsuario)==false){
                    Usuarios usuarioNuevo = new Usuarios(nombreUsuario, correoUsuario, contrasennaUsuario);
                    agregarUsuario(usuarioNuevo);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Listo");
                    alert.setContentText("Se ha registrado el Usuario");
                    alert.showAndWait();
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("Este correo ya esta asociado a una cuenta");
                    alert.showAndWait();
                }


            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Las contrasennas no coinciden");
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


    public void agregarUsuario (Usuarios nuevoUsuario) throws SQLException {
        daoUsuario.agregarUsuario(nuevoUsuario);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void CLICK(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));


        Parent root = loader.load();


        Login controlador = loader.getController();


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


        Stage myStage = (Stage) this.btnLogin.getScene().getWindow();
        myStage.close();

    }
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

