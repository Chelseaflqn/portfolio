package tp10;

public class LaPersonne {
	protected String nom;
	protected LaDate naissance; 

	public LaPersonne(String leNom, LaDate DateNaissance) {
	this.nom = leNom;
	this.naissance = DateNaissance;
	}
	public String getNom() {
		return nom;
	}
	public LaDate getNaissance() {
		return naissance; 
	}
	public String toString() {
		return "Le nom est " +nom+ " et "+naissance;
		
	}
}


class LaPersonneLDN extends LaPersonne{
	protected String lieu;
	
	public LaPersonneLDN(String leNom, LaDate DateNaissance, String leLieu) {
        super(leNom, DateNaissance); 
        this.lieu = leLieu;
		
	}
	
	public String getLieu() {
		return lieu; 
	}

	@override
	public String toString() {
		return super.toString() +" le lieu de naissance est "+lieu;
	}
}

