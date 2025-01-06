package com.example.examfinaljava.ui;


import com.example.examfinaljava.classes.PlatPrincipal;
import com.example.examfinaljava.classes.Supplement;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class MainUI {

    private BorderPane rootPane = new BorderPane(); // Le conteneur principal
    private Label totalLabel = new Label("Total : 0.0 DH");

    private ChoiceBox<PlatPrincipal> platPrincipalChoiceBox;
    private List<CheckBox> supplementCheckBoxes;
    private Button validerButton;

    private double total = 0.0;

    // Liste des plats et suppléments (remplacez par vos DAO)
    private List<PlatPrincipal> plats = new ArrayList<>();
    private List<Supplement> supplements = new ArrayList<>();

    public MainUI() {
        // Initialiser les données - à remplacer plus tard par les DAO
        initialiserDonnees();

        // Construire l'interface utilisateur
        construireInterface();

        // Ajouter les événements
        ajouterEvenements();
    }

    // Initialisation des plats et suppléments : utilisez vos DAO en production
    private void initialiserDonnees() {
        plats.add(new PlatPrincipal(1, "Tajine au poulet", 80, null));
        plats.add(new PlatPrincipal(2, "Couscous", 70, null));
        plats.add(new PlatPrincipal(3, "Pizza Margherita", 90, null));

        supplements.add(new Supplement(1, "Frites", 20));
        supplements.add(new Supplement(2, "Poisson", 40));
        supplements.add(new Supplement(3, "Fromage", 30));
    }

    // Construction de l'interface graphique
    private void construireInterface() {
        VBox selectionBox = new VBox(10);
        selectionBox.setPadding(new Insets(20));

        // 1. Composant pour choisir le plat principal
        platPrincipalChoiceBox = new ChoiceBox<>();
        platPrincipalChoiceBox.getItems().addAll(plats); // Ajouter les plats

        Label platLabel = new Label("Sélectionnez un plat principal :");
        selectionBox.getChildren().addAll(platLabel, platPrincipalChoiceBox);

        // 2. Liste de suppléments avec des cases à cocher
        Label supplementLabel = new Label("Choisissez des suppléments :");
        VBox supplementBox = new VBox(5);
        supplementCheckBoxes = new ArrayList<>();

        for (Supplement supplement : supplements) {
            CheckBox checkBox = new CheckBox(supplement.getNom() + " (" + supplement.getPrix() + " DH)");
            supplementCheckBoxes.add(checkBox);
            supplementBox.getChildren().add(checkBox);
        }

        selectionBox.getChildren().addAll(supplementLabel, supplementBox);

        // 3. Bouton pour valider le choix
        validerButton = new Button("Valider le choix");
        selectionBox.getChildren().addAll(totalLabel, validerButton);

        rootPane.setCenter(selectionBox);
    }

    // Ajouter les événements (recalcule du total, validation du choix)
    private void ajouterEvenements() {
        // Quand le client sélectionne un plat
        platPrincipalChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            recalculerTotal();
        });

        // Quand le client coche/décoche des suppléments
        supplementCheckBoxes.forEach(checkBox -> {
            checkBox.setOnAction(event -> recalculerTotal());
        });

        // Gestion du clic sur "Valider"
        validerButton.setOnAction(event -> {
            afficherTicket();
        });
    }

    // Recalculer le total à chaque changement
    private void recalculerTotal() {
        total = 0.0;

        // Ajouter le prix du plat principal
        PlatPrincipal platPrincipal = platPrincipalChoiceBox.getValue();
        if (platPrincipal != null) {
            total += platPrincipal.getPrix();
        }

        // Ajouter le prix des suppléments cochés
        for (int i = 0; i < supplementCheckBoxes.size(); i++) {
            if (supplementCheckBoxes.get(i).isSelected()) {
                total += supplements.get(i).getPrix();
            }
        }

        // Afficher le total recalculé
        totalLabel.setText("Total : " + total + " DH");
    }

    // Afficher le ticket une fois validé
    private void afficherTicket() {
        Alert ticketAlert = new Alert(Alert.AlertType.INFORMATION);
        StringBuilder ticket = new StringBuilder("=== TICKET ===\n");

        // Ajouter les informations du plat
        PlatPrincipal platPrincipal = platPrincipalChoiceBox.getValue();
        if (platPrincipal != null) {
            ticket.append("Plat : ").append(platPrincipal.getNom()).append(" (").append(platPrincipal.getPrix()).append(" DH)\n");
        }

        // Ajouter les suppléments
        ticket.append("Suppléments sélectionnés :\n");
        for (int i = 0; i < supplementCheckBoxes.size(); i++) {
            if (supplementCheckBoxes.get(i).isSelected()) {
                ticket.append("- ").append(supplements.get(i).getNom()).append(" (").append(supplements.get(i).getPrix()).append(" DH)\n");
            }
        }

        // Ajouter le total
        ticket.append("\nTOTAL : ").append(total).append(" DH");

        ticketAlert.setTitle("Ticket");
        ticketAlert.setContentText(ticket.toString());
        ticketAlert.showAndWait();
    }

    public BorderPane getRootPane() {
        return rootPane;
    }
}