//Chelsea Florquin 28/04/2025
package tpEnumeration;

public class Exercice2 {
	enum Niveau {
		FACILE (1), MOYEN(2), DIFFICILE(3);
		
		// déclaration attribut
		private int Valeur;
		
		//Constructeur
		
		Niveau (int Valeur){
		this.Valeur = Valeur;
		}
		public int GetValeur() {
			return Valeur;
		}
	}
}