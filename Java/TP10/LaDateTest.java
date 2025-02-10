package tp10;

public class TestDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LaDate premier= new LaDate (10, 02, 2025);
	
	System.out.println ("Le jour est : " + premier.getJour());
	System.out.println ("Le mois est : " + premier.getMois());
	System.out.println ("L'année est : " + premier.getAnnee());
	System.out.println (premier.toString());
	}
	
	
	

}