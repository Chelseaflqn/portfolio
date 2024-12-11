//Chelsea FLORQUIN BTS1 Octobre 2024
package ExoCoursTD;
import java.util.Scanner ;
public class Exo3tp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner masaisie=new Scanner(System.in);
		System.out.println("entrer un entier strictement posistif");
		int n = masaisie.nextInt();
		int m = n ; // sauvegarde de n pour affichage 
		int compteur=0;
		while (m%2==0) {
			compteur=compteur +1;
			m=m/2;
		}
	System.out.println("le nombre "+n+"est"+compteur+"fois diviser par 25");
	}

}

