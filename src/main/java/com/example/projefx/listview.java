package com.example.projefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.*;
import java.io.IOException;

public class listview extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(listview.class.getResource("main-view.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load());
        primaryStage.setTitle("CONTROL PANEL");
        JMetro jMetro = new JMetro(Style.DARK);
        jMetro.setScene(scene2);
        primaryStage.setScene(scene2);
        primaryStage.show();
    }
}
