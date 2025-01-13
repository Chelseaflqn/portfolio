//Chelsea Florquin BTS 1 / 6/01/2025
package tp6;

import java.util.ArrayList;
import java.lang.Math ;
public class Tp6Ex2 {

	static ArrayList <Integer> divisor (int n) {
		
	ArrayList <Integer> divise = new ArrayList<Integer>();	
		int m= (int) Math.sqrt(n);
		int d=1;
	while (d<=m) {
		if (n%d==0) {
			divise.add(d);
			int q=n/d ;
			divise.add(q);
		}
		d+=1;
	}
	return divise ;
		}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     for(int i=5;i<=15;i++)System.out.println(divisor(i));
	}

}
