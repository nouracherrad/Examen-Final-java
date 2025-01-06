package com.example.examfinaljava.implementations;
import com.example.examfinaljava.classes.Supplement;

import java.util.ArrayList;
import java.util.List;
public class SupplementDAO {

        private List<Supplement> supplements;

        // Constructeur
        public SupplementDAO() {
            supplements = new ArrayList<>();
        }

        // CREATE : Ajouter un supplément
        public void ajouterSupplement(Supplement supplement) {
            supplements.add(supplement);
            System.out.println("Supplément ajouté : " + supplement);
        }

        // READ : Récupérer tous les suppléments
        public List<Supplement> getTousLesSupplements() {
            return supplements;
        }

        // READ : Récupérer un supplément par son ID
        public Supplement getSupplementParId(int id) {
            for (Supplement supplement : supplements) {
                if (supplement.getId() == id) {
                    return supplement;
                }
            }
            System.out.println("Supplément introuvable pour l'ID : " + id);
            return null;
        }

        // UPDATE : Modifier un supplément
        public boolean modifierSupplement(int id, String nouveauNom, double nouveauPrix) {
            Supplement supplement = getSupplementParId(id);
            if (supplement != null) {
                supplement.setNom(nouveauNom);
                supplement.setPrix(nouveauPrix);
                System.out.println("Supplément modifié : " + supplement);
                return true;
            }
            System.out.println("Modification échouée. Supplément introuvable.");
            return false;
        }

        // DELETE : Supprimer un supplément
        public boolean supprimerSupplement(int id) {
            Supplement supplement = getSupplementParId(id);
            if (supplement != null) {
                supplements.remove(supplement);
                System.out.println("Supplément supprimé : " + supplement);
                return true;
            }
            System.out.println("Suppression échouée. Supplément introuvable.");
            return false;
        }
    }

