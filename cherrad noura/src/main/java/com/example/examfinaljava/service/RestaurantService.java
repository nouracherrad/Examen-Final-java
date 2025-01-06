package com.example.examfinaljava.service;


import com.example.examfinaljava.classes.Client;
import com.example.examfinaljava.classes.Commande;
import com.example.examfinaljava.classes.PlatPrincipal;
import com.example.examfinaljava.classes.Supplement;

import java.util.List;

public interface RestaurantService {

    // Gestion des clients
    void ajouterClient(Client client);
    Client retrouverClientParId(int clientId);
    List<Client> listerTousLesClients();

    // Gestion des plats principaux
    void ajouterPlat(PlatPrincipal plat);
    PlatPrincipal retrouverPlatParId(int platId);
    List<PlatPrincipal> listerTousLesPlats();

    // Gestion des suppléments
    void ajouterSupplement(Supplement supplement);
    Supplement retrouverSupplementParId(int supplementId);
    List<Supplement> listerTousLesSupplements();

    // Gestion des commandes
    void creerCommande(Commande commande);
    Commande retrouverCommandeParId(int commandeId);
    List<Commande> listerToutesLesCommandes();
}
