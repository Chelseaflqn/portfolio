package eu.hautil.modele;

import java.time.LocalDateTime;

public class Trajet {
    private String code;
    private LocalDateTime tempsDarret;
    private LocalDateTime tempsArriver;
    private Arret arretDepart;
    private Arret arretArrivee;

    //Constructeur par default

    public Trajet() {
        this.code = "";
        this.tempsDarret = LocalDateTime.now();
        this.tempsArriver = LocalDateTime.now();
        this.arretDepart = null;
        this.arretArrivee = null;
    }

    //Getter et Setter

    public String getCode() {
        return code;
    }

    public LocalDateTime getTempsDarret() {
        return tempsDarret;
    }

    public LocalDateTime getTempsArriver() {
        return tempsArriver; .
    }

    public String getArretDepart() {
        return arretDepart;
    }

    public String getArretArrivee() {
        return arretArriver;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTempsDarret(LocalDateTime tempsDarret) {
        this.tempsDarret = tempsDarret;
    }

    public void setTempsArrivee(LocalDateTime tempsArriver) {
        this.tempsArriver = tempsArriver;
    }

    public void setArretDepart(String arretDepart) {
        this.arretDepart = arretDepart;
    }

    public void setArretArriver(String arretArriver) {
        this.arretArriver = arretArriver;
    }

    //toString

    public String toString() {
        return "Trajet" + "code" + code

    }
}
