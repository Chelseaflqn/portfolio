//Chelsea Florquin BTS1/ 17/01/2025

package tp8;

public class Rectangle {
	 double longueur;
	 double largeur;

	  public Rectangle(double longue, double large) {
	        this.longueur = longue;
	        this.largeur = large;
	  }

	  //Calculer l'aire
	  double calculerAire() {
		  return longueur*largeur ; 
	  }
	  //Calculer le perimetre
	   double calculerPerimetre() {
	        return 2 * (longueur+largeur);
	   }
	  //Afficher les dimensions
	  void afficherDetails() {
		  System.out.println("Longueur : " + longueur );
		  System.out.println("Largeur : " + largeur );
		  System.out.println("Aire : " + calculerAire() );
		  System.out.println("Périmètre : " + calculerPerimetre() );
	  }
}