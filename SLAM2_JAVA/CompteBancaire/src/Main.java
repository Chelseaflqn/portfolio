//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    private String nom;
    private String prenom;
    private String Iban;
    private Double somme;

        public String getNom() {
        return this.nom;
    }
        public String getprenom() {
            return this.prenom;
        }
        public String getiban() {
            return this.iban;
        }
        public String getSomme() {
            return this.somme;
        }
        public String setNom() {
            return this.nom;
        }
        public String setprenom() {
            return this.prenom;
        }
        public String setiban() {
            return this.iban;
        }
        private String setSomme() {
            return this.somme;
        }
//Constructeur par défaut
        public CompteBancaire(){
            this.nom = "Inconnu";
            this.prenom = "Inconnu":
            this.iban = "000";
            this.somme = 000;

 //Constructeurs personnalisés
        public CompteBancaire(String n, String p, String i, Double s) {
            }


  //Retirer de l'argent
        public void retirerSomme(double retirer){
            this.somme=this.somme-retirer;
            }
   //Retirer de l'argent
         public void ajouterSomme(double ajout){
             this.somme=this.somme-ajout;
        }
    }