package com.example.examfinaljava.implementations;
import com.example.examfinaljava.classes.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

        private List<Client> clients; // Liste pour stocker les clients

        // Constructeur
        public ClientDAO() {
            this.clients = new ArrayList<>();
        }

        // Méthode pour ajouter un nouveau client (Create)
        public void ajouterClient(Client client) {
            clients.add(client);
            System.out.println("Client ajouté : " + client.getNom());
        }

        // Méthode pour récupérer un client par son ID (Read)
        public Client getClientParId(int id) {
            for (Client client : clients) {
                if (client.getId() == id) {
                    return client;
                }
            }
            System.out.println("Aucun client trouvé avec l'ID : " + id);
            return null;
        }

        // Méthode pour mettre à jour un client (Update)
        public void mettreAJourClient(int id, String nom, String adresse, String telephone) {
            Client client = getClientParId(id);
            if (client != null) {
                client.setNom(nom);
                client.setAdresse(adresse);
                client.setTelephone(telephone);
                System.out.println("Client mis à jour : " + client.getNom());
            } else {
                System.out.println("Mise à jour impossible : client introuvable.");
            }
        }

        // Méthode pour supprimer un client (Delete)
        public void supprimerClient(int id) {
            Client client = getClientParId(id);
            if (client != null) {
                clients.remove(client);
                System.out.println("Client supprimé : " + client.getNom());
            } else {
                System.out.println("Suppression impossible : client introuvable.");
            }
        }

        // Méthode pour récupérer la liste de tous les clients
        public List<Client> getTousLesClients() {
            return clients;
        }
    }


