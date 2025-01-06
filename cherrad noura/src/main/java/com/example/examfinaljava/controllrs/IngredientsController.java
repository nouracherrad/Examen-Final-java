package com.example.examfinaljava.controllrs;


import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class IngredientsController {

    @FXML
    private VBox ingredientsBox;

    @FXML
    private VBox supplementsBox;

    @FXML
    private Label totalLabel;

    @FXML
    private Button terminerButton;

    private double total = 0.0;
    private String platPrincipal;

    private final double[] supplementsPrix = {20, 30, 40}; // Prix des suppléments

    @FXML
    public void initialize() {
        // Ajouter des ingrédients par défaut
        ingredientsBox.getChildren().addAll(
                new CheckBox("Poulet"),
                new CheckBox("Légumes"),
                new CheckBox("Riz")
        );

        // Ajouter des suppléments
        supplementsBox.getChildren().addAll(
                createSupplementCheckbox("Fromage", 20),
                createSupplementCheckbox("Frites", 30),
                createSupplementCheckbox("Poisson", 40)
        );
    }

    // Méthode pour créer des CheckBox et recalculer le total
    private CheckBox createSupplementCheckbox(String name, double price) {
        CheckBox checkBox = new CheckBox(name + " (" + price + " DH)");
        checkBox.setOnAction(event -> recalculerTotal());
        return checkBox;
    }

    public void setPlatPrincipal(String plat) {
        platPrincipal = plat;
        total = plat.equals("Pizza Margherita") ? 90 : 80; // Exemple de prix par plat
        recalculerTotal();
    }

    public void recalculerTotal() {
        total = platPrincipal != null ? total : 0.0;

        for (var child : supplementsBox.getChildren()) {
            CheckBox checkBox = (CheckBox) child;
            if (checkBox.isSelected()) {
                total += supplementsPrix[supplementsBox.getChildren().indexOf(child)];
            }
        }
        totalLabel.setText("Total : " + total + " DH");
    }

    @FXML
    public void goToTicketView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ticket-view.fxml"));
            Scene scene = new Scene(loader.load());
            TicketController ticketController = loader.getController();
            ticketController.setTicketInfo(platPrincipal, totalLabel.getText());

            Stage stage = (Stage) terminerButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
