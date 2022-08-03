package com.example.youhub;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("Reproductor.fxml"));
    stage.setTitle("Wenas");
    stage.setScene(new Scene(root, 900, 900));
    stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}