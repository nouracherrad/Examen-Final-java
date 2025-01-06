package com.example.examfinaljava.application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
package com.example.restaurantapp.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // Charger la première vue (selection-view.fxml)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/selection-view.fxml"));
            Scene scene = new Scene(loader.load());

            // Configurer la fenêtre principale
            primaryStage.setTitle("Restaurant En Ligne");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
