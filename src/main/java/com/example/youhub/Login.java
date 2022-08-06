package com.example.youhub;

/**
 * @author Esteban Barrera
 */

import DAO.*;
import Modelo.Usuarios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Login {

    DAOUsuario daoUsuario = new DAOUsuario();

    @FXML
    private TextField TxtContrasenna;

    @FXML
    private Button btnIniciar;

    @FXML
    private Button btnRegistrarse;

    @FXML
    private TextField txtEmail;

    @FXML
    void loginUsuario(ActionEvent event) throws SQLException {
        String correo = this.txtEmail.toString();
        String contrasenna = this.TxtContrasenna.toString();

        String errorVacio = "";

        if(correo == ""){
            errorVacio += "Por favor ingrese su correo\n";
        }

        if(contrasenna == ""){
            errorVacio += "Por favor ingrese su contrasenna\n";
        }

        if(errorVacio.isEmpty()){
            Usuarios loginUsuario = new Usuarios(correo, contrasenna);

            if(daoUsuario.loginUsuario(loginUsuario)!=""){

            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("No existe es usuario");
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