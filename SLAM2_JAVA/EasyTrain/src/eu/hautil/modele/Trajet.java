package eu.hautil.modele;

import java.time.LocalDateTime;

public class Trajet {
    public String code;
    public LocalDateTime tempsDarret;
    public LocalDateTime tempsArriver;
    public String arretDepart;
    public String arretArriver;

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
    public String getArretArriver() {
        return arretArriver;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public void setTempsDarret(LocalDateTime tempsDarret) {
        this.tempsDarret = tempsDarret;
    }
    public void setTempsArriver(LocalDateTime tempsArriver) {
        this.tempsArriver = tempsArriver;
    }
    public void setArretDepart(String arretDepart) {
        this.arretDepart = arretDepart;
    }
    public void setArretArriver(String arretArriver) {
        this.arretArriver = arretArriver;
    }

}
