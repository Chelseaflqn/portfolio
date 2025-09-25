package eu.hautil;

import eu.hautil.modele.Utilisateur;
import java.time.LocalDate;
import eu.hautil.modele.Role;



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
        System.out.println(user);
        //TODO Modifier la valeur des attributs de l'utilisateur
        user.setId(1);
        user.setLogin("ChelseaF");
        user.setMdp("ABC123");
        user.setNom("FLORQUIN");
        user.setPrenom("Chelsea");
        user.setDateEmbauche(LocalDate.of(2025, 4, 19));
        user.setRole(Role.EMPLOYE);
        //TODO Afficher les infos de l'utilisateur
        System.out.println("Les informations sont : "+user);
        //TODO Créer un utilisateur avec le constructeurs à 7 arguments
        Utilisateur user2 =  new Utilisateur(2,"BellaS", "1234ABC", "SWAN", LocalDate.of(2026,5,20), Role.EMPLOYE);
        //TODO Afficher les informations de l'utilisateur
        System.out.println("Les informations de user2 sont : "+user2);
        //TODO Modifier la valeur des attributs de l'utilisateur
        user2.setPrenom("Rose");
        user2.setNom("Dawson");
        //TODO Afficher les informations de l'utilisateur
         System.out.println("Après modification les informations de l'utilistaeurs sont : "+user2);
    }
}