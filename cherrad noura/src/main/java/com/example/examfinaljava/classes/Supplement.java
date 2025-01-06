package com.example.examfinaljava.classes;

public class Supplement {
    private int id;
    private String nom;
    private double prix;

    public Supplement(int id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }


        // Getters et Setters
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

        // Méthode toString pour afficher les informations d’un supplément
        @Override
        public String toString() {
            return "Supplement [ID=" + id + ", Nom=" + nom + ", Prix=" + prix + "]";
        }
    }

