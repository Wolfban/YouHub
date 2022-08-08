package com.example.youhub;


import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {

        try {

            FXMLLoader loader = new FXMLLoader();
                loader.setLocation(HelloApplication.class.getResource("BuscadorVideos.fxml"));


            Pane ventana = (Pane) loader.load();


            Scene scene = new Scene(ventana);


            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }}
