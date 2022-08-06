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
    void loginUsuario(ActionEvent event) {

    }

    @FXML
    void click(ActionEvent event) {

    }

}