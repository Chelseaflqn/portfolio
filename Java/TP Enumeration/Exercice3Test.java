//Chelsea Florquin 28/05/2025
package tpEnumeration;

import tpEnumeration.Exercice3.Operation;

public class TestExercice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double  a = 8, b = 5;
		for (Operation op : Operation.values()) {
			System.out.println(op + ":" + op.appliquer(a, b));
		}
		
	}

}