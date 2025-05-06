//Chelsea Florquin 28/04/2025
package tpEnumeration;

import tpEnumeration.Exercice2.Niveau;

public class TestExercice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Niveau niveau: Niveau.values()) {
			System.out.println("Niveau " + niveau.GetValeur()+" : "+niveau);
		}
		
	}

}