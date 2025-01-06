package com.example.examfinaljava.classes;

import java.util.List;

public class Client {
    private int id;
    private String nom;
    private String adresse;
    private String telephone;
    private List<Commande> commandes ;


    public Client(int id, List<Commande> commandes, String telephone, String adresse, String nom) {
        this.id = id;
        this.commandes = commandes;
        this.telephone = telephone;
        this.adresse = adresse;
        this.nom = nom;
    }

    public void ajouterCommande(Commande commande) {
        commandes.add(commande);
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

}
