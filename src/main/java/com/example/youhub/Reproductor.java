package com.example.youhub;

import Modelo.Videos;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;

/**
 * @author Esteban Barrera
 */
public class Reproductor implements Initializable {

    public static MediaPlayer Video;
    @FXML
    private HBox Hbox;

    @FXML
    private Label PantallaCompleta;

    @FXML
    private Label TiempoTotal;

    @FXML
    private Label TiempoVid;

    @FXML
    private Label Velocidad;
    @FXML
    private MediaView Vid;

    private Media mediaVid;


    @FXML
    private Slider VidDuracion;

    @FXML
    private HBox Volumen;

    @FXML
    private Slider Volumenn;

    @FXML
    private Button btnPlayStop;

    @FXML
    private Button btonAgregarALista;

    @FXML
    private Label lblVolumen;

    @FXML
    private AnchorPane scr;

    @FXML
    private VBox vbox;
    @FXML
    private Button btnLista;



    @FXML
    void CLick(ActionEvent event) {

    }
    @FXML
    private Button btnMeGusta;

    @FXML
    void click(ActionEvent event) {

    }


    private boolean FindelVid = false;
    private boolean reproduciendose = true;
    private boolean Silenciado = true;

    private ImageView Like;
    private ImageView Play;
    private ImageView Parar;
    private ImageView Silenciar;
    private ImageView Salir;
    private ImageView FullScreen;
    private ImageView imgVolumen;
    private ImageView Reiniciar;


    @FXML
    private Button btnElegirVid;



    @FXML
    void Click(ActionEvent event)  {


    }



    private static String Lugar;

    public static void setLugar(String lugar) {
        Lugar = lugar;
    }

    /**Esta funci??n, como dice el nombre, inicializa el reproductor en s??. Se encuentran todos los elementos importantes para estructurar el reproductor en el FXML
     *
     * @author Esteban Alonso Barrera Araya
     * @param url URL del archivo de video que se desea reproducir
     * @param resourceBundle utilizado para traducir todo texto presente en el archivo FXML que tenga un %
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        final int Tamanio = 25;

        mediaVid = new Media(new File(Lugar).toURI().toString());
        Video = new MediaPlayer(mediaVid);
        Vid.setMediaPlayer(Video);



        Image imgCorazon = new Image(new File("src/main/resources/com/example/youhub/Like.png ").toURI().toString());
        Like = new ImageView(imgCorazon);
        Like.setFitWidth(Tamanio);
        Like.setFitHeight(Tamanio);

        Image imgPlay = new Image(new File("src/main/resources/com/example/youhub/play.png ").toURI().toString());
        Play = new ImageView(imgPlay);
        Play.setFitHeight(Tamanio);
        Play.setFitWidth(Tamanio);

        Image imgPausa = new Image(new File("src/main/resources/com/example/youhub/pause.png ").toURI().toString());
        Parar = new ImageView(imgPausa);
        Parar.setFitHeight(Tamanio);
        Parar.setFitWidth(Tamanio);

        Image imgfullscreen = new Image(new File("src/main/resources/com/example/youhub/fullscreen.png ").toURI().toString());
        FullScreen = new ImageView(imgfullscreen);
        FullScreen.setFitHeight(Tamanio);
        FullScreen.setFitWidth(Tamanio);

        Image imgreinicio = new Image(new File("src/main/resources/com/example/youhub/restart.png ").toURI().toString());
        Reiniciar = new ImageView(imgreinicio);
        Reiniciar.setFitHeight(Tamanio);
        Reiniciar.setFitWidth(Tamanio);

        Image Volu = new Image(new File("src/main/resources/com/example/youhub/volume.png ").toURI().toString());
        imgVolumen = new ImageView(Volu);
        imgVolumen.setFitHeight(Tamanio);
        imgVolumen.setFitWidth(Tamanio);

        Image imgSilence = new Image(new File("src/main/resources/com/example/youhub/mute.png ").toURI().toString());
        Silenciar = new ImageView(imgSilence);
        Silenciar.setFitHeight(Tamanio);
        Silenciar.setFitWidth(Tamanio);

        Image imgSalir = new Image(new File("src/main/resources/com/example/youhub/exit.png ").toURI().toString());
        Salir = new ImageView(imgSalir);
        Salir.setFitHeight(Tamanio);
        Salir.setFitWidth(Tamanio);

        btnPlayStop.setGraphic(Parar);
        btnMeGusta.setGraphic(Like);
        lblVolumen.setGraphic(Silenciar);
        Velocidad.setText("1x");
        PantallaCompleta.setGraphic(FullScreen);


        btnPlayStop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button Reproduir = (Button) actionEvent.getSource();
                if (FindelVid) {
                    VidDuracion.setValue(0);
                    FindelVid = false;
                    reproduciendose = false;
                }
                if (reproduciendose) {
                    Reproduir.setGraphic(Play);
                    Video.pause();
                    reproduciendose = false;
                } else {
                    Reproduir.setGraphic(Parar);
                    Video.play();
                    reproduciendose = true;
                }

            }
        });


        Hbox.getChildren().remove(Volumenn);
        Video.volumeProperty().bindBidirectional(Volumenn.valueProperty());

        TiempoActual();
        Volumenn.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                Video.setVolume(Volumenn.getValue());
                if (Video.getVolume() != 0.0) {
                    lblVolumen.setGraphic(imgVolumen);
                    Silenciado = false;

                } else {
                    lblVolumen.setGraphic(Silenciar);
                    Silenciado = true;
                }
            }
        });

        Velocidad.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (Velocidad.getText().equals("1x")) {
                    Velocidad.setText("1.5x");
                    Video.setRate(1.5);


                } else if (Velocidad.getText().equals("1.5x")) {
                    Velocidad.setText("2x");
                    Video.setRate(2.0);
                } else {
                    Velocidad.setText("1x");
                    Video.setRate(1.0);
                }
            }
        });
        lblVolumen.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (Silenciado) {
                    lblVolumen.setGraphic(imgVolumen);
                    Volumenn.setValue(0.2);
                    Silenciado = false;

                } else {
                    lblVolumen.setGraphic(Silenciar);
                    Volumenn.setValue(0);
                    Silenciado = true;

                }
            }
        });
        lblVolumen.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (Volumen.lookup("#Volumenn") == null) {
                    Volumen.getChildren().add(Volumenn);
                    Volumenn.setValue(Video.getVolume());
                }
            }
        });
        Volumen.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Volumen.getChildren().remove(Volumenn);

            }
        });
        vbox.sceneProperty().addListener(new ChangeListener<Scene>() {
            @Override
            public void changed(ObservableValue<? extends Scene> observableValue, Scene scene, Scene t1) {
                if (scene == null && t1 != null) {
                    Vid.fitHeightProperty().bind(t1.heightProperty().subtract(Volumen.heightProperty().add(20)));
                }
            }
        });
        PantallaCompleta.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Label label = (Label) mouseEvent.getSource();
                Stage stage = (Stage) label.getScene().getWindow();
                if (stage.isFullScreen()) {
                    stage.setFullScreen(false);
                    PantallaCompleta.setGraphic(FullScreen);
                } else {
                    stage.setFullScreen(true);
                    PantallaCompleta.setGraphic(Salir);
                }
                stage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        if (keyEvent.getCode() == KeyCode.ESCAPE) {
                            PantallaCompleta.setGraphic(FullScreen);
                        }
                    }
                });
            }
        });
        Video.totalDurationProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration duration, Duration t1) {
                VidDuracion.setMax(t1.toSeconds());
                TiempoVid.setText(tenerTiempo(t1));
            }
        });
        VidDuracion.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (!t1) {
                    Video.seek(Duration.seconds(VidDuracion.getValue()));
                }
            }
        });

        VidDuracion.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                double TiempoActual = Video.getCurrentTime().toSeconds();
                if (Math.abs(TiempoActual - t1.doubleValue()) > 0.5) {
                    Video.seek(Duration.seconds(t1.doubleValue()));
                }
                FinaldelVid(TiempoTotal.getText(), TiempoTotal.getText());
            }
        });


        Video.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration duration, Duration t1) {
                if (!VidDuracion.isValueChanging()) {
                    VidDuracion.setValue(t1.toSeconds());
                }
                FinaldelVid(TiempoVid .getText(), TiempoTotal.getText());

            }
        });
        Video.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                btnPlayStop.setGraphic(Reiniciar);
                FindelVid = true;
                if (!TiempoVid.textProperty().equals(TiempoTotal.textProperty())){
                    TiempoVid.textProperty().unbind();
                    TiempoVid.setText(tenerTiempo(Video.getTotalDuration())+ " / ");
                }
            }
        });
    }

    /**Esta funci??n se encarga de determinar la longitud del video
     * @author Esteban
     *
     * @param Tiempo Duraci??n del video
     * @return La cantidad de horas, minutos y segundos pasadas a tiempo real
     */
    public String tenerTiempo(Duration Tiempo) {
        int horas = (int) Tiempo.toHours();
        int minutos = (int) Tiempo.toMinutes();
        int segundos = (int) Tiempo.toSeconds();

        if (segundos > 59) segundos = segundos % 60;
        if (minutos > 59) minutos = minutos % 60;
        if (horas > 59) horas = horas % 60;
        if (horas > 0) return String.format("%d:%02:%02d", horas, minutos, segundos);
        else return String.format("%02d:%02d", minutos, segundos);

    }

    /**La funcion se encarga de determinar cuantos segundos, minutos y horas del video han pasado
     * @author Esteban
     *
     */
    public void TiempoActual() {
        TiempoTotal.textProperty().bind(Bindings.createStringBinding(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return tenerTiempo(Video.getCurrentTime());
            }
        }, Video.currentTimeProperty()));
    }

    /**
     * @author Esteban
     *
     * @param Tiempo Tiempo actual del video
     * @param Tiempototal Longitud del video
     */
    private void FinaldelVid(String Tiempo, String Tiempototal) {
        for (int i = 0; i < Tiempototal.length(); i++) {
            if (Tiempo.charAt(i) != Tiempototal.charAt(i)) {
                FindelVid = false;
                if (reproduciendose) btnPlayStop.setGraphic(Parar);
                else btnPlayStop.setGraphic(Play);
                break;
            } else {
                FindelVid = true;
                btnPlayStop.setGraphic(Reiniciar);
            }
        }




    }

    /**Funci??n encargada de volver al men?? principal
     * @author Esteban
     * @throws IOException Error de excepci??n
     */
    public void closeWindows() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Principal.fxml"));

        Parent root = loader.load();
        Object controlador = loader.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();


    }
}