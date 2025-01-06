package com.example.examfinaljava.service;


import com.example.examfinaljava.classes.*;
import com.example.examfinaljava.implementations.ClientDAO;
import com.example.examfinaljava.implementations.PlatPrincipalDAO;
import com.example.examfinaljava.implementations.SupplementDAO;

import java.util.List;

public class RestaurantServiceImpl implements RestaurantService {

    private final ClientDAO clientDAO;
    private final PlatPrincipalDAO platPrincipalDAO;
    private final SupplementDAO supplementDAO;

    // Si besoin, on peut rajouter une gestion pour Commande et Repas

    public RestaurantServiceImpl() {
        this.clientDAO = new ClientDAO();
        this.platPrincipalDAO = new PlatPrincipalDAO();
        this.supplementDAO = new SupplementDAO();
    }

    // === Gestion des clients ===

    @Override
    public void ajouterClient(Client client) {
        clientDAO.ajouterClient(client);
    }

    @Override
    public Client retrouverClientParId(int clientId) {
        return clientDAO.getClientParId(clientId);
    }

    @Override
    public List<Client> listerTousLesClients() {
        return clientDAO.getTousLesClients();
    }

    // === Gestion des plats principaux ===

    @Override
    public void ajouterPlat(PlatPrincipal plat) {
        platPrincipalDAO.ajouterPlat(plat);
    }

    @Override
    public PlatPrincipal retrouverPlatParId(int platId) {
        return platPrincipalDAO.getPlatParId(platId);
    }

    @Override
    public List<PlatPrincipal> listerTousLesPlats() {
        return platPrincipalDAO.getTousLesPlats();
    }

    // === Gestion des suppléments ===

    @Override
    public void ajouterSupplement(Supplement supplement) {
        supplementDAO.ajouterSupplement(supplement);
    }

    @Override
    public Supplement retrouverSupplementParId(int supplementId) {
        return supplementDAO.getSupplementParId(supplementId);
    }

    @Override
    public List<Supplement> listerTousLesSupplements() {
        return supplementDAO.getTousLesSupplements();
    }

    // === Gestion des commandes === (si ajoutée)

    @Override
    public void creerCommande(Commande commande) {
        // Pour créer une commande -- Faux exemple si vous avez besoin d'ajouter la logique
        System.out.println("Commande créée : " + commande);
    }

    @Override
    public Commande retrouverCommandeParId(int commandeId) {
        // Implémentez la logique ici ou avec le DAO approprié (CommandeDAO)
        return null;
    }

    @Override
    public List<Commande> listerToutesLesCommandes() {
        // Implémentez la logique ici ou avec le DAO approprié (CommandeDAO)
        return null;
    }
}
