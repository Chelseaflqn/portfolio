package eu.hautil;

import eu.hautil.modele.Utilisateur;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("EasyTrain 1");
        //TODO Créer un utilisateur avec le constructeur par défaut
        Utilisateur user = new Utilisateur(); // Appel du constructeur par défaut
        System.out.println("Utilisateur nom : "+user.getNom()+" id : "+user.getId()+" dateEmbauche : "+user.getDateEmbauche()+" prenom : "+user.getPrenom()+" role : "+user.getRole());
        System.out.println(user);
        //TODO Afficher info de l'utilisateur
        //TODO Modifier la valeur des attributs de l'utilisateur
        //TODO Afficher les infos de l'utilisateur
        //TODO Créer un utilisateur avec le constructeurs à 7 arguments
        //TODO Afficher les informations de l'utilisateur
        //TODO Modifier la valeur des attributs de l'utilisateur
        //TODO Afficher les informations de l'utilisateur
    }
}