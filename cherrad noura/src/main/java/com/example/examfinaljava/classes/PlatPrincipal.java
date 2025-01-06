package com.example.examfinaljava.classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlatPrincipal {

    private int id;
    private String nom;
    private double prix;
    private Map<Ingredient, Double>  ingredients;

    public PlatPrincipal(int id, String nom, double prix, List<Ingredient> ingredients) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.ingredients = new HashMap<>();
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    public Map<Ingredient, Double> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<Ingredient, Double> ingredients) {
        this.ingredients = ingredients;
    }

    public void ajouterIngredient(Ingredient ingredient, double quantite) {
        ingredients.put(ingredient, quantite);
    }

    // Calculer le prix total du plat principal
    public double calculerPrix() {
        double total = prix;
        for (Map.Entry<Ingredient, Double> entry : ingredients.entrySet()) {
            total += entry.getKey().getPrixUnitaire() * entry.getValue(); // Prix unitaire * quantité
        }
        return total;
    }
}
