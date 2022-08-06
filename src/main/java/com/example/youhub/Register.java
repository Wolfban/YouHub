package com.example.youhub;

/**
 * @author Esteban Barrera
 */
import Interface.DAOUsuario;
import Interface.DAOUsuarioImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Register implements Initializable {

    DAOUsuario daoUsuario = new DAOUsuarioImpl();

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
    void registrarUsuario(ActionEvent event) {
        String nombreUsuario = this.txtNombre.getText();
        String correoUsuario = this.txtEmail.getText();
        String contrasennaUsuario = this.txtContrasenna.getText();
        String contrasennaConfir = this.txtConfirContrasenna.getText();
    }

    @FXML
    void click(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
