package com.example.examfinaljava.classes;

import java.util.List;

public class Commande {
    private int id;
    private int  id_client;
    private List<Repas> repas;

    public Commande(int id, int  id_client, List<Repas> repas) {
        this.id = id;
        this.id_client = id_client;
        this.repas = repas;
    }

    public Commande() {
    }

    public int getId() {
        return id;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setId(int id) {
        this.id = id;
    }



    public List<Repas> getRepas() {
        return repas;
    }

    public void setRepas(List<Repas> repas) {
        this.repas = repas;
    }
    // Ajouter un repas à la commande
    public void ajouterRepas(Repas repas) {
        this.repas.add(repas);
    }

    // Calculer le total de la commande
    public double calculerTotalCommande() {
        double total = 0;
        for (Repas repas : repas) {
            total += repas.calculerTotal();
        }
        return total;
    }


}



