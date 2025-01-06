package com.example.examfinaljava.classes;

import java.util.List;

public class Repas {
    private PlatPrincipal platPrincipal;
    private List<Supplement> supplements;
    private List<Ingredient> ingredients;

    public Repas(PlatPrincipal platPrincipal, List<Supplement> supplements, List<Ingredient> ingredients) {
        this.platPrincipal = platPrincipal;
        this.supplements = supplements;
        this.ingredients = ingredients;
    }

    public PlatPrincipal getPlatPrincipal() {
        return platPrincipal;
    }

    public void setPlatPrincipal(PlatPrincipal platPrincipal) {
        this.platPrincipal = platPrincipal;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Supplement> getSupplements() {
        return supplements;
    }

    public void setSupplements(List<Supplement> supplements) {
        this.supplements = supplements;
    }

    // Ajouter un supplément au repas
    public void ajouterSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    // Calculer le total du repas
    public double calculerTotal() {
        double total = platPrincipal.calculerPrix();
        for (Supplement supplement : supplements) {
            total += supplement.getPrix();
        }
        return total;
    }


}
