package com.example.examfinaljava.implementations;

import com.example.examfinaljava.classes.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class IngredientDAO {

        private List<Ingredient> ingredients;

        // Constructeur
        public IngredientDAO() {
            ingredients = new ArrayList<>();
        }

        // CREATE : Ajouter un ingrédient
        public void ajouterIngredient(Ingredient ingredient) {
            ingredients.add(ingredient);
            System.out.println("Ingrédient ajouté : " + ingredient);
        }

        // READ : Récupérer tous les ingrédients
        public List<Ingredient> getTousLesIngredients() {
            return ingredients;
        }

        // READ : Récupérer un ingrédient par son ID
        public Ingredient getIngredientParId(int id) {
            for (Ingredient ingredient : ingredients) {
                if (ingredient.getId() == id) {
                    return ingredient;
                }
            }
            System.out.println("Ingrédient introuvable pour l'ID : " + id);
            return null;
        }

        // UPDATE : Modifier un ingrédient
        public boolean modifierIngredient(int id, String nouveauNom, double nouvelleQuantite) {
            Ingredient ingredient = getIngredientParId(id);
            if (ingredient != null) {
                ingredient.setNom(nouveauNom);
                ingredient.setQuantite(nouvelleQuantite);
                System.out.println("Ingrédient modifié : " + ingredient);
                return true;
            }
            System.out.println("Modification échouée. Ingrédient introuvable.");
            return false;
        }

        // DELETE : Supprimer un ingrédient
        public boolean supprimerIngredient(int id) {
            Ingredient ingredient = getIngredientParId(id);
            if (ingredient != null) {
                ingredients.remove(ingredient);
                System.out.println("Ingrédient supprimé : " + ingredient);
                return true;
            }
            System.out.println("Suppression échouée. Ingrédient introuvable.");
            return false;
        }
    }
