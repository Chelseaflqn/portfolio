package eu.hautil.modele;

public class Arret {
    private int id;
    private String nom;

    //Constructeur par default
    public Arret(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    //Getter et Setter
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int setId() {
        this.id = id;
    }

    public String setNom() {
        this.nom = nom;
    }
}