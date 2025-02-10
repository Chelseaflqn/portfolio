package tp10;

public class TestLaPersonne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LaPersonneLDN num1 = new LaPersonneLDN("Florquin",new LaDate(21,04,2004),"Nogent-sur-marne");
		LaPersonne num2 = new LaPersonne("Dome", new LaDate(19,04,2005));
		
		System.out.println ("Le nom est : " + num1.getNom());
		System.out.println ("La date de naissance est : " + num2.getNaissance());
		System.out.println (num1);
		System.out.println (num2);
	}
	

}