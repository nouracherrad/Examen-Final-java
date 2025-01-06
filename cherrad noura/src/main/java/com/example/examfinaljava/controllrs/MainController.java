package com.example.examfinaljava.controllrs;



import com.example.examfinaljava.classes.PlatPrincipal;
import com.example.examfinaljava.classes.Supplement;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    // Référence des composants définis dans le FXML
    @FXML
    private ChoiceBox<PlatPrincipal> platPrincipalChoiceBox;
    @FXML
    private VBox supplementBox;
    @FXML
    private Label totalLabel;
    @FXML
    private Button validerButton;

    // Données des plats et suppléments (remplacez par les DAO en production)
    private List<PlatPrincipal> plats = new ArrayList<>();
    private List<Supplement> supplements = new ArrayList<>();
    private List<CheckBox> supplementCheckBoxes = new ArrayList<>();

    private double total = 0.0;

    public void initialize() {
        // Initialiser les données - substituez ces données avec vos DAO
        initialiserDonnees();
        initialiserInterface();
    }

    private void initialiserDonnees() {
        plats.add(new PlatPrincipal(1, "Tajine au poulet", 80, null));
        plats.add(new PlatPrincipal(2, "Couscous", 70, null));
        plats.add(new PlatPrincipal(3, "Pizza Margherita", 90, null));

        supplements.add(new Supplement(1, "Frites", 20));
        supplements.add(new Supplement(2, "Poisson", 40));
        supplements.add(new Supplement(3, "Fromage", 30));
    }

    private void initialiserInterface() {
        // Remplir la ChoiceBox des plats principaux
        platPrincipalChoiceBox.getItems().addAll(plats);

        // Ajouter des CheckBoxes pour chaque supplément
        for (Supplement supplement : supplements) {
            CheckBox checkBox = new CheckBox(supplement.getNom() + " (" + supplement.getPrix() + " DH)");
            supplementCheckBoxes.add(checkBox);
            checkBox.setOnAction(event -> recalculerTotal());
            supplementBox.getChildren().add(checkBox);
        }

        // Écouter les changements dans le choix de plat principal
        platPrincipalChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> recalculerTotal());
    }

    @FXML
    private void handleValiderCommande() {
        // Afficher une boîte de dialogue de confirmation avec le ticket
        Alert ticketAlert = new Alert(Alert.AlertType.INFORMATION);
        StringBuilder ticket = new StringBuilder("=== TICKET ===\n");

        // Ajouter le plat sélectionné
        PlatPrincipal platPrincipal = platPrincipalChoiceBox.getValue();
        if (platPrincipal != null) {
            ticket.append("Plat : ").append(platPrincipal.getNom()).append(" (").append(platPrincipal.getPrix()).append(" DH)\n");
        }

        // Ajouter les suppléments sélectionnés
        ticket.append("Suppléments :\n");
        for (int i = 0; i < supplementCheckBoxes.size(); i++) {
            if (supplementCheckBoxes.get(i).isSelected()) {
                ticket.append("- ").append(supplements.get(i).getNom()).append(" (").append(supplements.get(i).getPrix()).append(" DH)\n");
            }
        }

        // Ajouter le total
        ticket.append("\nTotal : ").append(total).append(" DH");

        // Afficher la boîte de dialogue
        ticketAlert.setTitle("Ticket de Commande");
        ticketAlert.setContentText(ticket.toString());
        ticketAlert.showAndWait();
    }

    private void recalculerTotal() {
        // Recalculer le total (plat principal + suppléments sélectionnés)
        total = 0.0;

        PlatPrincipal platPrincipal = platPrincipalChoiceBox.getValue();
        if (platPrincipal != null) {
            total += platPrincipal.getPrix();
        }

        for (int i = 0; i < supplementCheckBoxes.size(); i++) {
            if (supplementCheckBoxes.get(i).isSelected()) {
                total += supplements.get(i).getPrix();
            }
        }

        // Mettre à jour l'affichage
        totalLabel.setText("Total : " + total + " DH");
    }
}