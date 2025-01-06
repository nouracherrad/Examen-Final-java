package com.example.examfinaljava.application;

import com.example.examfinaljava.classes.*;
import com.example.examfinaljava.service.RestaurantService;
import com.example.examfinaljava.service.RestaurantServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationRestaurant {

    public static void main(String[] args) {
        // Étape 1 : Instanciations
        RestaurantService restaurantService = new RestaurantServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // Étape 2 : Ajouter des données
        restaurantService.ajouterClient(new Client(1, null, "0612345678", "123 Rue principale", "Noura Cherrad"));
        restaurantService.ajouterPlat(new PlatPrincipal(1, "Tajine au poulet", 80, null));
        restaurantService.ajouterSupplement(new Supplement(1, "Frites", 20));
        restaurantService.ajouterSupplement(new Supplement(2, "Poisson", 40));

        // Console : Sélectionner un client
        Client client = restaurantService.retrouverClientParId(1);
        if (client == null) {
            System.out.println("Client introuvable !");
            return;
        }

        System.out.println("Client trouvé : " + client.getNom());

        // Console : Sélectionner un plat principal
        PlatPrincipal plat = restaurantService.retrouverPlatParId(1);
        if (plat == null) {
            System.out.println("Plat principal introuvable !");
            return;
        }

        System.out.println("Plat sélectionné : " + plat.getNom());

        // Console : Afficher les suppléments
        System.out.println("Liste des suppléments disponibles :");
        List<Supplement> supplements = restaurantService.listerTousLesSupplements();
        supplements.forEach(s -> System.out.println(s.getId() + " - " + s.getNom() + " (" + s.getPrix() + " DH)"));

        // Console : Sélectionner des suppléments
        System.out.println("Sélectionnez vos suppléments (IDs séparés par des espaces, ex: 1 2) :");
        String[] choix = scanner.nextLine().split(" ");
        List<Supplement> supplementsChoisis = new ArrayList<>();
        for (String ch : choix) {
            int id = Integer.parseInt(ch);
            Supplement sup = restaurantService.retrouverSupplementParId(id);
            if (sup != null) supplementsChoisis.add(sup);
        }

        // Créer un repas
        Repas repas = new Repas(plat, supplementsChoisis, null);

        System.out.println(">>> Repas créé avec un total de : " + repas.calculerTotal() + " DH");

        // Créer une commande
        List<Repas> repasList = new ArrayList<>();
        repasList.add(repas);
        Commande commande = new Commande(1, client.getId(), repasList);

        // Afficher le ticket
        afficherTicket(client, commande);
    }

    private static void afficherTicket(Client client, Commande commande) {
        System.out.println("=== TICKET DE COMMANDE ===");
        System.out.println("Client : " + client.getNom());
        System.out.println("Adresse : " + client.getAdresse());
        System.out.println("Téléphone : " + client.getTelephone());
        System.out.println("--- Commande ---");
        for (Repas repas : commande.getRepas()) {
            System.out.println("Plat : " + repas.getPlatPrincipal().getNom() + " - Prix : " + repas.getPlatPrincipal().getPrix() + " DH");
            System.out.println("Suppléments :");
            for (Supplement supplement : repas.getSupplements()) {
                System.out.println("  - " + supplement.getNom() + " : " + supplement.getPrix() + " DH");
            }
            System.out.println("Total repas : " + repas.calculerTotal() + " DH");
        }
        System.out.println("----------------");
        System.out.println("Total commande : " + commande.calculerTotalCommande() + " DH");
    }
}
