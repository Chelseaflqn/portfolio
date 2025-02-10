//Chelsea Florquin BTS1 / 17/01/2025

package tp8;

public class CompteBancaire {
    String numeroCompte;
    Double solde;

    // Constructeur
    public CompteBancaire(String numeroDeCompte, double leSolde) {
        this.numeroCompte = numeroDeCompte;
        this.solde = leSolde;
    }

    // Déposer un montant
    void depose(double montant) {
        System.out.println("Effectuer un dépôt");
        solde += montant;
    }

    //Retirer un montant
    void retirer(double montant) {
    	if (montant > solde) {
            System.out.println("Fonds insuffisants");
    	}
    	else {
    		solde-=montant ;
    		System.out.println("Vous avez retiré :"+montant+"€");
    	}
        
        }
    

    // Afficher le solde
    void afficherSolde() {
        System.out.println("Le solde actuel est : " + solde);
    }
}