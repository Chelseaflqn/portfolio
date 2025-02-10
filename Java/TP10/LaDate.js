//Chelsea Florquin BTS1 / 10/02/2025

package tp10;

public class LaDate {
	private int jour;
	private int mois;
	private int annee;

	public LaDate(int leJour, int leMois, int lAnnee) {
		this.jour = leJour;
		this.mois = leMois;
		this.annee = lAnnee;
	}
	public int getJour() {
		return jour;
	}
	public int getMois() {
		return mois;
	}
	public int getAnnee() {
		return annee; 
	}
	public String toString() {
		return "La date est : "+jour+"/"+mois+"/"+annee;
	}
	
}



