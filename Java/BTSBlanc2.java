Chelsea Florquin BTS 1 Décembre 2024
package sio1;
import java.util.Arrays;
public class ExamenBlanc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Déclaration et initialisation du tableau pays
		String [] pays= {"E.unis", "Chine", "Japon", "Austr", "France"};
		int [] or= {40,39,20,18,16};
		int [] argent= {44,27,12,19,26};
		int [] bronze= {42,24,13,16,22};
		int [] total = new int [5];
		// Initialiser a l'aide d'une boucle le tableau total 
		for(int i=0;i<total.length;i++) {
				total [i]= or [i]+ argent[i]+bronze[i];
		}
		System.out.printf("%10s","pays");
		System.out.printf("%4s","or");
		System.out.printf("%8s","argent");
		System.out.printf("%8s","bronze");
		System.out.printf("%8s","total");
		System.out.println();
		// On utilise la méthode toStrings de la classe Arrays pour afficher le tableau 
		System.out.println("total des médailles :"+Arrays.toString(total));
		// Compléter le programme pour qu'il produise le tableau de médailles demandé
        System.out.printf("%-10s %4s %8s %8s %8s%n", "Pays", "Or", "Argent", "Bronze", "Total");
        for (int i = 0; i < pays.length; i++) {
        System.out.printf("%-10s %4d %8d %8d %8d%&", pays[i], or[i], argent[i], bronze[i], total[i]);
        }
		
	}

}