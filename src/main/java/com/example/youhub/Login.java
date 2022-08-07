package com.example.youhub;

/**
 * @author Esteban Barrera
 */

import Controlador.Almacenamiento;
import DAO.*;
import Modelo.Usuarios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    void loginUsuario(ActionEvent event) throws SQLException {
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
            if(!daoLogIn.ingresarUsuario(correo, contrasenna)){
                    Usuarios usuarioIngresado = new Usuarios(correo);
                    Almacenamiento usuarioActual = new Almacenamiento();
                    usuarioActual.setUsuarioActual(usuarioIngresado);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Listo");
                    alert.setContentText("Se ha registrado correctamente");
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
    void click(ActionEvent event) {

    }

}