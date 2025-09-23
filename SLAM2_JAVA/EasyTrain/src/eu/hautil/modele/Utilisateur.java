package eu.hautil.modele;

import java.time.LocalDate;

public class Utilisateur {
    //TODO Ajouter les caractéristiques d'utilisateurs
        private int id;
        public String login;
        public String mdp;
        public String nom;
        public String prenom;
        public LocalDate dateEmbauche;
        public String role;
    //TODO Ajouter les fonctions d'utilisateurs
    //Getter et Setter


    public int getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getMdp() {
        return mdp;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;

    }
    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }
    public String getRole() {
        return role;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }
    public void setRole(String role) {
        this.role = role;
    }

    //TODO Ajouter les constructeurs d'utilisateurs
    public Utilisateur() {
        this.id = 0;
        this.login = "";
        this.mdp = "";
        this.nom = "";
        this.dateEmbauche = LocalDate.now(); //now est une fonction
        this.prenom = "";
        this.role = null;
    }
    public Utilisateur(int id,  String login, String mdp, String nom, LocalDate dateEmbauche, String role) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
        this.nom = nom;
        this.dateEmbauche = dateEmbauche;
        this.role = role;

    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateEmbauche=" + dateEmbauche +
                ", role='" + role + '\'' +
                '}';
    }
}
