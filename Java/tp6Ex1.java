//Chelsea FLORQUIN 06/01/2025
package tp6;

import java.util.ArrayList;

public class Tp6Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ArrayList<String> pays = new ArrayList <String> ();
	pays.add ("France");
	pays.add ("Italie");
	pays.add ("Espagne");
	pays.add ("Portugal");
	System.out.println("La liste pays contient"+pays.size()+"éléments");
	//pays.clear();
int n =pays.size();
if(n==0) {System.out.println("Erreur, la liste est vide");}
else {
	for(String element:pays) {System.out.println(element);}
	}
}
}