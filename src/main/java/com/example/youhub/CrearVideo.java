package com.example.youhub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CrearVideo implements Initializable {

        @FXML
        private DatePicker Date;

        @FXML
        private TextField Video;

        @FXML
        private Button btnAgregar;

        @FXML
        private Button btnSubirVid;

        @FXML
        private Label lblVideo;

        @FXML
        private TextField txt;

        @FXML
        private TextField txtCategoria;

        @FXML
        private TextArea txtDescripcion;

        @FXML
        private AnchorPane txtNombre;

        @FXML
        void Click(ActionEvent event) {

        }

        @FXML
        void click(ActionEvent event) {

        }


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

        }
}
