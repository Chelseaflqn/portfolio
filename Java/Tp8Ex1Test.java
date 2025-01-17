//Chelsea Florquin BTS1/ 17/01/2025

package tp8;

public class TestCompte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompteBancaire moncompte=new CompteBancaire("hgt568n89",500.0);
		moncompte.depose(3);
		moncompte.afficherSolde();
		moncompte.retirer(550);
		moncompte.retirer(200);
		moncompte.afficherSolde();

	}

}