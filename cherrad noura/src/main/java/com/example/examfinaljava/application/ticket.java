package com.example.examfinaljava.application;

import com.example.examfinaljava.classes.*;
import com.example.examfinaljava.implementations.ClientDAO;
import com.example.examfinaljava.implementations.PlatPrincipalDAO;
import com.example.examfinaljava.implementations.SupplementDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ticket {


        public static void main(String[] args) {
            // Étape 1 : Initialiser les DAO
            ClientDAO clientDAO = new ClientDAO();
            PlatPrincipalDAO platPrincipalDAO = new PlatPrincipalDAO();
            SupplementDAO supplementDAO = new SupplementDAO();

            // Étape 2 : Insérer des données directement dans les DAO
            // Ajouter client
            Client client = new Client(1, null, "0612345678", "123 Rue Principale", "noura cherrad");
            clientDAO.ajouterClient(client);

            // Ajouter plat principal
            PlatPrincipal tajinePoulet = new PlatPrincipal(1, "Tajine au poulet", 80, null);
            platPrincipalDAO.ajouterPlat(tajinePoulet);

            // Ajouter suppléments
            supplementDAO.ajouterSupplement(new Supplement(1, "Frites", 20));
            supplementDAO.ajouterSupplement(new Supplement(2, "Poisson", 40));

            // Étape 3 : Simuler l'application console
            Scanner scanner = new Scanner(System.in);

            // Sélectionner un client
            System.out.println("=== BIENVENUE DANS L'APPLICATION RESTAURANT ===");
            System.out.println("Sélectionnez un client : ");
            client = clientDAO.getClientParId(1);
            if (client == null) {
                System.out.println("Client introuvable !");
                return;
            }
            System.out.println("Client sélectionné : " + client.getNom());

            // Sélectionner un plat principal
            System.out.println("Sélectionnez un plat principal (ID=1 : Tajine au poulet) : ");
            PlatPrincipal platPrincipal = platPrincipalDAO.getPlatParId(1);
            if (platPrincipal == null) {
                System.out.println("Plat principal introuvable !");
                return;
            }
            System.out.println("Plat principal sélectionné : " + platPrincipal.getNom());

            // Afficher les suppléments disponibles
            System.out.println("Liste des suppléments disponibles : ");
            List<Supplement> supplements = supplementDAO.getTousLesSupplements();
            supplements.forEach(supplement -> System.out.println(supplement.getId() + " - " + supplement.getNom() + " (" + supplement.getPrix() + " DH)"));

            // Choisir des suppléments
            System.out.println("Sélectionnez vos suppléments (IDs séparés par des espaces, ex: 1 2) : ");
            String[] choixSupplements = scanner.nextLine().split(" ");
            List<Supplement> supplementsChoisis = new ArrayList<>();
            for (String choix : choixSupplements) {
                int idSupplement = Integer.parseInt(choix);
                Supplement supplement = supplementDAO.getSupplementParId(idSupplement);
                if (supplement != null) {
                    supplementsChoisis.add(supplement);
                }
            }
            System.out.println("Suppléments sélectionnés : " + supplementsChoisis);

            // Créer un repas
            Repas repas = new Repas(platPrincipal, supplementsChoisis, null);
            System.out.println("Repas créé avec un total de : " + repas.calculerTotal() + " DH");

            // Créer une commande
            List<Repas> repasList = new ArrayList<>();
            repasList.add(repas);
            Commande commande = new Commande(1, client.getId(), repasList);

            // Afficher le ticket
            System.out.println("=== TICKET DE COMMANDE ===");
            afficherTicket(client, commande);
        }

        private static void afficherTicket(Client client, Commande commande) {
            System.out.println("Client : " + client.getNom());
            System.out.println("Adresse : " + client.getAdresse());
            System.out.println("Téléphone : " + client.getTelephone());
            System.out.println("--- Commande ---");
            for (Repas repas : commande.getRepas()) {
                System.out.println("Plat : " + repas.getPlatPrincipal().getNom() + " - Prix : " + repas.getPlatPrincipal().getPrix() + " DH");
                System.out.println("Suppléments : ");
                for (Supplement supplement : repas.getSupplements()) {
                    System.out.println("  - " + supplement.getNom() + " : " + supplement.getPrix() + " DH");
                }
                System.out.println("Total repas : " + repas.calculerTotal() + " DH");
            }
            System.out.println("----------------");
            System.out.println("Total commande : " + commande.calculerTotalCommande() + " DH");
        }
    }

