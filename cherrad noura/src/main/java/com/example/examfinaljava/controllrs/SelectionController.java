package com.example.examfinaljava.controllrs;


import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class SelectionController {

    @FXML
    private ChoiceBox<String> platChoiceBox; // Liste des plats principaux

    @FXML
    private Button suivantButton;

    @FXML
    public void initialize() {
        // Ajouter des plats principaux à la ChoiceBox
        platChoiceBox.getItems().addAll("Tajine au poulet", "Pizza Margherita", "Couscous", "Ravioli");
    }

    @FXML
    public void goToIngredientsView() {
        try {
            // Charger la vue des ingrédients et des suppléments
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ingredients-view.fxml"));
            Scene scene = new Scene(loader.load());

            // Obtenir la valeur sélectionnée
            IngredientsController ingredientsController = loader.getController();
            ingredientsController.setPlatPrincipal(platChoiceBox.getValue());

            Stage stage = (Stage) suivantButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
