package com.example.examfinaljava.implementations;
import com.example.examfinaljava.classes.PlatPrincipal;

import java.util.ArrayList;
import java.util.List;
public class PlatPrincipalDAO {

        private List<PlatPrincipal> plats;

        // Constructeur
        public PlatPrincipalDAO() {
            plats = new ArrayList<>();
        }

        // CREATE : Ajouter un plat principal
        public void ajouterPlat(PlatPrincipal plat) {
            plats.add(plat);
            System.out.println("Plat ajouté : " + plat);
        }

        // READ : Récupérer tous les plats principaux
        public List<PlatPrincipal> getTousLesPlats() {
            return plats;
        }

        // READ : Récupérer un plat par son ID
        public PlatPrincipal getPlatParId(int id) {
            for (PlatPrincipal plat : plats) {
                if (plat.getId() == id) {
                    return plat;
                }
            }
            System.out.println("Plat introuvable pour l'ID : " + id);
            return null;
        }

        // UPDATE : Modifier un plat principal
        public boolean modifierPlat(int id, String nouveauNom, double nouveauPrix) {
            PlatPrincipal plat = getPlatParId(id);
            if (plat != null) {
                plat.setNom(nouveauNom);
                plat.setPrix(nouveauPrix);
                System.out.println("Plat modifié : " + plat);
                return true;
            }
            System.out.println("Modification échouée. Plat introuvable.");
            return false;
        }

        // DELETE : Supprimer un plat principal
        public boolean supprimerPlat(int id) {
            PlatPrincipal plat = getPlatParId(id);
            if (plat != null) {
                plats.remove(plat);
                System.out.println("Plat supprimé : " + plat);
                return true;
            }
            System.out.println("Suppression échouée. Plat introuvable.");
            return false;
        }
    }

